package clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public void conectar(String ip, int puerto) {
		Socket cs = null;
		String mensaje = null;
		Scanner sc = new Scanner(System.in);

		try {
			cs = new Socket(ip, puerto); // En el socket se le pasa el ip y el puerto.
			System.out.println("Se ha conectado correctamente.");

			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			
			mensaje = dis.readLine();
			System.out.println("Mensaje recibido por el servidor: " + mensaje);
			
			
			do {
				System.out.println("Introduce un mensaje: ");
				mensaje = sc.nextLine();

				dos.writeChars(mensaje+"\n");

			} while (!mensaje.equalsIgnoreCase("Salir"));

			dos.close();
			dis.close();
			cs.close();
		} catch (UnknownHostException e) {
			System.out.println("Error, no se encontro el servidor.");
		} catch (IOException e) {
			System.out.println("Error, conexion rechazada por el servidor.");

		}
	}
}
