package hilos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HiloCrearFicheros implements Runnable {

	private File file;
	private Thread thread;

	public HiloCrearFicheros(File file, Thread thread) {
		super();
		this.file = file;
		this.thread = thread;
	}

	@Override
	public void run() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(".\\" + file));
			int cont = 1;
			if (Thread.currentThread().getName().equals("Hilo_1")) {
				while (cont < 101) {
					bw.write("Soy el hilo " + this.thread.getName() + ", mi prioridad es " + this.thread.getPriority()
							+ " y estoy escribiendo en el fichero " + this.file.getName());
					bw.newLine();
					cont++;
				}
				thread.join();
				System.out.println("\n\tHilo " + this.thread.getName() + " finalizado.");
			} else if (Thread.currentThread().getName().equals("Hilo_2")) {
				while (cont < 101) {
					bw.write("Soy el hilo " + this.thread.getName() + ", mi prioridad es " + this.thread.getPriority()
							+ " y estoy escribiendo en el fichero " + this.file.getName());
					bw.newLine();
					cont++;
				}
				thread.join();
				System.out.println("\n\tHilo " + this.thread.getName() + " finalizado.");
			} else if (Thread.currentThread().getName().equals("Hilo_3")) {
				while (cont < 101) {
					bw.write("Soy el hilo " + this.thread.getName() + ", mi prioridad es " + this.thread.getPriority()
							+ " y estoy escribiendo en el fichero " + this.file.getName());
					bw.newLine();
					cont++;
				}
				thread.join();
				System.out.println("\n\tHilo " + this.thread.getName() + " finalizado.");
			}
			bw.close();
		} catch (IOException e) {
			System.err.println("\nERROR EN LA LECTURA DE DATOS.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("\nERROR EN EL PROCESAMIENTO DE HILOS");
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Override
	public String toString() {
		return "Hilo [file=" + file + ", thread=" + thread + "]";
	}

}
