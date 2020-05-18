package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import base_de_datos.ConexionDAO;
import base_de_datos.PreguntaDAO;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import properties.Persistencia;

public class Pregunta {

	private static Logger log = Logger.getLogger(Pregunta.class);
	static Scanner sc = new Scanner(System.in);
	private String pregunta;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private String respuesta_correcta;

	public Pregunta() {
		this.pregunta = "";
		this.respuesta1 = "";
		this.respuesta2 = "";
		this.respuesta3 = "";
		this.respuesta_correcta = "";
	}

	public Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3,
			String respuesta_correcta) {
		this.pregunta = pregunta;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta_correcta = respuesta_correcta;
	}

	public static void escribir_XML() {
		PropertyConfigurator.configure("./Properties/log4j.properties");
		if (Persistencia.is_file_method()) {
			log.info("Escribir XML leyendo desde fichero.");
			try {
				Pregunta p;

				BufferedReader br = new BufferedReader(new FileReader(Files.getFichero_preguntas()));

				String s = br.readLine();
				// TENGO QUE LEER EN EL FICHERO Preguntas.txt, y crear un objeto Pregunta.
				// Para ello, tengo que separar por cada linea del fichero, los atributos
				// correspondientes a Pregunta.
				// Esto es necesario porque necesito extraer los campos de la pregunta por
				// separado para despues, mas abajo, crear las etiquetas del XML.

				String docNuevoStr = "";

				Document docNuevo = new Document();

				Element nodoRaiz = new Element("preguntas");
				docNuevo.addContent(nodoRaiz);

				while (s != null) {
					String[] s_parts = s.split("#");
					p = new Pregunta(s_parts[0], s_parts[1], s_parts[2], s_parts[3], s_parts[4]);

					Element nodoPregunta = new Element("pregunta");

					nodoRaiz.addContent(nodoPregunta);

					nodoPregunta.setText(p.getPregunta());
					Format format = Format.getPrettyFormat();

					XMLOutputter xmloutputter = new XMLOutputter(format);

					docNuevoStr = xmloutputter.outputString(docNuevo);

					s = br.readLine();

				}
				System.out.println(docNuevoStr);

				br.close();

				FileWriter fichero = null;

				fichero = new FileWriter(Files.getFichero_xml());
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(docNuevoStr);

				fichero.close();
			} catch (IOException e) {
				System.err.println("\nNO EXISTE EL FICHERO.");
				e.printStackTrace();
			}
		} else {
			log.info("Escribir XML leyendo desde base de datos.");
			PreguntaDAO.setConexion(ConexionDAO.getConexion());
			ArrayList<Pregunta> preguntas = PreguntaDAO.consultarPreguntas();
			Pregunta p;
			try {

				String docNuevoStr = "";

				Document docNuevo = new Document();

				Element nodoRaiz = new Element("preguntas");
				docNuevo.addContent(nodoRaiz);
				int i = 0;
				while (i < preguntas.size()) {
					// String[] s_parts = s.split("#");
					p = preguntas.get(i);
					// p = new Pregunta(s_parts[0], s_parts[1], s_parts[2], s_parts[3], s_parts[4]);

					Element nodoPregunta = new Element("pregunta");

					nodoRaiz.addContent(nodoPregunta);

					nodoPregunta.setText(p.getPregunta());
					Format format = Format.getPrettyFormat();

					XMLOutputter xmloutputter = new XMLOutputter(format);

					docNuevoStr = xmloutputter.outputString(docNuevo);
					i++;

				}
				System.out.println(docNuevoStr);
				FileWriter fichero = null;

				fichero = new FileWriter(Files.getFichero_xml());
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(docNuevoStr);

				fichero.close();
			} catch (IOException e) {
				System.err.println("\nNO EXISTE EL FICHERO.");
				e.printStackTrace();
			}
		}
	}

	// AÑADE UNA PREGUNTA AL FICHERO Preguntas.txt O A LA BASE DE DATOS, SEGUN SE
	// HAYA ESPECIFICADO
	// EN EL FICHERO persistencia.properties
	public static void aniadir_preguntas(Pregunta p, String pregunta, String respuesta1, String respuesta2,
			String respuesta3, String respuesta_correcta) {
		System.out.println("\nIntroduce una pregunta:");
		pregunta = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 1:");
		respuesta1 = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 2:");
		respuesta2 = sc.nextLine();
		System.out.println("\nIntroduce posible respuesta 3:");
		respuesta3 = sc.nextLine();
		System.out.println("\nIntroduce la respuesta correcta:");
		respuesta_correcta = sc.nextLine();
		p = new Pregunta(pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
		if (Persistencia.is_file_method()) {
			try {
				// ESTO PUEDO HACERLO EN UNA CLASE DIFERENTE DONDE SE CONTROLEN LAS LECTURAS Y
				// ESCRITURAS DE FICHEROS.
				BufferedWriter bw = new BufferedWriter(new FileWriter((Files.getFichero_preguntas()), true));
				bw.write(p.toString());
				bw.newLine();
				bw.close();
			} catch (IOException e) {
				System.err.println("ERROR EN LA ESCRITURA DE DATOS.");
				e.printStackTrace();
			}
		} else {
			PreguntaDAO.setConexion(ConexionDAO.getConexion());
			PreguntaDAO.insertarPregunta(p);
		}
	}

	// EXPORTA LAS PREGUNTAS AL FICHERO preguntas.xml O A LA BASE DE DATOS, SEGUN SE
	// HAYA ESPECIFICADO
	// EN EL FICHERO persistencia.properties
	public static void exportar_preguntas() {
		File f = new File(Files.getFichero_xml());
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO XML.");
				e1.printStackTrace();
			}
		}
		escribir_XML();
	}

	public static void importar_preguntas() {
		PropertyConfigurator.configure("./Properties/log4j.properties");
		if (Persistencia.is_file_method()) {

			File preguntas_txt = new File(Files.getFichero_preguntas());
			File preguntas_xls = new File(Files.getFichero_xls());
			if (!preguntas_txt.exists()) {
				try {
					preguntas_txt.createNewFile();
				} catch (IOException e) {
					System.err.println("\nERROR AL CREAR EL ARCHIVO.");
					e.printStackTrace();
				}
			}
			if (!preguntas_xls.exists()) {
				System.out.println("\nNo existe el fichero " + Files.getFichero_xls() + ".\nDebe crearlo en "
						+ "la ruta: " + Files.getRuta_files());
			} else {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(Files.getFichero_preguntas(), true));
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
					System.err.println("\nERROR AL LEER EL FICHERO " + Files.getFichero_xls());
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("\nERROR EN EL FLUJO DE ESCRITURA DE DATOS.");
					e.printStackTrace();
				}
			}
		} else {
			File preguntas_xls = new File(Files.getFichero_xls());
			if (!preguntas_xls.exists()) {
				System.out.println("\nNo existe el fichero " + Files.getFichero_xls() + ".\nDebe crearlo en "
						+ "la ruta: " + Files.getRuta_files());
			} else {
				PreguntaDAO.setConexion(ConexionDAO.getConexion());
				log.debug("ESTABLECIENDO CONEXION PreguntaDAO");
				try {
					Workbook w = Workbook.getWorkbook(preguntas_xls);
					Sheet sheet = w.getSheet(0);

					log.debug("CONSTRUCCION DE PREGUNTA LEIDA A PARTIR DEL FICHERO EXCEL.");
					log.info(
							"A medida que se lee una fila, se crea una nueva pregunta. Mientras que se leen las celdas, se guarda el atributo correspondiente a la pregunta segun el valor de j.");
					for (int i = 0; i < sheet.getRows(); i++) {
						String content = "";
						Pregunta p = new Pregunta();
						log.debug("NUEVA PREGUNTA");
						for (int j = 0; j < sheet.getColumns(); j++) {
							content = sheet.getCell(j, i).getContents();
							switch (j) {
							case 0:
								p.setPregunta(content);
								log.debug("GUARDAMOS CONTENT QUE DEBERIA TENER EL CONTENIDO DE LA PREGUNTA.");
								break;
							case 1:
								p.setRespuesta1(content);
								log.debug("GUARDAMOS CONTENT QUE DEBERIA TENER EL CONTENIDO DE LA RESPUESTA 1.");
								break;
							case 2:
								p.setRespuesta2(content);
								log.debug("GUARDAMOS CONTENT QUE DEBERIA TENER EL CONTENIDO DE LA RESPUESTA 2.");
								break;
							case 3:
								p.setRespuesta3(content);
								log.debug("GUARDAMOS CONTENT QUE DEBERIA TENER EL CONTENIDO DE LA RESPUESTA 3.");
								break;
							case 4:
								p.setRespuesta_correcta(content);
								log.debug("GUARDAMOS CONTENT QUE DEBERIA TENER EL CONTENIDO DE LA RESPUESTA CORRECTA.");
								break;
							}
						}
						System.out.println(p);
						PreguntaDAO.insertarPregunta(p);
					}
					w.close();
				} catch (BiffException e) {
					System.err.println("\nERROR AL LEER EL FICHERO " + Files.getFichero_xls());
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("\nERROR EN EL FLUJO DE ESCRITURA DE DATOS.");
					e.printStackTrace();
				}
			}
		}
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public String getRespuesta_correcta() {
		return respuesta_correcta;
	}

	public void setRespuesta_correcta(String respuesta_correcta) {
		this.respuesta_correcta = respuesta_correcta;
	}

	public String toString() {
		return (this.pregunta + "#" + this.respuesta1 + "#" + this.respuesta2 + "#" + this.respuesta3 + "#"
				+ this.respuesta_correcta);
	}

	public String toStringPersonalizadoSinRespuesta() {
		return (this.pregunta + ": " + this.respuesta1 + " | " + this.respuesta2 + " | " + this.respuesta3 + " |");
	}
}
