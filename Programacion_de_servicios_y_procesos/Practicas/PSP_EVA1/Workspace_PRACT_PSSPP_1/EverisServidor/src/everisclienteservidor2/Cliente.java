/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclienteservidor2;

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
	static String HOST = "localhost";
	static int PUERTO = 5000;
	Socket socket;
	DataOutputStream salida;
	DataInputStream entrada;
	String mensajeRecibido;

	public void initCliente() {
		Scanner teclado = new Scanner(System.in);
		try {
			socket = new Socket(HOST, PUERTO);
			// obtenemos el flujo para leer la salida
			salida = new DataOutputStream(socket.getOutputStream());
			// obtenemos el flujo para leer la entrada
			entrada = new DataInputStream(socket.getInputStream());
			// aqui vamos a recoger el mensaje que escribamos desde el cliente
			String msn = "";
			// mientras no enviemos una x seguimos pidiendo mensajes
			System.out.println("Escriba un msn para enviar");
			while (!msn.equals("x")) {
				// System.out.println("Escriba un msn para enviar");
				msn = teclado.nextLine();
				salida.writeUTF("El cliente dice: \n" + msn + "\n\nEcriba su respuesta.");// enviamos mensaje
				mensajeRecibido = entrada.readUTF();// Leemos respuesta
				System.out.println(mensajeRecibido);
			}

			socket.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		Cliente o = new Cliente();
		o.initCliente();
	}

}