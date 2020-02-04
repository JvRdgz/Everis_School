package main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String ruta = ".\\FicherosCreados";
	static File directorio = new File(ruta);

	public static void main(String[] args) {
		crearDirectorio();
		menuPrincipal();
	}

	private static void menuPrincipal() {
		int op = 0;
		String exit = "";

		System.out.println("\n\tMENU PRINCIPAL PRACTICA 3\n\n");

		do {
			System.out.println("\t1.- Ficheros de texto: ");
			System.out.println("\t2.- Ficheros binarios: ");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 2) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 2: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				menuFicherostxt();
				break;
			case 2:
				menuFicherosBinarios();
				break;
			case 0:
				do {
					System.out.println("Seguro que quieres salir? (S para si \\ N para no)");
					exit = sc.nextLine();
				} while (!exit.equalsIgnoreCase("S") && !exit.equalsIgnoreCase("N"));
				break;
			}

		} while (op != 0 || exit.equalsIgnoreCase("N"));
	}

	private static void menuFicherosBinarios() {
		int op = 0;

		System.out.println("\n\tMENU FICHEROS BINARIOS\n\n");

		do {
			System.out.println("\t1.- Crear fichero con el nombre FicheroBinario.bin:");
			System.out.println("\t2.- Eliminar fichero de la carpeta ficheros introduciendo su nombre:");
			System.out.println("\t3.- Renombrar un fichero introduciendo su nombre por teclado...");
			System.out.println(
					"\t4.- Escribir en el fichero una linea introducida por teclado que cumpla con el formato\n"
							+ "\tNombre#Apellido1#Apellido2#DNI#Edad");
			System.out.println("\t5.- Buscar una linea en el fichero a traves de un DNI:");
			System.out.println("\t6.- Eliminar una linea tras introducir un DNI:");
			System.out.println(
					"\t7.- Copiar Fichero. Esta accion copiara las lineas pares en un fichero y a continuacion las\n"
							+ "columnas pares. Debe de hacerse en funciones separadas. Ademas, hara lo mismo para\n"
							+ "las lineas y columnas impares. Los ficheros se nombraran de la siguiente manera.\n"
							+ "BinarioLineasPares.bin y BinarioLineasImpares.bin:");
			System.out.println(
					"\t8.- Almacenar ficheros. Esta accion almacenara todos los ficheros creados en la carpeta en\n"
							+ "un array");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 8) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 8: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				unoBin();
				break;
			case 2:
				dosBin();
				break;
			case 3:
				tresBin();
				break;
			case 4:
				cuatroBin();
				break;
			case 5:
				cincoBin();
				break;
			case 6:
				seisBin();
				break;
			case 7:
				sieteBin();
				break;
			case 8:
				ochoBin();
				break;
			case 0:
				break;
			}
		} while (op != 0);
	}

	private static void ochoBin() {
		ochotxt();
	}

	private static void sieteBin() {
		File pares = new File(ruta + "\\BinarioLineasPares.bin");
		File impares = new File(ruta + "\\BinarioLineasImpares.bin");

		lineasImparesBinario(impares);
		lineasParesBinario(pares);
		columnasImparesBinario(impares);
		columnasParesBinario(pares);
	}

	private static void columnasParesBinario(File pares) {
		// TODO Auto-generated method stub

	}

	private static void columnasImparesBinario(File impares) {
		// TODO Auto-generated method stub

	}

	private static void lineasParesBinario(File pares) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ruta + "\\FicheroBinario.bin")));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pares, true)));
			String s = null;
			int cont = 0;
			while ((s = br.readLine()) != null) {
				if (cont % 2 == 0) {
					dos.writeBytes(s);
					dos.writeBytes("\n");
				}
				cont++;
			}
			br.close();
			dos.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void lineasImparesBinario(File impares) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ruta + "\\FicheroBinario.bin")));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(impares, true)));
			String s = null;
			int cont = 0;
			while ((s = br.readLine()) != null) {
				if (cont % 2 != 0) {
					dos.writeBytes(s);
					dos.writeBytes("\n");
				}
				cont++;
			}
			br.close();
			dos.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void seisBin() {
		System.out.println("\nIntroduce DNI:");
		String dni = sc.nextLine();
		File temp = new File(ruta + "\\FicheroAux.bin");
		File fichero = new File(ruta + "\\FicheroBinario.bin");

		if (!fichero.isFile()) {
			System.err.println("El fichero no existe");
			return;
		}
		try {
			// DataInputStream dis = new DataInputStream(new BufferedInputStream(new
			// FileInputStream(fichero)));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(temp, true)));
			String s = null;

			while ((s = br.readLine()) != null) {
				if (!s.contains(dni)) {
					dos.writeBytes(s);
					dos.writeBytes("\n");
				}
			}
			br.close();
			dos.close();

			if (!fichero.delete()) {
				System.err.println("No se ha podido eliminar el fichero temporal");
				return;
			}

			if (!temp.renameTo(fichero)) {
				System.err.println("No se ha podido renombrar el fichero temporal");

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void cincoBin() {
		System.out.println("\nIntroduce DNI:");
		String dni = sc.nextLine();
		boolean finArchivo = false;
		String s;
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ruta + "\\FicheroBinario.bin")));
//			DataInputStream dis = new DataInputStream(
//					new BufferedInputStream(new FileInputStream(ruta + "\\FicheroBinario.bin")));
			while (!finArchivo) {
				s = br.readLine();
				if (s.contains(dni)) {
					System.out.println(s);
					break;
				} else
					s = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void cuatroBin() {
		System.out.println("\nIntroduce Nombre, Apellido1, Apellido2, DNI y Edad:");
		String frase = sc.nextLine();

		try {
//			bw.newLine();
//			bw.close();
//			FileOutputStream fos = new FileOutputStream ((ruta + "\\FicheroBinario.bin"), true);
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			DataOutputStream dos = new DataOutputStream(bos);
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream((ruta + "\\FicheroBinario.bin"), true)));
			dos.writeBytes(frase.replace(' ', '#').replaceAll(",", ""));
			dos.writeBytes("\n");
			dos.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la escritura del fichero.");
			e.printStackTrace();
		}
	}

	private static void tresBin() {
		trestxt();
	}

	private static void dosBin() {
		dostxt();
	}

	private static void unoBin() {
		File f = new File(ruta, "FicheroBinario.bin");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}
	}

	private static void menuFicherostxt() {
		int op = 0;

		System.out.println("\n\tMENU FICHEROS DE TEXTO\n\n");

		do {
			System.out.println("\t1.- Crear fichero con el nombre FicheroTexto.txt:");
			System.out.println("\t2.- Eliminar fichero de la carpeta ficheros introduciendo su nombre:");
			System.out.println("\t3.- Renombrar un fichero introduciendo su nombre por teclado...");
			System.out.println(
					"\t4.- Escribir en el fichero una linea introducida por teclado que cumpla con el formato\n"
							+ "\tNombre#Apellido1#Apellido2#DNI#Edad");
			System.out.println("\t5.- Buscar una linea en el fichero a traves de un DNI:");
			System.out.println("\t6.- Eliminar una linea tras introducir un DNI:");
			System.out.println(
					"\t7.- Copiar Fichero. Esta accion copiara las lineas pares en un fichero y a continuacion las\n"
							+ "columnas pares. Debe de hacerse en funciones separadas. Ademas, hara lo mismo para\n"
							+ "las lineas y columnas impares. Los ficheros se nombraran de la siguiente manera.\n"
							+ "TextoLineasPares.txt y TextoLineasImpares.txt ");
			System.out.println(
					"\t8.- Almacenar ficheros. Esta accion almacenara todos los ficheros creados en la carpeta en\n"
							+ "un array");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 8) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 8: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				unotxt();
				break;
			case 2:
				dostxt();
				break;
			case 3:
				trestxt();
				break;
			case 4:
				cuatrotxt();
				break;
			case 5:
				cincotxt();
				break;
			case 6:
				seistxt();
				break;
			case 7:
				sietetxt();
				break;
			case 8:
				ochotxt();
				break;
			case 0:
				break;
			}

		} while (op != 0);
	}

	private static void ochotxt() {
		File[] f1 = directorio.listFiles();
		for (int i = 0; i < f1.length; i++)
			System.out.println(f1[i]);
	}

	private static void sietetxt() {
		File pares = new File(ruta + "\\TextoLineasPares.txt");
		File impares = new File(ruta + "\\TextoLineasImpares.txt");

		lineasImparesTexto(impares);
		lineasParesTexto(pares);
		columnasImparesTexto(impares);
		columnasParesTexto(pares);
	}

	private static void columnasParesTexto(File pares) {
		// NO FUNCIONA CORRECTAMETE, CORREGIR
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta + "\\FicheroTexto.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(pares, true));
			String s = null;
			int cont = 0, inicio = 0, fin = 0;
			while ((s = br.readLine()) != null) {
				inicio = s.indexOf("#");
				fin = s.indexOf("#", inicio + 1);
				if (cont % 2 == 0) {
					bw.write(s.substring(inicio, fin));
					bw.newLine();
					cont++;
				}
				if (s.contains("#")) {
					cont++;
				}
			}
			br.close();
			bw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void columnasImparesTexto(File impares) {
		// NO FUNCIONA CORRECTAMETE, CORREGIR
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta + "\\FicheroTexto.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(impares, true));
			String s = null;
			int cont = 0, inicio = 0, fin = 0;
			while ((s = br.readLine()) != null) {
				inicio = s.indexOf("#");
				fin = s.indexOf("#", inicio + 1);
				if (cont % 2 != 0) {
					bw.write(s.substring(inicio, fin));
					bw.newLine();
					cont++;
				}
				if (s.contains("#")) {
					cont++;
				}
			}
			br.close();
			bw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void lineasParesTexto(File pares) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta + "\\FicheroTexto.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(pares, false));
			String s = null;
			int cont = 0;
			while ((s = br.readLine()) != null) {
				if (cont % 2 == 0) {
					bw.write(s);
					bw.newLine();
				}
				cont++;
			}
			br.close();
			bw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void lineasImparesTexto(File impares) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta + "\\FicheroTexto.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(impares, false));
			String s = null;
			int cont = 0;
			while ((s = br.readLine()) != null) {
				if (cont % 2 != 0) {
					bw.write(s);
					bw.newLine();
				}
				cont++;
			}
			br.close();
			bw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void seistxt() {
		System.out.println("\nIntroduce DNI:");
		String dni = sc.nextLine();
		File temp = new File(ruta + "\\FicheroAux.txt");
		File fichero = new File(ruta + "\\FicheroTexto.txt");

		if (!fichero.isFile()) {
			System.err.println("El fichero no existe");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			String s = null;

			while ((s = br.readLine()) != null) {
				if (!s.contains(dni)) {
					bw.write(s);
					bw.newLine();
					// pw.flush();
				}
			}
			bw.close();
			br.close();

			if (!fichero.delete()) {
				System.err.println("No se ha podido eliminar el fichero temporal");
				return;
			}

			if (!temp.renameTo(fichero)) {
				System.err.println("No se ha podido renombrar el fichero temporal");

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void cincotxt() {
		System.out.println("\nIntroduce DNI:");
		String dni = sc.nextLine();

		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta + "\\FicheroTexto.txt"));
			String s = br.readLine();

			while (s != null) {
				if (s.contains(dni)) {
					System.out.println(s);
					break;
				} else
					s = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la lectura de datos");
			e.printStackTrace();
		}
	}

	private static void cuatrotxt() {
		System.out.println("\nIntroduce Nombre, Apellido1, Apellido2, DNI y Edad:");
		String frase = sc.nextLine();

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter((ruta + "\\FicheroTexto.txt"), true));
			bw.write(frase.replace(' ', '#').replaceAll(",", ""));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("Error en la escritura de datos.");
			e.printStackTrace();
		}
	}

	private static void trestxt() {
		System.out.println("\nIntroduce el nombre del fichero que deseas renombrar: ");
		String fichero = sc.nextLine();
		File[] f1 = directorio.listFiles();
		for (int i = 0; i < f1.length; i++) {
			if (f1[i].getName().equals(fichero)) {
				System.out.println("Fichero encontrado. Introduce el nuevo nombre. ");
				String nuevoNombre = sc.nextLine();
				File f2 = new File(ruta, nuevoNombre);
				boolean renombrado = f1[i].renameTo(f2);
				if (renombrado)
					System.out.println("Archivo renombrado.");
				else
					System.out.println("Error al renombrar un archivo.");
			}
		}
	}

	private static void dostxt() {
		System.out.println("\nIntroduce el nombre del fichero que deseas eliminiar: ");
		String fichero = sc.nextLine();
		File[] f1 = directorio.listFiles();
		for (int i = 0; i < f1.length; i++) {
			if (f1[i].getName().equals(fichero)) {
				boolean borrado = f1[i].delete();
				if (borrado)
					System.out.println("Archivo borrado.");
				else
					System.err.println("Error al borrado un archivo.");
			}
		}
	}

	private static void unotxt() {
		File f = new File(ruta, "FicheroTexto.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}
	}

	private static void crearDirectorio() {
		if (!directorio.exists())
			directorio.mkdir();
	}

}
