package clases;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(1234);
			System.out.println("Iniciando servidor...");
			
			while (true) {
				System.out.println("Esperando cliente...");
				Socket cliente = servidor.accept();
				// Cliente conectado
				HiloServidor hiloServidor = new HiloServidor(cliente);
				Thread hilo = new Thread(hiloServidor);
				hilo.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
