package servicios;
public class GestorCliente {
    private BancoDB bancoDB;

    public GestorCliente(BancoDB bancoDB) {
        this.bancoDB = bancoDB;
    }

    public Cliente crearCliente(String nombre, String id) {
        Cliente cliente = new Cliente(nombre, id);
        bancoDB.agregarCliente(cliente);
        return cliente;
    }

    public Cliente buscarCliente(String id) {
        return bancoDB.buscarCliente(id);
    }

    public void modificarCliente(Cliente cliente, String nuevoNombre) {
        cliente.setNombre(nuevoNombre);
        bancoDB.modificarCliente(cliente);
    }

    public void borrarCliente(String id) {
        bancoDB.eliminarCliente(id);
    }
}