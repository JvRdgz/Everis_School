package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
public class Propiedades1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fichero = "./ficheros/bbdd.properties";
		
		Properties properties = new Properties();
		
        try {
        	properties.load(new FileInputStream(fichero));
        } catch (IOException ex) {
        	System.out.println("NO existe el fichero de propiedades");
        	ex.printStackTrace();
        }
        	
		String parametro = properties.getProperty("bd.nombre");
		System.out.println(parametro);

	}

}
