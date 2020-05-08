package clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	static int PUERTO = 5000;
	ServerSocket serverSocket;
	Socket socket;
	DataOutputStream salida;
	DataInputStream entrada;
	String mensajeRecibido;

	public void initServidor() {
		try {
			serverSocket = new ServerSocket(PUERTO);
			socket = new Socket();

			System.out.println("Esperando conexion...");
			socket = serverSocket.accept();

			System.out.println("Se ha conectado un cliente... Esperando a recibir mensaje");

			this.chat();
			serverSocket.close();
		} catch (Exception e) {
			System.err.println("\n\tPROGRAMA FINALIZADO");
		}
	}

	public void chat() {
		Scanner sc = new Scanner(System.in);
		try {
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());

			String msn = "";

			while (!msn.equalsIgnoreCase("Salir")) {

				mensajeRecibido = entrada.readUTF();
				System.out.println(mensajeRecibido);

				msn = sc.nextLine();

				// Este mensaje se lo manda al cliente dado que se lo manda por el flujo
				// 'salida'.
				salida.writeUTF("El servicio tecnico dice: \n\n\t- " + msn
						+ "\n\nEscriba su respuesta: (Escriba 'salir' para terminar la conversacion con el servicio tecnico)");

			}
			sc.close();
		} catch (Exception e) {
			System.err.println("\n\tPROGRAMA FINALIZADO");
		}
	}
}
