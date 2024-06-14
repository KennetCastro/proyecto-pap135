package servicios;
import java.util.HashMap;
import modelos.*;

public class BancoDB {
	// Hashmap de String hasta que se creen las clases correspondientes
	
	private static HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	private static HashMap<Integer, Cuenta> cuentas = new HashMap<Integer, Cuenta>();
	private static HashMap<Integer, String> transacciones = new HashMap<Integer, String>();
	
	public BancoDB() {}
	
	public HashMap<Integer, Cuenta> getCuentas() {
		return cuentas;
	}

	public HashMap<Integer, Cliente> getClientes() {
		return clientes;
	}

}
