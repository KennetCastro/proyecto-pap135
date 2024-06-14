package modelos;

public class Transaccion {
    private double monto;
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    public Transaccion(double monto, CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }
}
