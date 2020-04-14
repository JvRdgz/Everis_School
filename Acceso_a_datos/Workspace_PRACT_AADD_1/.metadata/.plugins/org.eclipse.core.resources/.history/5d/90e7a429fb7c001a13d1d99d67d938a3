package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	
	static Scanner sc = new Scanner(System.in);

	public static void jugar(ArrayList<Pregunta> preguntas, int puntuacion) {
		// Si el archivo no existe se crea
		File f = new File(Menu.getRuta() + "Preguntas.txt");
		int numPregunta = 0, preguntas_acertadas = 0;
		Pregunta p;
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO.");
				e.printStackTrace();
			}
		}
		if (f.length() == 0)
			System.out.println(
					"\nEl archivo esta vacio, vaya a la opcion 2 para insertar preguntas o a la opcion 5 para importarlas.\n");
		else {
			try {
				System.out.println("\n\n\tQUE EMPIECE EL JUEGO!\n\n");
				BufferedReader br = new BufferedReader(new FileReader(f));
				// Numero de pregunta
				String s = br.readLine();
				while (s != null) {
					numPregunta++;
					s = br.readLine();
				}
				System.out.println("\nEl juego consta de " + numPregunta + " preguntas:\n");
				br.close();
				br = new BufferedReader(new FileReader(f));
				s = br.readLine();
				numPregunta = 0;
				// Leemos preguntas, separamos la frase con split por el caracter # y mostramos
				// las posibles respuestas, sin mostrar la respuesta correcta.
				while (s != null) {
					String[] s_parts = s.split("#");
					preguntas.add(p = new Pregunta(s_parts[0], s_parts[1], s_parts[2], s_parts[3], s_parts[4]));
					numPregunta++;
					System.out.println("\nPregunta " + numPregunta + ":\n");
					for (int i = 0; i < s_parts.length - 1; i++) {
						System.out.println("\t" + s_parts[i]);
					}
					System.out.println("\nIntroduce tu respuesta:");
					String res = sc.nextLine();
					// Si la respuesta introducida coincide con la respuesta correcta, suma
					// puntuacion, en caso contrario, resta.
					if (res.equalsIgnoreCase(p.getRespuesta_correcta())) {
						preguntas_acertadas++;
						puntuacion += 10;
						System.out.println(
								"\nRESPUESTA CORRECTA!\nTienes una puntuacion total de " + puntuacion + " puntos.\n");
					} else {
						puntuacion -= 5;
						System.out.println("\nOOOOHH RESPUESTA INCORRECTA...\nTienes una puntuacion total de "
								+ puntuacion + " puntos.\n");
					}
					s = br.readLine();
				}
				br.close();
				// Si el archivo no existe, se crea.
				File f_records = new File(Menu.getRuta() + "records.txt");
				if (!f_records.exists()) {
					try {
						f_records.createNewFile();
					} catch (IOException e) {
						System.err.println("\nERROR AL CREAR EL ARCHIVO.");
						e.printStackTrace();
					}
				}
				// Comprueba que el usuario esta guardado en el fichero de records. Si lo esta
				// y ademas, su puntuacion guardada en el fichero es menor que la puntuacion
				// actual,
				// se actualiza la puntuacion del fichero.
				// Si el usuario que ha jugado no esta guardado en el fichero, se inserta con la
				// puntuacion obtenida.
				System.out.println("\nIntroduce tu nombre:");
				String nombre = sc.nextLine();

				Jugador j = new Jugador(nombre, puntuacion, preguntas_acertadas);

				br = new BufferedReader(new FileReader(f_records));
				BufferedWriter bw = new BufferedWriter(new FileWriter((Menu.getRuta() + "records.txt"), true));
				s = null;
				s = br.readLine();
				if (f_records.length() == 0) {
					bw.write(j.getNombre() + ":" + j.getPuntuacion());
					// bw.newLine();
				} else {
					while (s != null) {
						if (s.contains(j.getNombre())) {
							String[] datos_records = s.split(":");
							// System.out.println(datos_records[1]);
							int puntuacion_fichero = Integer.parseInt(datos_records[1]);
							if (j.getPuntuacion() > puntuacion_fichero) {
								bw = new BufferedWriter(new FileWriter(Menu.getRuta() + "records.txt"));
								bw.write(j.getNombre() + ":" + j.getPuntuacion());
							}
							break;
						} else {
							bw = new BufferedWriter(new FileWriter((Menu.getRuta() + "records.txt"), true));
							bw.newLine();
							bw.write(j.getNombre() + ":" + j.getPuntuacion());
						}
						s = br.readLine();
					}
				}
				bw.close();
				br.close();
				Jugador.mostrar_informe(j.getNombre(), j.getPuntuacion(), j.getNum_pregunta_fallada());
			} catch (FileNotFoundException e1) {
				System.err.println("\nERROR AL ABRIR EL ARCHIVO.");
				e1.printStackTrace();
			} catch (IOException e) {
				System.err.println("\nERROR EN LA LECTURA DE DATOS.");
				e.printStackTrace();
			}
		}

	}
	
	public static void crear_directorio() {
		if (!Menu.getDirectorio().exists())
			Menu.getDirectorio().mkdir();
	}
	
	public static void instrucciones() {
		System.out.println("\n\n\t\tINSTRUCCIONES DEL JUEGO\n\n");
		System.out.println("\n\t- El usuario tendra que contestar a una serie de preguntas que le\n");
		System.out.println("\t\t iran apareciendo en pantalla.");
		System.out.println("\t- Cada pregunta, contiene tres posibles respuestas, pero solo una de ellas\n");
		System.out.println("\t\t es la respuesta correcta. El usuario debe escribir la respuesta que\n");
		System.out.println("\t\t crea correcta.\n");
		System.out.println("\t- Si la respuesta es correcta, aparecera un mensaje indicando que la\n");
		System.out.println("\t\t respuesta es correcta. En caso contrario, aparecera un mensaje indicando\n");
		System.out.println("\t\t que la respuesta dada es incorrecta.\n\n");
		System.out.println("\t- Por cada pregunta que el jugador acierte, ganara 10 puntos. En cambio,\n");
		System.out.println("\t\t por cada pregunta mal contestada, el jugador perdera 5 puntos.\n\n");
	}
}
