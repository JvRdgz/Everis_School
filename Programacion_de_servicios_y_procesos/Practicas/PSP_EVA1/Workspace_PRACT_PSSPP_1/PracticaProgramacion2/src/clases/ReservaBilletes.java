package clases;

import java.util.Scanner;

public class ReservaBilletes {

	static Scanner sc = new Scanner(System.in);
	static String vagon[][] = new String[9][4];

	public static void inicializarVagon() {
		for (int i = 0; i < vagon.length; i++) {
			for (int j = 0; j < vagon[i].length; j++) {
				vagon[i][j] = "LIBRE";
			}
		}
	}

	public static void mostrarVagon() {
		for (int i = 0; i < vagon.length; i++) {
			for (int j = 0; j < vagon[i].length; j++) {
				System.out.print("[" + i + ", " + j + "]" + vagon[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public static void reservarBilletes() {
		int fila = 0, columna = 0;

		mostrarVagon();

		System.out.println("\nQue plaza quiere reservar?");

		System.out.println("\t -. Escriba el numero de fila: ");
		fila = Integer.parseInt(sc.nextLine());

		while (fila > 8 || fila < 0) {
			System.out.println("ERROR, has insertado una fila incorrecta, vuelve a intentarlo: ");
			fila = Integer.parseInt(sc.nextLine());
		}

		System.out.println("\t -. Escriba el numero de columna: ");
		columna = Integer.parseInt(sc.nextLine());

		while (columna > 3 || columna < 0) {
			System.out.println("ERROR, has insertado una columna incorrecta, vuelve a intentarlo: ");
			columna = Integer.parseInt(sc.nextLine());
		}

		for (int i = 0; i < vagon.length; i++) {
			for (int j = 0; j < vagon[i].length; j++) {

				if ((i == fila) && (j == columna)) {

					if (vagon[fila][columna].equals("LIBRE")) {
						System.out.println("Plaza reservada correctamente.");
						vagon[fila][columna] = "OCUPADO";
						break;

					} else if (vagon[fila][columna].equals("OCUPADO")) {
						System.out.println("ERROR, asiento ocupado.");
						break;
					}
				}
			}
		}
	}
}
