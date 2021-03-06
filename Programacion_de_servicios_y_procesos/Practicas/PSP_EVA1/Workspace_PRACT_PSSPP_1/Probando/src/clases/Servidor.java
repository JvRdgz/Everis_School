package clases;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private final int PUERTO = 1234; // Puerto para la conexion
	private final String HOST = "127.0.0.1"; // Host para la conexion
	protected String mensajeServidor; // Mensajes entrantes en el servidor
	private ServerSocket ss; // Socket del servidor
	private Socket cs; // Socket del cliente
	private DataOutputStream salidaCliente; // Flujo de datos

	public void inicarServidor() {
		try {
			ss = new ServerSocket(PUERTO); // Se crea el Socket para el servidor en puerto 1234
			cs = new Socket(); // Se crea el socket para el cliente

			System.out.println("Esperando conexion..."); // Espera la conexion
			cs = ss.accept(); // Accept comienza el socket y espera una conexion desde un cliente

			System.out.println("Cliente en linea");
			// Se obtiene el flujo de salida del cliente para enviarle mensajes
			salidaCliente = new DataOutputStream(cs.getOutputStream());

			// Se le envia un mensaje al cliente usando su flujo de salida
			salidaCliente.writeUTF("Peticion recibida y aceptada");

			// Se obtiene el flujo entrante desde el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

			while ((mensajeServidor = entrada.readLine()) != null) {
				// Se muestra por pantalla el mensaje recibido
				System.out.println(mensajeServidor);
			}
			System.out.println("Fin de la conexion.");
			ss.close();
		} catch (IOException e) {
			System.err.println("\nERROR.");
			e.printStackTrace();
		}
	}
}
