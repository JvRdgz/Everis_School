package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

//https://docs.oracle.com/javase/7/docs/api/java/util/PropertyResourceBundle.html
public class MiPropertyResourceBundle {

	public static void main(String[] args) {

		try {
			InputStream inputstream = new FileInputStream("." + File.separator + "Files" + File.separator + "bbdd.properties");
			PropertyResourceBundle rb = new PropertyResourceBundle(inputstream);
			String cadena = (String)rb.handleGetObject("bd.nombre");
			System.out.println(cadena);		
			inputstream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}


}
