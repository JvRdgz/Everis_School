package clases;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import base_de_datos.ConexionDAO;
import properties.Persistencia;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	private static Logger log = Logger.getLogger(Menu.class);
	public static void menuPrincipal() {
		PropertyConfigurator.configure("./Properties/log4j.properties");
		int op = 0, puntuacion = 0;
		String exit = "";
		Pregunta p = new Pregunta();
		String pregunta = "", respuesta1 = "", respuesta2 = "", respuesta3 = "", respuesta_correcta = "";
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		if (Persistencia.getMethod().equalsIgnoreCase("file"))
			Juego.crear_ruta_ficheros();
		log.info("Datos recogidos del fichero persistencia.properties");
		System.out.println(ConexionDAO.getBd());
		System.out.println(ConexionDAO.getUser());
		System.out.println(ConexionDAO.getPassword());
		System.out.println(ConexionDAO.getHost());
		System.out.println(ConexionDAO.getUrl());
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
				Pregunta.exportar_preguntas();
				break;
			case 4:
				Juego.instrucciones();
				break;
			case 5:
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

}
