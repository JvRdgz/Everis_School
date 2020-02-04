package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {

	public static void main(String[] args) {

		try {

			ProcessBuilder pb = new ProcessBuilder();
                        // Mi paquete e intruccion seria:
                        //pb.command("java", "pruebas.Main4");
                        //pruebas es el paquete donde se encuentra la clase
                        //que yo quiero ejecutar. En este caso no tiene mucho
                        //sentido que ejecute esta misma clase dado que no hace
                        //nada.
			pb.command("java", "com.everis.HolaMundo");

			File f = new File("./build/classes");

			pb.directory(f);

			Process p = pb.start();

			InputStreamReader isr = new InputStreamReader(p.getInputStream());

			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null)
				System.out.println(line);

			int codigo = p.waitFor();

			System.out.println("\n\tFinalizado con codigo de error: " + codigo);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
