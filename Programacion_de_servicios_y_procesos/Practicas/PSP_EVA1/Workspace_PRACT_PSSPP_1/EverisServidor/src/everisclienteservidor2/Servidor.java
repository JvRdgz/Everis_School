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

public class Servidor {
	static int PUERTO = 5000;
	ServerSocket serversocket;
	Socket socket;
	DataOutputStream salida;
	DataInputStream entrada;
	String mensajeRecibido;

	public void initServidor() {

		Scanner sc = new Scanner(System.in);
		try {
			serversocket = new ServerSocket(PUERTO);
			socket = new Socket();

			System.out.println("Esperando conexion...");
			// esperamos la conexion hasta que entra y la aceptamos
			
			socket = serversocket.accept();
			
			System.out.println("Se conecto uno... Esperando a recibir mensaje");

			// obtenemos los flujos de Entrada y Salida
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());

			// recogemos aqui el mensaje para enviar
			String msn = "";

			// mientras no el mensaje enviado no sea x mantenemos la comunicacion
			while (!msn.equals("x")) {

				mensajeRecibido = entrada.readUTF();// Leemos respuesta
				System.out.println(mensajeRecibido);

				// System.out.println("Escriba un msn para enviar");
				msn = sc.nextLine();
				salida.writeUTF("El servicio tecnico dice: \n" + msn + "\n\nEscriba su respuesta.");// enviamos mensaje

			}

			// cerramos el flujo.
			serversocket.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		Servidor o = new Servidor();
		o.initServidor();
	}

}