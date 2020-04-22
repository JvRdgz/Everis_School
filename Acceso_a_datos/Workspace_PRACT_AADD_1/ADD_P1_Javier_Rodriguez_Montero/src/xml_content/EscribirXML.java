package xml_content;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.itextpdf.text.PageSize;

/**
 * @author davidrc
 */
public class EscribirXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String docNuevoStr = "";

		try {

			Document docNuevo = new Document();

			Element nodoRaiz = new Element("ciudades");
			docNuevo.addContent(nodoRaiz);
			// docNuevo.addContent(nodoRaiz);

			Element nodoCiudad = new Element("ciudad");
			nodoRaiz.addContent(nodoCiudad);
			nodoCiudad.setText("Madrid");

			// Vamos a serializar el XML
			// Lo primero es obtener el formato de salida
			// Partimos del "Formato bonito", aunque también existe el plano y el compacto
			Format format = Format.getPrettyFormat();
			// OTROS FORMATOS
			// getCompactFormat();
			// getRawFormat();

			// Creamos el serializador con el formato deseado
			XMLOutputter xmloutputter = new XMLOutputter(format);
			// Serializamos nuestro nuevo document
			docNuevoStr = xmloutputter.outputString(docNuevo);

			// Se imprime el resultado
			System.out.println(docNuevoStr);

			// System.out.println(new
			// XMLOutputter(Format.getPrettyFormat()).outputString(docNuevo));

		} catch (Exception e) {
			e.printStackTrace();
		}

		FileWriter fichero = null;
		try {
			fichero = new FileWriter("." + File.separator + "XML_Files" + File.separator + "ciudades_salida.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No existe el fichero");
		}
		PrintWriter pw = new PrintWriter(fichero);
		pw.println(docNuevoStr);
		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede cerrar el fichero");
		}

	}

}
