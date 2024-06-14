package servicios;

import java.util.ArrayList;
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
        historial.add(new Transaccion(monto, null, cuenta));
        System.out.println("Depósito registrado: " + monto + " a la cuenta " + cuenta.getNumCuenta());
    }

    public void registrarRetiro(Cuenta cuenta, double monto) {
        cuenta.retirar(monto);
        List<Transaccion> historial = bancoDB.getTransacciones().get(cuenta.getNumCuenta());
        historial.add(new Transaccion(monto, cuenta, null));
        System.out.println("Retiro registrado: " + monto + " de la cuenta " + cuenta.getNumCuenta());
    }

    public void registrarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        cuentaOrigen.transferir(monto, cuentaDestino);
        List<Transaccion> historial = bancoDB.getTransacciones().get(cuentaOrigen.getNumCuenta());
        historial.add(new Transaccion(monto, cuentaOrigen, cuentaDestino));
        System.out.println("Transferencia registrada: " + monto + " de la cuenta " + cuentaOrigen.getNumCuenta() + " a la cuenta " + cuentaDestino.getNumCuenta());
    }

    public void mostrarHistorial(Cuenta cuenta) {
    	List<Transaccion> historial = bancoDB.getTransacciones().get(cuenta.getNumCuenta());
        for (Transaccion t : historial) {
            if (t.getCuentaOrigen() == null) {
                System.out.println("Depósito de " + t.getMonto() + " a la cuenta " + t.getCuentaDestino().getNumCuenta());
            } else if (t.getCuentaDestino() == null) {
                System.out.println("Retiro de " + t.getMonto() + " de la cuenta " + t.getCuentaOrigen().getNumCuenta());
            } else {
                System.out.println("Transferencia de " + t.getMonto() + " de la cuenta " + t.getCuentaOrigen().getNumCuenta() + " a la cuenta " + t.getCuentaDestino().getNumCuenta());
            }
        }
    }
}