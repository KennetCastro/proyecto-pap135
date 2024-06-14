package modelos;

import java.time.LocalDateTime;

public class Transaccion {
    private double monto;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private LocalDateTime fecha;

    public Transaccion(double monto, Cuenta cuentaOrigen, Cuenta cuentaDestino, LocalDateTime fecha) {
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fecha = fecha;
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
