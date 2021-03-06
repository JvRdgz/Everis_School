package main;

import java.io.File;
import java.util.Scanner;

import hilos.HiloCrearDemonioContarLineas;
import hilos.HiloCrearFicheros;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String ruta = ".\\";

	public static void crear_ficheros() {

		Thread thread = new Thread();
		// No me pone correctamente el nombre del primer hilo.
		for (int i = 0; i < 3; i++) {

			HiloCrearFicheros h = new HiloCrearFicheros((new File(".\\Fichero" + (i + 1) + ".txt")), thread);
			thread = new Thread(h);
			thread.setName("Hilo_" + (i + 1));
			if (i == 0) {
				thread.setPriority(Thread.MAX_PRIORITY);
			} else if (i == 1) {
				thread.setPriority(Thread.NORM_PRIORITY);
			} else {
				thread.setPriority(Thread.MIN_PRIORITY);
			}
			thread.start();
		}
	}

	public static void main(String[] args) {
		crear_ficheros();
		menuPrincipal();
	}

	private static void menuPrincipal() {
		int op = 0;
		String exit = "";

		System.out.println("\n\t\tMENU PRINCIPAL PRACTICA 1 PSSPP\n\n");

		do {

			System.out.println("\t1.- Demonio que cuenta lineas.");
			System.out.println("\t2.- Demonio control de inserciones.");
			System.out.println("\t3.- Operaciones sincronizadas.");
			System.out.println("\t4.- Bloquear metodo escritura.");
			System.out.println("\t5.- Desbloquear metodo escritura.");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 5) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 5: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				opcion_1();
				break;
			case 2:
				System.out.println("\tNO ESTA LISTA");
				opcion_2();
				break;
			case 3:
				System.out.println("\tNO ESTA LISTA");
				opcion_3();
				break;
			case 4:
				System.out.println("\tNO ESTA LISTA");
				opcion_4();
				break;
			case 5:
				System.out.println("\tNO ESTA LISTA");
				opcion_5();
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

	private static void opcion_1() {
		do {
			for (int i = 0; i < 3; i++) {
				Thread thread = new Thread();
				HiloCrearDemonioContarLineas h = new HiloCrearDemonioContarLineas(
						(new File(".\\Fichero" + (i + 1) + ".txt")), thread);
				thread = new Thread(h);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.err.println("\nERROR EN EL SLEEP");
					e.printStackTrace();
				}
				thread.start();
			}
		} while (true);
	}

	private static void opcion_2() {

	}

	private static void opcion_3() {

	}

	private static void opcion_4() {

	}

	private static void opcion_5() {

	}
}
