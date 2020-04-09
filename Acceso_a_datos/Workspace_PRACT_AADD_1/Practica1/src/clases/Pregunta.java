package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Pregunta {

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

	public static void escribir_XML(File f_preguntas_xml, File f_preguntas_txt) {

		try {
			Pregunta p;

			BufferedReader br = new BufferedReader(new FileReader(f_preguntas_txt));

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

			fichero = new FileWriter(f_preguntas_xml);
			PrintWriter pw = new PrintWriter(fichero);
			pw.println(docNuevoStr);

			fichero.close();
		} catch (IOException e) {
			System.err.println("\nNO EXISTE EL FICHERO.");
			e.printStackTrace();
		}
	}

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
		System.out.println("\nInFtroduce la respuesta correcta:");
		respuesta_correcta = sc.nextLine();
		p = new Pregunta(pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter((Menu.getRuta() + "Preguntas.txt"), true));
			bw.write(p.toString());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("Error en la escritura de datos.");
			e.printStackTrace();
		}
	}

	public static void exportar_preguntas(String fichero_xml, String fichero_preguntas) {
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
		escribir_XML(f, f2);
	}

	public static void importar_preguntas() {
		File preguntas_txt = new File(Menu.getFichero_preguntas());
		File preguntas_xls = new File(Menu.getFichero_xls());
		if (!preguntas_txt.exists()) {
			try {
				preguntas_txt.createNewFile();
			} catch (IOException e) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO.");
				e.printStackTrace();
			}
		}
		if (!preguntas_xls.exists()) {
			System.out.println("\nNo existe el fichero " + Menu.getFichero_xls() + ".\nDebe crearlo en " + "la ruta: " + Menu.getRuta());
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(Menu.getFichero_preguntas(), true));
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
				System.err.println("\nERROR AL LEER EL FICHERO " + Menu.getFichero_xls());
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("\nERROR EN EL FLUJO DE ESCRITURA DE DATOS.");
				e.printStackTrace();
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
}
