package clases;

import java.util.Scanner;

public class Main_cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una ip: ");
		String ip = sc.nextLine();
		
		System.out.println("Introduce un puerto: ");
		int puerto = Integer.parseInt(sc.nextLine());
		
		Cliente cliente = new Cliente();
		
		cliente.iniciarCliente(puerto, ip);
	}
}
