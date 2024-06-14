package modelos;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int id;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, int id) {
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

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Double consultarSaldo(Cuenta cuenta) {
        if (cuentas.contains(cuenta)) {
            return cuenta.getSaldo();
        } else {
            return null;
        }
    }
}