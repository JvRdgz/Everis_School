package clases;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

	private final int PUERTO = 1234; // Puerto para la conexion
	private final String HOST = "127.0.0.1"; // Host para la conexion
	protected String mensajeServidor; // Mensajes entrantes en el servidor
	private ServerSocket ss; // Socket del servidor
	private Socket cs; // Socket del cliente
	private DataOutputStream salidaServidor; // Flujo de datos

	public void iniciarCliente() {
		try {
			cs = new Socket(HOST, PUERTO); // Socket para el cliente
			// Flujo de datos hacia el servidor

			// Se enviaran dos mensajes
			for (int i = 0; i < 2; i++) {
				// Se escribe en el servidor usando su flujo de datos
				salidaServidor.writeUTF("Mensaje n� " + (i + 1) + "\n");
			}

			cs.close(); // Fin de la conexion
		} catch (Exception e) {
			System.err.println("\nERROR");
		}
	}
}
