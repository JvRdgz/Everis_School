package pruebas;

import java.io.File;
import java.io.IOException;

public class Lanzador {

	public void crearProceso(Integer n1, Integer n2, String fichResultado) {
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "pruebas.Proceso", n1.toString(), n2.toString());
			pb.directory(new File("./build/classes"));
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Lanzador l = new Lanzador();
		l.crearProceso(1, 5, "result1.txt");
		l.crearProceso(6, 10, "result2.txt");
	}

}
