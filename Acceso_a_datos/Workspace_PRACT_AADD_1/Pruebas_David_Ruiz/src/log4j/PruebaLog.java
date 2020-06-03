package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PruebaLog {

	private static Logger log = Logger.getLogger(PruebaLog.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./ficheros/log4j.properties");
		
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");		
	}
}
