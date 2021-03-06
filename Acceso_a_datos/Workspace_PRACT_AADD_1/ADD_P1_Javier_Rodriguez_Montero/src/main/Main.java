package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import clases.Jugador;
import clases.Pregunta;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pdf_content.PDFHeaderFooter;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String ruta = "." + File.separator + "Files" + File.separator;
	static File directorio = new File(ruta);
	static String fichero_xml = ruta + "preguntas.xml";
	static String fichero_xls = ruta + "preguntas.xls";
	static String fichero_preguntas = ruta + "Preguntas.txt";
	static Document documento_xml;
	static boolean cargadoDocumento = false;

	public static void crear_directorio() {
		if (!directorio.exists())
			directorio.mkdir();
	}

	public static void main(String[] args) {
		crear_directorio();
		menuPrincipal();
	}

	private static void menuPrincipal() {
		int op = 0, puntuacion = 0;
		String exit = "";
		Pregunta p = new Pregunta();
		String pregunta = "", respuesta1 = "", respuesta2 = "", respuesta3 = "", respuesta_correcta = "";
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

		System.out.println("\n\t\tMENU PRINCIPAL PRACTICA 1 AADD\n\n");

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
				jugar(preguntas, puntuacion);
				break;
			case 2:
				aniadir_preguntas(p, pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
				break;
			case 3:
				// System.out.println("\n\tNO DISPONIBLE ACTUALMENTE.\n");
				exportar_preguntas(fichero_xml, fichero_preguntas);
				break;
			case 4:
				instrucciones();
				break;
			case 5:
				// System.out.println("\n\tNO DISPONIBLE ACTUALMENTE.\n");
				importar_preguntas();
				break;
			case 6:
				visualizar_records();
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

	private static void exportar_preguntas(String fichero_xml, String fichero_preguntas) {
		File f = new File(fichero_xml);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO XML.");
				e1.printStackTrace();
			}
		}
		File f2 = new File(fichero_preguntas);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO Preguntas.txt.");
				e1.printStackTrace();
			}
		}
		Pregunta.escribir_XML(f, f2);
	}

	private static void mostrar_informe(String nombre, int puntuacion, int preguntas_acertadas) {
		/**
		 * Además, una vez acabe cada partida, se pedirá al usuario si quiere que se
		 * muestre un informe en PDF con el resultado de la misma: la puntuación
		 * obtenida, la corrección de las preguntas, etc.: partida.pdf
		 */
		Jugador j = new Jugador(nombre, puntuacion, preguntas_acertadas);
		PdfWriter writer = null;
		// Tamaño de pagina, margenes, etc.
		Document documento = new Document(PageSize.A4, 20, 20, 70, 50);
		try {
			File f = new File(ruta + "partida.pdf");
			if (!f.exists())
				f.createNewFile();
			writer = PdfWriter.getInstance(documento, new FileOutputStream(f));
			writer.setPageEvent(new PDFHeaderFooter());
			documento.open();

			// PARRAFO
			Paragraph paragraph = new Paragraph();
			String parrafo_puntuacion = "Puntuacion total obtenida:";

			paragraph.setSpacingBefore(100);
			paragraph.add("\n\n");
			String font = "Sans";
			float tamanno = 11;
			int style = Font.BOLD;
			BaseColor color = BaseColor.BLACK;
			float spacBefore = 0;
			float spacAfter = 5;

			// paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setFont(new Font(FontFactory.getFont(font, tamanno, style, color)));
			paragraph.add(parrafo_puntuacion);
			paragraph.setSpacingBefore(spacBefore);
			paragraph.setSpacingAfter(spacAfter);

			documento.add(paragraph);

			// TABLA
			PdfPTable tabla = new PdfPTable(3);

			// Contenido de la cabecera de la celda
			Phrase texto_celda1 = new Phrase("Nombre del Jugador");

			PdfPCell cont_celda1 = new PdfPCell(texto_celda1);
			cont_celda1.setBackgroundColor(BaseColor.CYAN);
			cont_celda1.setBorderWidth(1);
			cont_celda1.setBorderColor(BaseColor.BLUE);
			cont_celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda1.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda1.setPaddingBottom(3);

			Phrase texto_celda2 = new Phrase("Puntuacion total");

			PdfPCell cont_celda2 = new PdfPCell(texto_celda2);
			cont_celda2.setBackgroundColor(BaseColor.CYAN);
			cont_celda2.setBorderWidth(1);
			cont_celda2.setBorderColor(BaseColor.BLUE);
			cont_celda2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda2.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda2.setPaddingBottom(3);

			Phrase texto_celda3 = new Phrase("Preguntas acertadas");

			PdfPCell cont_celda3 = new PdfPCell(texto_celda3);
			cont_celda3.setBackgroundColor(BaseColor.CYAN);
			cont_celda3.setBorderWidth(1);
			cont_celda3.setBorderColor(BaseColor.BLUE);
			cont_celda3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda3.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda3.setPaddingBottom(3);

			tabla.addCell(cont_celda1);
			tabla.addCell(cont_celda2);
			tabla.addCell(cont_celda3);
			tabla.addCell(j.getNombre());
			tabla.addCell(String.valueOf(j.getPuntuacion()));
			tabla.addCell(String.valueOf(j.getNum_pregunta_fallada()));

			documento.add(tabla);

			documento.close();
			writer.close();

			File path = new File(ruta + "partida.pdf");
			Desktop.getDesktop().open(path);

		} catch (FileNotFoundException e) {
			System.err.println("\nERROR EN LA ESCRITURA DEL ARCHIVO.");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.err.println("\nERROR EN EL INFORME PDF.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR AL ABRIR EL INFORME.");
			e.printStackTrace();
		}
	}

	// METODO DE INSERCION PARA ORDENAR ARRAY
	/*
	 * private static void insercion(int[] array) { for (int i = 1; i <
	 * array.length; i++) { int aux = array[i]; int j; for (j = i - 1; j >= 0 &&
	 * array[j] > aux; j--) { array[j + 1] = array[j]; } array[j + 1] = aux; } }
	 */

	private static void visualizar_records() {
		// Compruebo que existe el fichero records.txt
		File f_records = new File(ruta + "records.txt");
		int[] puntuacion_records;
		if (!f_records.exists()) {
			try {
				f_records.createNewFile();
			} catch (IOException e) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO.");
				e.printStackTrace();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f_records));
			String s = br.readLine();
			int tam_record_array = 0;
			// Calculamos el tama�o que va a tener el array puntuacion_recods.
			while (s != null) {
				tam_record_array++;
				s = br.readLine();
			}
			br.close();
			s = null;
			// Reiniciamos el Buffer
			br = new BufferedReader(new FileReader(f_records));
			s = br.readLine();
			puntuacion_records = new int[tam_record_array];
			int pos = 0;
			// Guardamos las puntuaciones del fichero en el array puntuacion_records.
			while (s != null) {
				String[] datos_records = s.split(":");
				puntuacion_records[pos] = Integer.parseInt(datos_records[1]);
				pos++;
				s = br.readLine();
			}
			// Ordenamos el array puntuacion_records con .sort(), aunque tambien tengo el
			// metodo
			// de ordenacion por insercion.
			Arrays.sort(puntuacion_records);
			// insercion(puntuacion_records);
			int j = 0;
			// Lo mostramos en orden decreciente, dado que sort te lo ordena de menor a
			// mayor.
			for (int i = puntuacion_records.length - 1; i >= 0; i--)
				System.out.println((++j) + ".- " + puntuacion_records[i]);
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("\nERROR AL ABRIR EL ARCHIVO.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR EN LA LECTURA DE DATOS.");
			e.printStackTrace();
		}
	}

	private static void jugar(ArrayList<Pregunta> preguntas, int puntuacion) {
		// Si el archivo no existe se crea
		File f = new File(ruta + "Preguntas.txt");
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
				File f_records = new File(ruta + "records.txt");
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
				BufferedWriter bw = new BufferedWriter(new FileWriter((ruta + "records.txt"), true));
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
								bw = new BufferedWriter(new FileWriter(ruta + "records.txt"));
								bw.write(j.getNombre() + ":" + j.getPuntuacion());
							}
							break;
						} else {
							bw = new BufferedWriter(new FileWriter((ruta + "records.txt"), true));
							bw.newLine();
							bw.write(j.getNombre() + ":" + j.getPuntuacion());
						}
						s = br.readLine();
					}
				}
				bw.close();
				br.close();
				mostrar_informe(j.getNombre(), j.getPuntuacion(), j.getNum_pregunta_fallada());
			} catch (FileNotFoundException e1) {
				System.err.println("\nERROR AL ABRIR EL ARCHIVO.");
				e1.printStackTrace();
			} catch (IOException e) {
				System.err.println("\nERROR EN LA LECTURA DE DATOS.");
				e.printStackTrace();
			}
		}

	}

	private static void aniadir_preguntas(Pregunta p, String pregunta, String respuesta1, String respuesta2,
			String respuesta3, String respuesta_correcta) {
		System.out.println("\nIntroduce una pregunta:");
		pregunta = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 1:");
		respuesta1 = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 2:");
		respuesta2 = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 3:");
		respuesta3 = sc.nextLine();
		System.out.println("\nInFtroduce la respuesta correcta:");
		respuesta_correcta = sc.nextLine();
		p = new Pregunta(pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter((ruta + "Preguntas.txt"), true));
			bw.write(p.toString());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("Error en la escritura de datos.");
			e.printStackTrace();
		}
	}

	private static void instrucciones() {
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

	private static void importar_preguntas() {
		File preguntas_txt = new File(fichero_preguntas);
		File preguntas_xls = new File(fichero_xls);
		if (!preguntas_txt.exists()) {
			try {
				preguntas_txt.createNewFile();
			} catch (IOException e) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO.");
				e.printStackTrace();
			}
		}
		if (!preguntas_xls.exists()) {
			System.out.println("\nNo existe el fichero " + fichero_xls + ".\nDebe crearlo en " + "la ruta: " + ruta);
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fichero_preguntas, true));
				Workbook w = Workbook.getWorkbook(preguntas_xls);
				Sheet sheet = w.getSheet(0);

				for (int i = 0; i < sheet.getRows(); i++) {
					String content = "";
					for (int j = 0; j < sheet.getColumns(); j++) {
						content += sheet.getCell(j, i).getContents() + "#";
					}
					// System.out.println(content);
					bw.write(content);
					bw.newLine();
				}
				w.close();
				bw.close();
			} catch (BiffException e) {
				System.err.println("\nERROR AL LEER EL FICHERO " + fichero_xls);
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("\nERROR EN EL FLUJO DE ESCRITURA DE DATOS.");
				e.printStackTrace();
			}
		}
	}
}
