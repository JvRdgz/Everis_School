package main;

import clases.Cuenta;

public class Main {

	public static void main(String[] args) throws Exception {
		Cuenta c = new Cuenta("Pepe", "ABCDE1234", 2500);
		
		c.retirar(2500);
		c.ingresar(500);
		System.out.println("Saldo actual:\n" + c.obtenerSaldo() + "€");
	}
}
