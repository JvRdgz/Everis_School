package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder();
			pb.command("cmd", "/c", "dir");
			Process p = pb.start();

//			Recogemos el stream de salida del proceso, y lo
//			leemos utilizando un InputStreamReader con su
//			buffer correspondiente.

			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);

//			Leemos por lineas completas hasta que ya no haya
//			nada mas que leer.

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

//			Con el metodo waitFor() hacemos que el proceso
//			actual espere a que finalice el proceso hijo
//			representado por el objeto Process

			int codigo = p.waitFor();
			System.out.println("\n\tFinalizado con codigo de error: " + codigo);

//			Al ejecutar el codigo, mostrar un listado del
//			directorio actual (el del proyecto), ya que no se ha
//			indicado otro distinto con el metodo directory().

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

}
