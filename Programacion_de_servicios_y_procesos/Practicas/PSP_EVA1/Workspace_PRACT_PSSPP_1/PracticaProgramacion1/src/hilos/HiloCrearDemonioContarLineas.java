package hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloCrearDemonioContarLineas implements Runnable {

	private Thread hilo;
	private File file;

	public HiloCrearDemonioContarLineas(File file, Thread hilo) {
		this.hilo = hilo;
		this.hilo.setDaemon(true);
		this.file = file;
	}

	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(".\\" + file));
			int cont = 0;
			String s = br.readLine();
			while (s != null) {
				cont++;
				s = br.readLine();
			}
			hilo.join();
			System.out.println("\tEl Fichero " + file.getName() + " tiene: " + cont + " lineas.");
		} catch (FileNotFoundException e) {
			System.err.println("\nERROR AL ABRIR EL FICHERO.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR EN LA ESCRITURA DE DATOS.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("\nERROR EN EL PROCESAMIENTO DE HILOS.");
			e.printStackTrace();
		}
	}
}
