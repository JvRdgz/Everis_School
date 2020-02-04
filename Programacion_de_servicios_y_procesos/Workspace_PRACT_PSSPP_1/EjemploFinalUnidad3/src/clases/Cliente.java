package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("localhost", 1234);
			BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salidaServidor = new PrintWriter(cliente.getOutputStream());

			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String msg = "";
			String eco = "";

			do {
				System.out.println("Introduce mensaje: ");
				msg = teclado.readLine();

				salidaServidor.println(msg); // Envio de mensaje al servidor
				eco = entradaServidor.readLine();

				if (!msg.equals("*"))
					System.out.println("Respuesta del servidor: " + eco);

			} while (!msg.equals("*"));

			cliente.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
