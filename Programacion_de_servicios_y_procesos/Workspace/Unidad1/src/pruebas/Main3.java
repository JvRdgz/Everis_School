package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

	public static void main(String[] args) {

		try {

			ProcessBuilder pb = new ProcessBuilder();
			ProcessBuilder pb2 = new ProcessBuilder();
			pb.command("cmd.exe", "/c", "ping -n 3 goolge.com");
			pb2.command("cmd", "/c", "tasklist /v");

			Process p = pb.start();

			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			int codigo = p.waitFor();
			System.out.println("\n\tFinalizado con codigo de error: " + codigo + "\n\n\n");

			p = pb2.start();

			isr = new InputStreamReader(p.getInputStream());
			br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			codigo = p.waitFor();
			System.out.println("\n\tFinalizado con codigo de error: " + codigo);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
