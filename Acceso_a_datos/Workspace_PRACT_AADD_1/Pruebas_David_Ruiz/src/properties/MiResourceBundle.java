package properties;

import java.util.Locale;
import java.util.ResourceBundle;

//https://docs.oracle.com/javase/7/docs/api/java/util/ResourceBundle.html
public class MiResourceBundle {

	public static void main(String[] args) {
	
		Locale locale = new Locale("en");
		ResourceBundle rb = ResourceBundle.getBundle("idioma", locale);
		//ResourceBundle rb = ResourceBundle.getBundle("idioma"); //ra�z del fichero de propiedades
		
		String cadena = rb.getString("terminar");
		System.out.println(cadena);	
		
	}

}
