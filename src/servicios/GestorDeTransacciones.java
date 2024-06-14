package servicios;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTransacciones {
    private List<Transaccion> historialTransacciones;

    public GestorDeTransacciones() {
        historialTransacciones = new ArrayList<>();
    }

    public void registrarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.depositar(monto);
        historialTransacciones.add(new Transaccion(monto, null, cuenta));
        System.out.println("Depósito registrado: " + monto + " a la cuenta " + cuenta.getNumeroCuenta());
    }

    public void registrarRetiro(CuentaBancaria cuenta, double monto) {
        cuenta.retirar(monto);
        historialTransacciones.add(new Transaccion(monto, cuenta, null));
        System.out.println("Retiro registrado: " + monto + " de la cuenta " + cuenta.getNumeroCuenta());
    }

    public void registrarTransferencia(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, double monto) {
        cuentaOrigen.transferir(monto, cuentaDestino);
        historialTransacciones.add(new Transaccion(monto, cuentaOrigen, cuentaDestino));
        System.out.println("Transferencia registrada: " + monto + " de la cuenta " + cuentaOrigen.getNumeroCuenta() + " a la cuenta " + cuentaDestino.getNumeroCuenta());
    }

    public void mostrarHistorial() {
        for (Transaccion t : historialTransacciones) {
            if (t.getCuentaOrigen() == null) {
                System.out.println("Depósito de " + t.getMonto() + " a la cuenta " + t.getCuentaDestino().getNumeroCuenta());
            } else if (t.getCuentaDestino() == null) {
                System.out.println("Retiro de " + t.getMonto() + " de la cuenta " + t.getCuentaOrigen().getNumeroCuenta());
            } else {
                System.out.println("Transferencia de " + t.getMonto() + " de la cuenta " + t.getCuentaOrigen().getNumeroCuenta() + " a la cuenta " + t.getCuentaDestino().getNumeroCuenta());
            }
        }
    }
}