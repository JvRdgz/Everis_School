package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor implements Runnable {

	private BufferedReader entradaCliente; // Flujo de entrada
	private PrintWriter salidaCliente; // Flujo de salida
	private Socket cliente;

	public HiloServidor(Socket cliente) throws IOException {
		this.cliente = cliente;
		entradaCliente = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		salidaCliente = new PrintWriter(cliente.getOutputStream());
	}

	@Override
	public void run() {

		try {
			System.out.println("Comunico con el cliente: " + cliente.toString());
			String msg = "";
			while (!msg.contentEquals("*")) {
				msg = entradaCliente.readLine();
				salidaCliente.println(msg.toUpperCase());
				salidaCliente.flush();
			}
			System.out.println("Fin conexion con el cliente: " + cliente.toString());
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
