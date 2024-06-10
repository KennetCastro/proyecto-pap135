package servicios;


import java.util.HashMap;
import java.util.Map;
import modelos.Cuenta;

public class GestionCuenta {
    private Map<Integer, Cuenta> Cuentas;

    public GestionCuenta() {
        Cuentas = new HashMap<>();
    }

    // Crear una nueva Cuenta
    public void crearCuenta(int numCuenta, String titular, double saldo, boolean activa) {
        if (!Cuentas.containsKey(numCuenta)) {
            Cuenta nuevaCuenta = new Cuenta(numCuenta, titular, saldo, activa);
            Cuentas.put(numCuenta, nuevaCuenta);
        } else {
            System.out.println("El número de Cuenta ya existe.");
        }
    }

    // Buscar Cuenta por número de Cuenta
    public Cuenta buscarCuenta(int numCuenta) {
        return Cuentas.get(numCuenta);
    }

    // Modificar una Cuenta existente
    public void modificarCuenta(int numCuenta, String nuevoTitular, double nuevoSaldo, boolean nuevaActiva) {
        Cuenta Cuenta = Cuentas.get(numCuenta);
        if (Cuenta != null) {
            Cuenta.setTitular(nuevoTitular);
            Cuenta.setSaldo(nuevoSaldo);
            Cuenta.setActiva(nuevaActiva);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }

    // Borrar una Cuenta existente
    public void borrarCuenta(int numCuenta) {
        if (Cuentas.containsKey(numCuenta)) {
            Cuentas.remove(numCuenta);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }

    // Bloquear una Cuenta
    public void bloquearCuenta(int numCuenta) {
        Cuenta Cuenta = Cuentas.get(numCuenta);
        if (Cuenta != null) {
            Cuenta.setActiva(false);
        } else {
            System.out.println("La Cuenta no existe.");
        }
    }
}

	