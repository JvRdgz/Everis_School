package clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	@SuppressWarnings("deprecation")
	public void iniciarServidor(int puerto) {
		ServerSocket ss = null;
		String mensaje = null;

		try {
			ss = new ServerSocket(puerto);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			Socket cs = null;

			try {
				System.out.println("\nEsperando conexion.");
				cs = ss.accept();
				System.out.println("Cliente con IP " + cs.getInetAddress() + " conectado.");

				DataInputStream dis = new DataInputStream(cs.getInputStream());
				DataOutputStream dos = new DataOutputStream(cs.getOutputStream());

				dos.writeChars("Hola cliente\n");

				do {
					mensaje = dis.readLine();

					if (mensaje != null)
						System.out.println(mensaje);

				} while (mensaje != null && !mensaje.equalsIgnoreCase("Salir\n"));
				
				dis.close();
				dos.close();
				cs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
