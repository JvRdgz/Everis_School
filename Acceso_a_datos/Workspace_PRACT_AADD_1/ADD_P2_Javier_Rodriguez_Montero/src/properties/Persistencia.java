package properties;

import clases.Files;

public class Persistencia {

	static String method = Config.getParametro(Files.getPersistencia_properties(), "method");

	public static String getMethod() {
		return method;
	}

	public static boolean comprobarFicheroPersistencia() {
		if (method.equalsIgnoreCase("file") || method.equalsIgnoreCase("bbdd")) {
			System.out.println(method);
			return true;
		} else {
			System.out.println(method);
			return false;
		}
	}

	public static boolean is_file_method() {
		if (method.equalsIgnoreCase("file"))
			return true;
		else
			return false;
	}
}
