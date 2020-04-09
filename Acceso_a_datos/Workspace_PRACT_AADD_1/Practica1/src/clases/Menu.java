package clases;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.text.Document;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	static String ruta = "." + File.separator + "Files" + File.separator;
	static File directorio = new File(ruta);
	static String fichero_xml = ruta + "preguntas.xml";
	static String fichero_xls = ruta + "preguntas.xls";
	static String fichero_preguntas = ruta + "Preguntas.txt";
	static Document documento_xml;
	static boolean cargadoDocumento = false;
	
	public static void menuPrincipal() {
		int op = 0, puntuacion = 0;
		String exit = "";
		Pregunta p = new Pregunta();
		String pregunta = "", respuesta1 = "", respuesta2 = "", respuesta3 = "", respuesta_correcta = "";
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

		System.out.println("\n\t\tMENU PRINCIPAL PRACTICA 2 AADD\n\n");

		do {
			System.out.println("\t1.- Jugar:");
			System.out.println("\t2.- Aniadir preguntas:");
			System.out.println("\t3.- Exportar preguntas:");
			System.out.println("\t4.- Instrucciones:");
			System.out.println("\t5.- Importar preguntas:");
			System.out.println("\t6.- Visualizar records:");
			System.out.println("\t0.- Salir.");

			op = Integer.parseInt(sc.nextLine());

			while (op < 0 || op > 6) {
				System.out.println("Opcion no valida, Introduce una opcion entre 0 y 6: ");
				op = Integer.parseInt(sc.nextLine());
			}

			switch (op) {
			case 1:
				Juego.jugar(preguntas, puntuacion);
				break;
			case 2:
				Pregunta.aniadir_preguntas(p, pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
				break;
			case 3:
				// System.out.println("\n\tNO DISPONIBLE ACTUALMENTE.\n");
				Pregunta.exportar_preguntas(fichero_xml, fichero_preguntas);
				break;
			case 4:
				Juego.instrucciones();
				break;
			case 5:
				// System.out.println("\n\tNO DISPONIBLE ACTUALMENTE.\n");
				Pregunta.importar_preguntas();
				break;
			case 6:
				Record.visualizar_records();
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

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		Menu.ruta = ruta;
	}

	public static String getFichero_xml() {
		return fichero_xml;
	}

	public static void setFichero_xml(String fichero_xml) {
		Menu.fichero_xml = fichero_xml;
	}

	public static String getFichero_preguntas() {
		return fichero_preguntas;
	}

	public static void setFichero_preguntas(String fichero_preguntas) {
		Menu.fichero_preguntas = fichero_preguntas;
	}

	public static File getDirectorio() {
		return directorio;
	}

	public static void setDirectorio(File directorio) {
		Menu.directorio = directorio;
	}

	public static String getFichero_xls() {
		return fichero_xls;
	}

	public static void setFichero_xls(String fichero_xls) {
		Menu.fichero_xls = fichero_xls;
	}

	public static Document getDocumento_xml() {
		return documento_xml;
	}

	public static void setDocumento_xml(Document documento_xml) {
		Menu.documento_xml = documento_xml;
	}

	public static boolean isCargadoDocumento() {
		return cargadoDocumento;
	}

	public static void setCargadoDocumento(boolean cargadoDocumento) {
		Menu.cargadoDocumento = cargadoDocumento;
	}
	
}
