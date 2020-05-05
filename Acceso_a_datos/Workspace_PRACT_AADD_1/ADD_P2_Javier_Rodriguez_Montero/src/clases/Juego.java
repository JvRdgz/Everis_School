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
		// SI EL ARCHIVO NO EXISTE SE CREA
		File f = new File(Files.getFichero_preguntas());
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
				// NUMERO DE PREGUNTAS
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
				// LEEMOS PREGUNTAS, SEPARAMOS LA FRASE CON SPLIT POR EL CARACTER # Y MOSTRAMOS
				// LAS POSIBLES RESPUESTAS, SIN MOSTRAR LA RESPUESTA CORRECTA
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
					// SI LA RESPUESTA INTRODUCIDA COINCIDE CON LA RESPUESTA CORRECTA, SUMA
					// PUNTUACION, EN CASO CONTRARIO, RESTA.
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
				// SI EL ARCHIVO NO EXISTE, SE CREA
				File f_records = new File(Files.getRuta_files() + "records.txt");
				if (!f_records.exists()) {
					try {
						f_records.createNewFile();
					} catch (IOException e) {
						System.err.println("\nERROR AL CREAR EL ARCHIVO.");
						e.printStackTrace();
					}
				}
				// COMPRUEBA QUE EL USUARIO ESTA GUARDADO EN EL FICHERO DE RECORDS. SI LO ESTA
				// Y ADEMAS, SU PUNTUACION GUARDADA EN EL FICHERO ES MENOR QUE LA PUNTUACION
				// ACTUAL, SE ACTUALIZA LA PUNTUACION DEL FICHERO.
				// SI EL USUARIO QUE HA JUGADO NO ESTA GUARDADO EN EL FICHERO, SE INSERTA CON LA
				// PUNTUACION OBTENIDA.
				System.out.println("\nIntroduce tu nombre:");
				String nombre = sc.nextLine();

				Jugador j = new Jugador(nombre, puntuacion, preguntas_acertadas);

				br = new BufferedReader(new FileReader(f_records));
				BufferedWriter bw = new BufferedWriter(new FileWriter((Files.getRuta_files() + "records.txt"), true));
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
								bw = new BufferedWriter(new FileWriter(Files.getRuta_files() + "records.txt"));
								bw.write(j.getNombre() + ":" + j.getPuntuacion());
							}
							break;
						} else {
							bw = new BufferedWriter(new FileWriter((Files.getRuta_files() + "records.txt"), true));
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

	public static void crear_ruta_ficheros() {
		if (!Files.getDirectorio().exists())
			Files.getDirectorio().mkdir();
	}

	public static void instrucciones() {

		File f = new File(Files.getFichero_instrucciones());
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = br.readLine();
			while (s != null) {
				System.out.println(s);
				s = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("\nERROR AL ABRIR EL ARCHIVO.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR EN LA LECTURA DE DATOS.");
			e.printStackTrace();
		}
	}
}
