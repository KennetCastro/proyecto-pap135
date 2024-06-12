package servicios;


import modelos.Cuenta;


public class GestionCuenta {
    private BancoDB bancoDB;

    public GestionCuenta(BancoDB bancoDB) {
        this.bancoDB = bancoDB;
    }

    // Crear una nueva Cuenta
    public void crearCuenta(int numCuenta, String titular, double saldo, boolean activa) {
        if (!bancoDB.getCuentas().containsKey(numCuenta)) {
            Cuenta nuevaCuenta = new Cuenta(numCuenta, titular, saldo, activa);
            bancoDB.getCuentas().put(numCuenta, nuevaCuenta);
        } else {
            System.out.println("El número de Cuenta ya existe.");
        }
    }

    // Buscar Cuenta por número de Cuenta
    public Cuenta buscarCuenta(int numCuenta) {
        return bancoDB.getCuentas().get(numCuenta);
    }

    // Modificar una Cuenta existente
    public void modificarCuenta(int numCuenta, String nuevoTitular, boolean nuevaActiva) {
        Cuenta cuenta = bancoDB.getCuentas().get(numCuenta);
        if (cuenta != null) {
            cuenta.setTitular(nuevoTitular);
            cuenta.setActiva(nuevaActiva);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }

    // Borrar una Cuenta existente
    public void borrarCuenta(int numCuenta) {
        if (bancoDB.getCuentas().containsKey(numCuenta)) {
            bancoDB.getCuentas().remove(numCuenta);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }

    // Bloquear una Cuenta
    public void bloquearCuenta(int numCuenta) {
        Cuenta cuenta = bancoDB.getCuentas().get(numCuenta);
        if (cuenta != null) {
            cuenta.setActiva(false);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }
}

	