package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Pregunta {

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

	public static void escribir_XML(File f) {

		try {

			BufferedReader br = new BufferedReader(new FileReader(f));

			String s = br.readLine();
			while (s != null) {
				// TENGO QUE LEER EN EL FICHERO Preguntas.txt, y crear un objeto Pregunta.
				// Para ello, tengo que separar por cada linea del fichero, los atributos
				// correspondientes a Pregunta.
				// Esto es necesario porque necesito extraer los campos de la pregunta por
				// separado para despues, mas abajo, crear las etiquetas del XML.
				/*
				 * if (s.contains(j.getNombre())) { String[] datos_records = s.split(":"); //
				 * System.out.println(datos_records[1]); int puntuacion_fichero =
				 * Integer.parseInt(datos_records[1]); if (j.getPuntuacion() >
				 * puntuacion_fichero) { bw = new BufferedWriter(new FileWriter(ruta +
				 * "records.txt")); bw.write(j.getNombre() + ":" + j.getPuntuacion()); } break;
				 * }
				 */
				s = br.readLine();

			}
			br.close();

			String docNuevoStr = "";

			Document docNuevo = new Document();

			Element nodoRaiz = new Element("preguntas");
			docNuevo.addContent(nodoRaiz);

			Element nodoPregunta = new Element("pregunta");
			nodoRaiz.addContent(nodoPregunta);
			// En vez de this.pregunta, seria p.getPregunta();
			// nodoPregunta.setText(this.pregunta);

			Format format = Format.getPrettyFormat();

			XMLOutputter xmloutputter = new XMLOutputter(format);

			docNuevoStr = xmloutputter.outputString(docNuevo);

			System.out.println(docNuevoStr);

			FileWriter fichero = null;

			fichero = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fichero);
			pw.println(docNuevoStr);

			fichero.close();
		} catch (IOException e) {
			System.err.println("\nNO EXISTE EL FICHERO.");
			e.printStackTrace();
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