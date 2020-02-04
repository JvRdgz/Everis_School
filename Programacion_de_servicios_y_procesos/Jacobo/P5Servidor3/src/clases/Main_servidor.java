package clases;

import java.util.Scanner;

public class Main_servidor {

	public static void main(String[] args) {
		Servidor server = new Servidor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un puerto: ");
		int puerto = Integer.parseInt(sc.nextLine());
		
		server.iniciarServidor(puerto);
	}
}
