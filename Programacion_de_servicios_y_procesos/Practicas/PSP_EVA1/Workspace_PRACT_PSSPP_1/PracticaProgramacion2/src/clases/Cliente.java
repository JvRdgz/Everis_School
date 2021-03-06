package clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static String HOST = "localhost";
	static int PUERTO = 5000;
	Socket socket;
	DataOutputStream salida;
	DataInputStream entrada;
	String mensajeRecibido;

	public void initCliente() {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		String exit = "";
		try {
			socket = new Socket(HOST, PUERTO);

			do {
				System.out.println("Introduzca una opcion: ");

				System.out.println("1.- Reservar Billete");
				System.out.println("2.- Mostrar vagon");
				System.out.println("3.- Chat");
				System.out.println("0.-Salir");

				op = Integer.parseInt(sc.nextLine());

				switch (op) {
				case 1:
					ReservaBilletes.reservarBilletes();
					break;
				case 2:
					ReservaBilletes.mostrarVagon();
					break;
				case 3:
					this.chat();
					break;
				case 0:
					do {
						System.out.println("Seguro que quieres salir? (S para si \\ N para no)");
						exit = sc.nextLine();
					} while (!exit.equalsIgnoreCase("S") && !exit.equalsIgnoreCase("N"));
				}
			} while (op != 0);
			sc.close();
			socket.close();
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

			System.out.println("\n\tBIENVENIDO AL CHAT\n\nEscriba un mensaje:");
			while (!msn.equalsIgnoreCase("Salir")) {

				msn = sc.nextLine();
				// Este mensaje se lo manda al sevidor dado que se lo manda por el flujo
				// 'salida'.
				salida.writeUTF("\nEl cliente dice: \n\n\t- " + msn
						+ "\n\nEscriba su respuesta: (Escriba 'salir' para terminar la conversacion con el cliente)");

				mensajeRecibido = entrada.readUTF();
				System.out.println(mensajeRecibido);

			}
			sc.close();
		} catch (Exception e) {
			System.err.println("\n\tPROGRAMA FINALIZADO");
		}
	}
}
