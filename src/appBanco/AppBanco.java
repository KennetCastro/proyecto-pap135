package appBanco;

import java.util.Scanner;

import modelos.Cliente;
import modelos.Cuenta;
import servicios.BancoDB;
import servicios.GestionCuenta;
import servicios.GestorCliente;
import servicios.GestorDeTransacciones;



public class AppBanco {
	private static BancoDB bancoDB = new BancoDB();
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcion;
		do {
			// Mostrar menú principal
			System.out.println("\n=== Menú principal de AppBanco ===");
			System.out.println("1. Gestión de clientes");
			System.out.println("2. Gestión de cuentas");
			System.out.println("3. Gestión de transacciones");
			System.out.println("4. Historial de transacciones");
			System.out.println("5. Salir");
			
			// Manejar el menú principal
			opcion = getOpcion(entrada);
			
			switch (opcion) {
				case 1:
					gestionarClientes(entrada);
					break;
				case 2:
					gestionarCuentas(entrada);
					break;
				case 3:
					gestionarTransacciones(entrada);
					break;
				case 4:
					HistorialTransacciones(entrada);
					break;
				case 5:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("\nOpción no válida, vuelva a intentar");
			}
		} while (opcion != 5);
		
		entrada.close();
	}
	
	public static void gestionarClientes(Scanner entrada) {
		int opcion;
		do {
			System.out.println("\n--- Gestión de clientes ---");
			System.out.println("1. Añadir cliente");
			System.out.println("2. Ver cliente");
			System.out.println("3. Actualizar cliente");
			System.out.println("4. Eliminar cliente");
			System.out.println("5. Volver al menú principal");
			opcion = getOpcion(entrada);
			
			GestorCliente gestor = new GestorCliente(bancoDB);
			int id;
			String nombre;
			Cliente cliente;
			switch (opcion) {
				case 1:
					System.out.print("Nombre: ");
					nombre = entrada.next();
					System.out.print("Número de identificación: ");
					id = entrada.nextInt();
					System.out.print("Número de cuenta: ");
					int numCuenta = entrada.nextInt();
					GestionCuenta gestorCuenta = new GestionCuenta(bancoDB);
					if (gestorCuenta.buscarCuenta(numCuenta) == null) {
						gestor.crearCliente(nombre, id);
						System.out.print("Saldo inicial: ");
						double saldo = entrada.nextDouble();
						gestorCuenta.crearCuenta(numCuenta, nombre, id, saldo, true);
						cliente = gestor.buscarCliente(id);
						cliente.agregarCuenta(gestorCuenta.buscarCuenta(numCuenta));
					}
					break;
				case 2:
					System.out.print("Número de identificación: ");
					id = entrada.nextInt();
					cliente = gestor.buscarCliente(id);
					if (cliente != null) {
						System.out.println("\tNombre: " + cliente.getNombre());
						System.out.println("\tNúmero de identificación: " + cliente.getId());						
						System.out.println("\tCuentas: " + cliente.getCuentas().size());						
					} else {						
						System.out.println("\nEl Cliente no existe.");						
					}
					break;
				case 3:
					System.out.print("Número de identificación: ");
					id = entrada.nextInt();
					System.out.print("Nombre: ");
					nombre = entrada.next();
					gestor.modificarCliente(id, nombre);
					break;
				case 4:
					System.out.print("Número de identificación: ");
					id = entrada.nextInt();
					gestor.borrarCliente(id);
					break;
				case 5:
					break;
				default:
					System.out.println("\nOpción no válida, vuelva a intentar");
			}
		} while (opcion != 5);
	}
	
	public static void gestionarCuentas(Scanner entrada) {
		int opcion;
		do {
			System.out.println("\n--- Gestión de cuentas ---");
			System.out.println("1. Añadir cuenta");
			System.out.println("2. Ver cuenta");
			System.out.println("3. Actualizar cuenta");
			System.out.println("4. Eliminar cuenta");
			System.out.println("5. Volver al menú principal");
			opcion = getOpcion(entrada);
			
			GestionCuenta gestor = new GestionCuenta(bancoDB);
			GestorCliente gestorCliente = new GestorCliente(bancoDB);
			int numCuenta;
			String nombre;
			Double saldo;
			Cuenta cuenta;
			Cliente cliente;
			int titularID;
			switch (opcion) {
				case 1:
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					if (gestor.buscarCuenta(numCuenta) == null) {
						System.out.print("Número de identificación del titular: ");
						titularID = entrada.nextInt();
						cliente = gestorCliente.buscarCliente(titularID);
						if (cliente == null) {
							System.out.print("\nEl Cliente no existe. ");
							break;
						}
						nombre = cliente.getNombre();
						System.out.print("Saldo inicial: ");
						saldo = entrada.nextDouble();
						entrada.nextLine();
						gestor.crearCuenta(numCuenta, nombre, titularID, saldo, true);
						cliente.agregarCuenta(gestor.buscarCuenta(numCuenta));
					} else {
						System.out.println("\nEl número de cuenta ya existe.");
					}
					break;
				case 2:
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					cuenta = gestor.buscarCuenta(numCuenta);
					if (cuenta != null) {
						System.out.println("\tNúmero de cuenta: " + cuenta.getNumCuenta());
						System.out.println("\tTitular: " + cuenta.getTitular());
						System.out.println("\tSaldo: $" + cuenta.getSaldo());
						System.out.println("\tEstado: " + (cuenta.isActiva() ? "Activa":"Bloqueada"));
					} else {
						System.out.println("\nLa Cuenta no existe.");
					}
					break;
				case 3:
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					System.out.print("Número de identificación del titular: ");
					titularID = entrada.nextInt();
					cliente = gestorCliente.buscarCliente(titularID);
					if (cliente == null) {
						System.out.print("\nEl Cliente no existe. ");
						break;
					}
					nombre = cliente.getNombre();
					System.out.print("¿Desea bloquear la cuenta? (true/false): ");
					Boolean bloquear = entrada.nextBoolean();
					gestor.modificarCuenta(numCuenta, nombre, titularID, !bloquear);
					break;
				case 4:
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					gestor.borrarCuenta(numCuenta);
					break;
				case 5:
					break;
				default:
					System.out.println("\nOpción no válida, vuelva a intentar");
			}
		} while (opcion != 5);
	}
	
	public static void gestionarTransacciones(Scanner entrada) {
		int opcion;
		do {
			System.out.println("\n--- Gestión de transacciones ---");
			System.out.println("1. Depositar");
			System.out.println("2. Retirar");
			System.out.println("3. Transferir");
			System.out.println("4. Volver al menú principal");
			opcion = getOpcion(entrada);
			
			GestorDeTransacciones gestorTransacciones;
			GestionCuenta gestorCuenta;
			int numCuenta;
			double monto;
			Cuenta cuenta;
			switch (opcion) {
				case 1:
					gestorCuenta = new GestionCuenta(bancoDB);
					gestorTransacciones = new GestorDeTransacciones(bancoDB);
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					cuenta = gestorCuenta.buscarCuenta(numCuenta);
					if (cuenta == null) {
						System.out.print("\nLa Cuenta no existe.");
						break;
					}
					System.out.print("Monto a depositar: ");
					monto = entrada.nextDouble();
					gestorTransacciones.registrarDeposito(cuenta, monto);
					break;
				case 2:
					gestorCuenta = new GestionCuenta(bancoDB);
					gestorTransacciones = new GestorDeTransacciones(bancoDB);
					System.out.print("Número de cuenta: ");
					numCuenta = entrada.nextInt();
					cuenta = gestorCuenta.buscarCuenta(numCuenta);
					if (cuenta == null) {
						System.out.print("\nLa Cuenta no existe.");
						break;
					}
					System.out.print("Monto a retirar: ");
					monto = entrada.nextDouble();
					gestorTransacciones.registrarRetiro(cuenta, monto);
					break;
				case 3:
					gestorCuenta = new GestionCuenta(bancoDB);
					gestorTransacciones = new GestorDeTransacciones(bancoDB);
					System.out.print("Número de cuenta de origen: ");
					numCuenta = entrada.nextInt();
					cuenta = gestorCuenta.buscarCuenta(numCuenta);
					if (cuenta == null) {
						System.out.print("\nLa Cuenta no existe.");
						break;
					}
					
					System.out.print("Número de cuenta de destino: ");
					int numCuenta2 = entrada.nextInt();
					Cuenta cuenta2 = gestorCuenta.buscarCuenta(numCuenta2);
					if (cuenta2 == null) {
						System.out.print("\nLa Cuenta no existe.");
						break;
					}
					System.out.print("Monto a transferir: ");
					monto = entrada.nextDouble();
					gestorTransacciones.registrarTransferencia(cuenta, cuenta2, monto);;
					break;
				case 4:
					break;
				default:
					System.out.println("\nOpción no válida, vuelva a intentar");
			}
		} while (opcion != 4);
	}
	
	public static void HistorialTransacciones(Scanner entrada) {
		int opcion;
		do {
			System.out.println("\n--- Historial de transacciones ---");
			System.out.println("1. Ver transacciones de cliente");
			System.out.println("2. Ver transacciones de cuenta");
			System.out.println("3. Volver al menú principal");
			opcion = getOpcion(entrada);
			
			int clienteID;
			int cuentaID;
			GestorCliente gestorCliente = new GestorCliente(bancoDB);
			GestorDeTransacciones gestorTransacciones = new GestorDeTransacciones(bancoDB);
			switch (opcion) {
				case 1:
					System.out.print("Número de identificación: ");
					clienteID = entrada.nextInt();
					Cliente cliente = gestorCliente.buscarCliente(clienteID);
					for (Cuenta cuenta : cliente.getCuentas()) {
						System.out.println("Cuenta: " + cuenta.getNumCuenta());
						gestorTransacciones.mostrarHistorial(cuenta.getNumCuenta());
					}
					break;
				case 2:
					System.out.print("Número de cuenta: ");
					cuentaID = entrada.nextInt();
					gestorTransacciones.mostrarHistorial(cuentaID);
					break;
				case 3:
					break;
				default:
					System.out.println("\nOpción no válida, vuelva a intentar");
			}
		} while (opcion != 3);
	}
	
	public static int getOpcion(Scanner entrada) {
		System.out.print("Seleccione una opción: ");
		int opcion = entrada.nextInt();
		entrada.nextLine();
		return opcion;
	}
}
