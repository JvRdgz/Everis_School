package main;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String nombre, apellido1, apellido2;

		System.out.println("\nIntroduce un nombre:");
		nombre = sc.nextLine();
		System.out.println("Introduce primer apellido:");
		apellido1 = sc.nextLine();
		System.out.println("Introduce segundo apellido:");
		apellido2 = sc.nextLine();

		menuPrincipal(nombre, apellido1, apellido2);
	}

	private static void menuPrincipal(String nombre, String apellido1, String apellido2) {
		int op = 0;
		String exit = "";

		System.out.println("\n\tMENU PRINCIPAL PRACTICA 1\n\n");

		do {
			System.out.println("\t1.- �Tiene el usuario el primer apellido igual que el segundo?: ");
			System.out.println("\t2.- �Cual es la primera letra de su nombre?: ");
			System.out.println(
					"\t3.- Sacar la abreviatura de su nombre y apellidos en el siguiente formato: NA1A2, donde N es la\n"
							+ "primera letra del nombre, A1 la primera del primer apellido y A2 la primera del segundo apellido.: ");
			System.out.println("\t4.- �Cuantos caracteres tiene su nombre?: ");
			System.out.println("\t5.- �Cuantos caracteres tiene su nombre y apellidos?: ");
			System.out.println(
					"\t6.- Componer un email que sean las tres primeras letras del nombre, las tres letras del medio del\n"
							+ "apellido1 y las tres letras del final del apellido2. Una vez compuesta esa "
							+ "cadena aniadir \"@everisschool.es\". Para obtener los caracteres del medio realizaremos el calculo "
							+ "de dividir la longitud de la cadena entre dos y tomaremos como posicion origen el resultado de esa operacion.: ");
			System.out.println(
					"\t7.- Comprobar si bien el nombre o los apellidos contienen una cadena pedida al usuario. Por ejemplo, "
							+ "si el apellido es Perez e introduzco la cadena \"rez\" tiene que devolver el mensaje \"cadena contenida\".: ");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 7) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 7: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				uno(apellido1, apellido2);
				break;
			case 2:
				dos(nombre);
				break;
			case 3:
				tres(nombre, apellido1, apellido2);
				break;
			case 4:
				cuatro(nombre);
				break;
			case 5:
				cinco(nombre, apellido1, apellido2);
				break;
			case 6:
				seis(nombre, apellido1, apellido2);
				break;
			case 7:
				siete(nombre, apellido1, apellido2);
				break;
			case 0:
				do {
					System.out.println("�Seguro que quieres salir? (S para si \\ N para no)");
					exit = sc.nextLine();
				} while (!exit.equalsIgnoreCase("S") && !exit.equalsIgnoreCase("N"));
				break;
			}

		} while (op != 0 || exit.equalsIgnoreCase("N"));
	}

	private static void uno(String apellido1, String apellido2) {
		if (apellido1.equals(apellido2))
			System.out.println("\nSi.\n");
		else
			System.out.println("\nNo.\n");
	}

	private static void dos(String nombre) {
		System.out.println("\n" + nombre.charAt(0) + "\n");
	}

	private static void tres(String nombre, String apellido1, String apellido2) {
		System.out.println("\n" + nombre.charAt(0) + apellido1.charAt(0) + apellido2.charAt(0) + "\n");
	}

	private static void cuatro(String nombre) {
		System.out.println("\n" + nombre.length() + "\n");
	}

	private static void cinco(String nombre, String apellido1, String apellido2) {
		System.out.println("\n" + (nombre.length() + apellido1.length() + apellido2.length()) + "\n");
	}

	private static void seis(String nombre, String apellido1, String apellido2) {
		String direccionCorreo = "@everisschool.es";
		String nombre2 = nombre.substring(0, 3),
				apellido1_2 = apellido1.substring(apellido1.length() / 2, (apellido1.length() / 2) + 3),
				apellido2_2 = apellido2.substring(apellido2.length() - 3, apellido2.length());

		System.out.println(
				"\n" + (nombre2.concat(apellido1_2).concat(apellido2_2.concat(direccionCorreo))).toLowerCase() + "\n");
	}

	private static void siete(String nombre, String apellido1, String apellido2) {
		String cadena;

		System.out.println("\nIntroduce la cadena para comprobar si se encuentra:");
		cadena = sc.nextLine();

		if (nombre.contains(cadena) || apellido1.contains(cadena) || apellido2.contains(cadena))
			System.out.println("\nCadena contenida\n");
		else
			System.out.println("\nNo se encuentra la cadena\n");
	}

}
