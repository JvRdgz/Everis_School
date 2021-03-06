package xml_content;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

/**
 * @author davidrc
 */
public class LeerXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Se crea un SAXBuilder para poder parsear el archivo
		SAXBuilder builder = new SAXBuilder();

		File xmlFile = new File("." + File.separator + "XML_Files" + File.separator + "ciudades_salida.xml");

		try {

			// Se crea el documento a traves del archivo
			Document document = builder.build(xmlFile);

			// Se obtiene la raiz 'ciudades'
			Element rootNode = document.getRootElement();

			// Se obtiene el nombre del nodo raiz
			String nombreNodo = rootNode.getName();

			System.out.println(nombreNodo);

			// Se obtiene la lista de hijos del nodo raiz
			List lista_ciudades = rootNode.getChildren("ciudad");

			/*
			 * Element ciudad = (Element) lista_ciudades.get(0); String nombre =
			 * ciudad.getChild("nombre").getText(); System.out.println(nombre);
			 * 
			 * ciudad = (Element) lista_ciudades.get(1); String pais =
			 * ciudad.getChild("pais").getText(); System.out.println(pais);
			 */

			// Se recorre la lista de hijos del nodo
			for (int i = 0; i < lista_ciudades.size(); i++) {
				// Se obtiene el elemento 'ciudad'
				// Element ciudad = (Element) lista_ciudades.get(0);
				Element ciudad = (Element) lista_ciudades.get(i);
				// ESTO
				Element elemento_nombre = ciudad.getChild("nombre");
				String nombre = elemento_nombre.getText();

				// O ESTO
				// Se obtiene el valor que esta entre los tags '<nombre></nombre>'
				nombre = ciudad.getChildText("nombre");

				// Se obtiene el valor que esta entre los tags '<pais></pais>'
				String pais = ciudad.getChildText("pais");

				// System.out.println(nombre+"\t\t"+pais);

				Element elemento_pais = ciudad.getChild("pais");
				// Se obtiene el atributo 'continente' que esta en el tag 'pais'
				String continente = elemento_pais.getAttributeValue("continente");
				System.out.println(nombre + "\t\t" + pais + "\t\t" + continente);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
