package servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import modelos.Cuenta;
import modelos.Transaccion;

public class GestorDeTransacciones {
    private BancoDB bancoDB;

    public GestorDeTransacciones(BancoDB bancoDB) {
        this.bancoDB = bancoDB;
    }

    public void registrarDeposito(Cuenta cuenta, double monto) {
        cuenta.depositar(monto);
        List<Transaccion> historial = bancoDB.getTransacciones().get(cuenta.getNumCuenta());
        historial.add(new Transaccion(monto, null, cuenta, LocalDateTime.now()));
        System.out.println("\tDepósito registrado: $" + monto + " a la cuenta " + cuenta.getNumCuenta());
        System.out.println("\tNuevo saldo: $" + cuenta.getSaldo());
    }

    public void registrarRetiro(Cuenta cuenta, double monto) {
        if (cuenta.getSaldo() < monto) {        	
        	System.out.println("\nSaldo insuficiente: $" + cuenta.getSaldo());
        	return;
        }
        cuenta.retirar(monto);
        List<Transaccion> historial = bancoDB.getTransacciones().get(cuenta.getNumCuenta());
        historial.add(new Transaccion(monto, cuenta, null, LocalDateTime.now()));
        System.out.println("\tRetiro registrado: $" + monto + " de la cuenta " + cuenta.getNumCuenta());
        System.out.println("\tNuevo saldo: $" + cuenta.getSaldo());
    }

    public void registrarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
    	if (cuentaOrigen.getSaldo() < monto) {
    		System.out.println("\nSaldo insuficiente: $" + cuentaOrigen.getSaldo());
        	return;
    	}
        cuentaOrigen.transferir(cuentaDestino, monto);
        List<Transaccion> historialOrigen = bancoDB.getTransacciones().get(cuentaOrigen.getNumCuenta());
        LocalDateTime fecha = LocalDateTime.now();
        historialOrigen.add(new Transaccion(monto, cuentaOrigen, cuentaDestino, fecha));
        List<Transaccion> historialDestino = bancoDB.getTransacciones().get(cuentaDestino.getNumCuenta());
        historialDestino.add(new Transaccion(monto, cuentaOrigen, cuentaDestino, fecha));
        System.out.println("\tTransferencia registrada: $" + monto 
        		+ " de la cuenta " + cuentaOrigen.getNumCuenta() 
        		+ " a la cuenta " + cuentaDestino.getNumCuenta());
    }

    public void mostrarHistorial(Integer numCuenta) {
    	List<Transaccion> historial = bancoDB.getTransacciones().get(numCuenta);
    	if (historial == null) {return;}
    	
    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        for (Transaccion t : historial) {
            if (t.getCuentaOrigen() == null) {
                System.out.println("\tDepósito de $" + t.getMonto() + " el " + t.getFecha().format(formatoFecha));
            } else if (t.getCuentaDestino() == null) {
                System.out.println("\tRetiro de $" + t.getMonto() + " el " + t.getFecha().format(formatoFecha));
            } else {
                System.out.println("\tTransferencia de $" + t.getMonto() 
                	+ "de la cuenta " + t.getCuentaOrigen().getNumCuenta()
                	+ " a la cuenta " + t.getCuentaDestino().getNumCuenta() 
                	+ " el " + t.getFecha().format(formatoFecha));
            }
        }
    }
}