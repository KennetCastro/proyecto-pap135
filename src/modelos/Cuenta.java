package modelos;

public class Cuenta {
    private int numCuenta;
    private String titular;
    private double saldo;
    private boolean activa;

    // Constructor
    public Cuenta(int numCuenta, String titular, double saldo, boolean activa) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.activa = activa;
    }

    // Getters y Setters
    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    // Métodos para operaciones
    public void depositar(double monto) {
        if (activa) {
            saldo += monto;
        } else {
            System.out.println("La cuenta está inactiva.");
        }
    }

    public void retirar(double monto) {
        if (activa) {
            if (saldo >= monto) {
                saldo -= monto;
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("La cuenta está inactiva.");
        }
    }

    public void transferir(Cuenta otraCuenta, double monto) {
        if (activa) {
            if (saldo >= monto) {
                this.retirar(monto);
                otraCuenta.depositar(monto);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("La cuenta está inactiva.");
        }
    }
}

