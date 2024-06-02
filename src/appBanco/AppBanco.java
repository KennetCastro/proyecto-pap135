package appBanco;

import java.util.Scanner;

import servicios.BancoDB;

public class AppBanco {
	private BancoDB bancoDB = new BancoDB();
	
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
			switch (opcion) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
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
			switch (opcion) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
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
			System.out.println("5. Volver al menú principal");
			opcion = getOpcion(entrada);
			switch (opcion) {
				case 1:
					break;
				case 2:
					break;
				case 3:
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
			System.out.println("5. Volver al menú principal");
			opcion = getOpcion(entrada);
			switch (opcion) {
				case 1:
					break;
				case 2:
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
