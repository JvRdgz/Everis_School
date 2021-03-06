package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	// ESTE PROGRAMA EN WINDOWS.

	static String ruta = "C:\\TEMA5\\";

	public static void main(String[] args) {
		String s = System.setProperty("java.security.policy", ruta + "Politica1");
		System.setSecurityManager(new SecurityManager());
		File f1 = new File(ruta + "Fichero1.txt");
		File f2 = new File(ruta + "Fichero2.txt");

		if (f1.exists() && f2.exists()) {
			f1.delete();
			f2.delete();
			System.out.println("Ficheros eliminados.");
		}

		try {
			f1.createNewFile();
			f2.createNewFile();
			System.out.println("Ficheros creados.");
		} catch (IOException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al crear los ficheros", e);
			e.printStackTrace();
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
			bw.write("Escrito en fichero 1");
			bw.close();
			bw = new BufferedWriter(new FileWriter(f2));
			bw.write("Escrito en fichero 2");
			bw.close();
			System.out.println("Escrito en ficheros.");
		} catch (IOException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al escribir en los ficheros", e);
			e.printStackTrace();
		}
	}
}
