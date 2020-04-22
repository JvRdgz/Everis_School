package log4j;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

//https://logging.apache.org/log4j/1.2/apidocs/index.html
//http://programacion.jias.es/2013/03/log4j-tutorial-configuracion-rapida/
//http://migranitodejava.blogspot.com/2011/07/log4j.html
	
public class MiLog {
	
	private static Logger log = Logger.getLogger(MiLog.class);

	public static void main(String[] args) {
		// Salida por consola
		//BasicConfigurator.configure();
		
		// Configuraci�n a trav�s de Clases
//		try {
//			log.addAppender(new FileAppender(new PatternLayout(),"./ficheros/prueba.log", false));
//		} catch (IOException e) {
//			e.printStackTrace();
//			log.error(e.toString());
//		}
		
		// Configuraci�n a trav�s de fichero de propiedades
		PropertyConfigurator.configure("./ficheros/log4j.properties");
		
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");
		
	}

}
