package principal;

import java.util.Scanner;

import clases.Cliente;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una ip: ");
		String ip = sc.nextLine();
		
		System.out.println("Introduce un puerto: ");
		int puerto = Integer.parseInt(sc.nextLine());
		
		Cliente cliente = new Cliente();
		
		cliente.conectar(ip, puerto);
	}
}
