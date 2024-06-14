package servicios;

import modelos.Cliente;

public class GestorCliente {
    private BancoDB bancoDB;

    public GestorCliente(BancoDB bancoDB) {
        this.bancoDB = bancoDB;
    }

    public Cliente crearCliente(String nombre, int id) {
        Cliente cliente = new Cliente(nombre, id);
        bancoDB.agregarCliente(cliente);
        return cliente;
    }

    public Cliente buscarCliente(int id) {
        return bancoDB.buscarCliente(id);
    }

    public void modificarCliente(Cliente cliente, String nuevoNombre) {
        cliente.setNombre(nuevoNombre);
        bancoDB.modificarCliente(cliente);
    }

    public void borrarCliente(int id) {
        bancoDB.eliminarCliente(id);
    }
}