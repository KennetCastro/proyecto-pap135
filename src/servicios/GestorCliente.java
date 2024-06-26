package servicios;

import modelos.Cliente;
import modelos.Cuenta;

public class GestorCliente {
    private BancoDB bancoDB;

    public GestorCliente(BancoDB bancoDB) {
        this.bancoDB = bancoDB;
    }

    public void crearCliente(String nombre, int id) {
        if (!bancoDB.getClientes().containsKey(id)) {
            Cliente nuevoCliente = new Cliente(nombre, id);
            bancoDB.getClientes().put(id, nuevoCliente);
        } else {
            System.out.println("El número de Cliente ya existe.");
        }
    }

    public Cliente buscarCliente(int id) {
    	return bancoDB.getClientes().get(id);
    }

    public void modificarCliente(int id, String nuevoNombre) {
        Cliente cliente = bancoDB.getClientes().get(id);
        if (cliente != null) {
            cliente.setNombre(nuevoNombre);
            for (Cuenta cuenta : cliente.getCuentas()) {
            	cuenta.setTitular(nuevoNombre);
            }
        } else {
            System.out.println("El Cliente no existe.");
        }
    }

    public void borrarCliente(int id) {
        if (bancoDB.getClientes().containsKey(id)) {
            bancoDB.getClientes().remove(id);
        } else {
            System.out.println("El Cliente no existe.");
        }
    }
}