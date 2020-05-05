package clases;

import java.io.File;

import com.itextpdf.text.Document;

public class Files {

	static String ruta_properties = "." + File.separator + "Properties" + File.separator;
	static String ruta_files = "." + File.separator + "Files" + File.separator;
	static File directorio = new File(ruta_files);
	static String fichero_instrucciones = ruta_files + "Instrucciones.txt";
	static String fichero_xml = ruta_files + "preguntas.xml";
	static String fichero_xls = ruta_files + "preguntas.xls";
	static String fichero_preguntas = ruta_files + "Preguntas.txt";
	static String fichero_bbddd_properties = ruta_properties + "bbdd.properties";
	static String fichero_persistencia_properties = ruta_properties + "persistencia.properties";
	static String log4j_properties = ruta_properties + "log4j.properties";
	static Document documento_xml;

	public static String getFichero_instrucciones() {
		return fichero_instrucciones;
	}

	public static String getRuta_properties() {
		return ruta_properties;
	}

	public static String getRuta_files() {
		return ruta_files;
	}

	public static File getDirectorio() {
		return directorio;
	}

	public static String getFichero_xml() {
		return fichero_xml;
	}

	public static String getFichero_xls() {
		return fichero_xls;
	}

	public static String getFichero_preguntas() {
		return fichero_preguntas;
	}

	public static String getBbddd_properties() {
		return fichero_bbddd_properties;
	}

	public static String getPersistencia_properties() {
		return fichero_persistencia_properties;
	}

	public static String getLog4j_properties() {
		return log4j_properties;
	}

	public static Document getDocumento_xml() {
		return documento_xml;
	}
}
