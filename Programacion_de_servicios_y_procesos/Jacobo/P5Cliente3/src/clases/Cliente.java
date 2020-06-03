package clases;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public void iniciarCliente(int puerto, String ip) {
		Scanner sc = new Scanner(System.in);
		int op;
		byte[] buffer = new byte[100];
		String mensaje=null, mensaje2=null;
		
		DatagramPacket peticion=null;
		DatagramPacket resultado = null;

		try {
			InetAddress hostServidor = InetAddress.getByName(ip);
			DatagramSocket socketUDP = new DatagramSocket();
			
			do {
				System.out.println("1. Apuntar nombre.");
				System.out.println("2. Obtener apuntados.");
				System.out.println("3. Salir");
				System.out.println("Opcion: ");
				op = Integer.parseInt(sc.nextLine());
				
				switch(op) {
				case 1:
					System.out.println("Introduce un nombre: ");
					mensaje = "Nombre: " + sc.nextLine();
					//System.out.println("Enviando " + mensaje);
					
					//Creo el paquete
					peticion = new DatagramPacket(mensaje.getBytes(), mensaje.length(), hostServidor, puerto);
					
					//Envio el paquete, saben la ip y el puerto.
					socketUDP.send(peticion);
					break;
				case 2:
					mensaje = "apuntados";
					peticion = new DatagramPacket(mensaje.getBytes(), mensaje.length(), hostServidor, puerto);
					
					//Envio el paquete, saben la ip y el puerto.
					
					socketUDP.send(peticion);
					
					System.out.println("Lista de apuntados al evento:");
					do {
						//crear otra DatagramPacket para la respuesta
						resultado = new DatagramPacket(buffer, buffer.length, hostServidor, puerto);
						//socketUDP.receive(peticion);
						socketUDP.receive(resultado);
						mensaje2 = new String(resultado.getData(), resultado.getOffset(), resultado.getLength());
						if (!mensaje2.equalsIgnoreCase("fin"))
							System.out.println("\t" + mensaje2); // + "(" + mensaje2.length() + ")");
						//buffer = new byte[100];		
					} while (!mensaje2.equalsIgnoreCase("fin"));
					
					break;
				case 3:
					System.out.println("Salida.");
					socketUDP.close();
					break;
				default:
					System.out.println("Error, opcion no valida.");
				}
			}while(op != 3);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
