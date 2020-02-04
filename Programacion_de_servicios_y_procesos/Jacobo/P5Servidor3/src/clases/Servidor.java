package clases;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class Servidor {

	private ArrayList<String> apuntados;
	
	public Servidor() {
		apuntados = new ArrayList<>();
	}
	
	public void iniciarServidor(int puerto) {
		DatagramSocket miSocket = null;
		byte[] buffer = new byte[100];
		String mensaje = null;
		
		try {
			miSocket = new DatagramSocket(puerto);
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			
			while(true) {
				miSocket.receive(peticion);
				mensaje = new String(peticion.getData(), peticion.getOffset(), peticion.getLength());

				//buffer = new byte[100]; //después de leer vacío el buffer
				//System.out.println("Mensaje recibido: " + mensaje);
				
				if (mensaje.startsWith("Nombre: ")) {
					String nombre = mensaje.subSequence(8, mensaje.length()).toString();
					this.apuntados.add(nombre); //subSequence se usa para que no me cuente el Nombre: + espacio en blanco
					//System.out.println("Añadido " + nombre);
					
				} else if (mensaje.startsWith("apuntados")) {
					
					//Obtener direccion y puerto del cliente para contestar
					InetAddress direccionCliente = peticion.getAddress();
					int puertoCliente = peticion.getPort();
					
					
					//Este for each es para mandarle los apuntados;
					/*
					for (String nombre : this.apuntados) {
						DatagramPacket respuesta = new DatagramPacket(nombre.getBytes(), nombre.length(), direccionCliente, puertoCliente);
						miSocket.send(respuesta);
					}
					*/
					
					for (int i=0; i<this.apuntados.size(); i++) {
						//System.out.println("Enviando " + this.apuntados.get(i));
						DatagramPacket respuesta = new DatagramPacket(this.apuntados.get(i).getBytes(), this.apuntados.get(i).length(), direccionCliente, puertoCliente);
						miSocket.send(respuesta);
					}
					
					String fin = "fin";
					DatagramPacket respuesta = new DatagramPacket(fin.getBytes(), fin.length(), direccionCliente, puertoCliente);
					miSocket.send(respuesta);
				} else {
					System.out.println("Error. Mensaje no soportado: '" + mensaje + "'");
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
