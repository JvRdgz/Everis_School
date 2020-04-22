package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Properties properties = null;
	
	// CONSTRUCTOR CON PARAMETRO EL FICHERO 'bbdd.properties'
	public Config(String fichero) {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(fichero));
		} catch (IOException e) {
			System.err.println("\nNO EXISTE EL FICHERO DE PROPIEDADES.");
			e.printStackTrace();
		}
	}
	
	public static Config getInstance(String fichero) {
		return new Config(fichero);
	}
	
	public static String getParametro(String ficheroConfig, String parametro) {
		String param;
		
		if (properties == null)
			Config.getInstance(ficheroConfig);
		param = properties.getProperty(parametro);
		return param;
	}
}
