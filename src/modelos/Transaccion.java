package modelos;

public class Transaccion {
    private double monto;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public Transaccion(double monto, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }
}
