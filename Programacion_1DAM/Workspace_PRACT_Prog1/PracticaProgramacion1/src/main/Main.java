package main;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menuPrincipal();
	}

	private static void menuPrincipal() {
		int op = 0;
		String exit = "";

		System.out.println("\n\tMENU PRINCIPAL PRACTICA 1\n\n");

		do {
			System.out.println("\t1.- Calculadora aritmetica: ");
			System.out.println("\t2.- Calculadora de volumenes: ");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 2) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 2: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				submenu1();
				break;
			case 2:
				submenu2();
				break;
			case 0:
				do {
					System.out.println("¿Seguro que quieres salir? (S para si \\ N para no)");
					exit = sc.nextLine();
				} while (!exit.equalsIgnoreCase("S") && !exit.equalsIgnoreCase("N"));
				break;
			}

		} while (op != 0 || exit.equalsIgnoreCase("N"));
	}

	private static void submenu1() {
		int op = 0;

		System.out.println("\n\tSUBMENU 1\n\n");

		do {
			System.out.println("\t1.- Ecuacion de segundo grado: ");
			System.out.println("\t2.- Raiz: ");
			System.out.println("\t3.- Potencia: ");
			System.out.println("\t4.- Factorial: ");
			System.out.println("\t0.- Atras.");

			op = Integer.parseInt(sc.nextLine());
			while (op < 0 || op > 4) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 4: ");
				op = Integer.parseInt(sc.nextLine());
			}
			switch (op) {
			case 1:
				ecuacionSegundoGrado();
				break;
			case 2:
				System.out.println("\nResultado raiz: " + raiz() + "\n");
				break;
			case 3:
				System.out.println("\nResultado potencia: " + potencia() + "\n");
				break;
			case 4:
				System.out.println("\nResultado potencia: " + factorial() + "\n");
			case 0:
				break;
			}

		} while (op != 0);
	}

	private static void submenu2() {
		int op = 0;

		System.out.println("\n\tSUBMENU 2\n\n");

		do {
			System.out.println("\t1.- Cono: ");
			System.out.println("\t2.- Prisma: ");
			System.out.println("\t3.- Esfera: ");
			System.out.println("\t4.- Cubo: ");
			System.out.println("\t0.- Atras.");

			op = Integer.parseInt(sc.nextLine());
			while (op < 0 || op > 4) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 4: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				System.out.println("\nResultado volumen del cono: " + cono() + "\n");
				break;
			case 2:
				System.out.println("\nResultado volumen del prisma: " + prisma() + "\n");
				break;
			case 3:
				System.out.println("\nResultado volumen de la esfera: " + esfera() + "\n");
				break;
			case 4:
				System.out.println("\nResultado volumen del cubo: " + cubo() + "\n");
			case 0:
				break;
			}

		} while (op != 0);
	}

	private static void ecuacionSegundoGrado() {
		double a = 0.0, b = 0.0, c = 0.0, discriminante = 0.0;

		System.out.println("\nIntroduce parametro a: ");
		a = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce parametro b: ");
		b = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce parametro c: ");
		c = Double.parseDouble(sc.nextLine());

		discriminante = Math.pow(b, 2) - (4 * a * c);
		if (discriminante > 0) {
			System.out.println("\nResultado opcion 1 (+): " + ecuacionOpcion1(a, b, c) + "");
			System.out.println("Resultado opcion 1 (-): " + ecuacionOpcion2(a, b, c) + "\n");
		} else if (discriminante < 0)
			System.out.println("\nError, el discriminante provoca una raiz compleja.\n");
		else if (discriminante == 0)
			System.out.println("\nResultado: " + ecuacionDiscriminanteCero(a, b) + "\n");
	}

	private static double raiz() {
		double num = 0.0;

		System.out.println("\nIntroduce un valor:");
		num = Double.parseDouble(sc.nextLine());

		while (num < 0) {
			System.out.println("Error, la raiz no puede ser calculada con numeros"
					+ " negativos. \nIntroduce un valor mayor o igual a 0");
			num = Double.parseDouble(sc.nextLine());
		}
		return (Math.sqrt(num));
	}

	private static double potencia() {
		double base = 0.0, exponente = 0.0;

		System.out.println("\nIntroduce la base: ");
		base = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce el exponente: ");
		exponente = Double.parseDouble(sc.nextLine());

		return (Math.pow(base, exponente));
	}

	private static double factorial() {
		double num = 0.0, acum = 1.0, result = 1.0;

		System.out.println("\nIntroduce un valor: ");
		num = Double.parseDouble(sc.nextLine());

		while (acum < num) {
			acum++;
			result *= acum;
		}
		return (result);
	}

	private static double cono() {
		double h = 0.0, r = 0.0;

		System.out.println("\nIntroduce la altura del cono: ");
		h = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce el radio del cono: ");
		r = Double.parseDouble(sc.nextLine());

		return ((h * Math.PI * Math.pow(r, 2)) / 3);
	}

	private static double prisma() {
		double l = 0.0, w = 0.0, h = 0.0;

		System.out.println("             -   /-----------/");
		System.out.println("            /   /|          /|");
		System.out.println("           /   / |         / |");
		System.out.println("          /   /  /--------/- /");
		System.out.println("        l/   /  /        /  /");
		System.out.println("        /   /  /        /  /");
		System.out.println("       /   /  /        /  /");
		System.out.println("      /   /  /        /  /");
		System.out.println("     /   /  /        /  /");
		System.out.println("    -   /  /        /  /");
		System.out.println("   -   ----------- /  /");
		System.out.println("   |  |  /         | /");
		System.out.println("  h|  | /          |/");
		System.out.println("   -   -----------");

		System.out.println("       <--------->");
		System.out.println("            w");

		System.out.println("\nIntroduce la longitud (l) del prisma: ");
		l = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce la anchura (w) del prisma: ");
		w = Double.parseDouble(sc.nextLine());
		System.out.println("Introduce la altura (h) del prisma: ");
		h = Double.parseDouble(sc.nextLine());

		return (l * w * h);
	}

	private static double esfera() {
		double radio;

		System.out.println("\nIntroduce el radio:");
		radio = Double.parseDouble(sc.nextLine());

		return ((4 / 3) * Math.PI * Math.pow(radio, 3));
	}

	private static double cubo() {
		double arista;

		System.out.println("\nIntroduce la arista del cubo:");
		arista = Double.parseDouble(sc.nextLine());

		return (Math.pow(arista, 3));
	}

	private static double ecuacionOpcion1(double a, double b, double c) {
		return (((-b) + Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a));
	}

	private static double ecuacionOpcion2(double a, double b, double c) {
		return (((-b) - Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a));
	}

	private static double ecuacionDiscriminanteCero(double a, double b) {
		return (-(b / (2 * a)));
	}

}
