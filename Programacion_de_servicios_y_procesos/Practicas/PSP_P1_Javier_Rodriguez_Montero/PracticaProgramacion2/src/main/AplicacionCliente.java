package main;

import clases.Cliente;
import clases.ReservaBilletes;

public class AplicacionCliente {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		ReservaBilletes.inicializarVagon();
		System.out.println("\nIniciando cliente\n");
		cliente.initCliente();
	}

}
