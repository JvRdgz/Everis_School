package principal;

import java.util.Scanner;

import clases.Servidor;

public class Main {

	public static void main(String[] args) {
		Servidor server = new Servidor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un puerto: ");
		int puerto = Integer.parseInt(sc.nextLine());
		
		server.iniciarServidor(puerto);
	}
}
