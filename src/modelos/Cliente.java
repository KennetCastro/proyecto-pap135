package modelos;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String id;
    private ArrayList<CuentaBancaria> cuentas;

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public Double consultarSaldo(CuentaBancaria cuenta) {
        if (cuentas.contains(cuenta)) {
            return cuenta.getSaldo();
        } else {
            return null;
        }
    }
}