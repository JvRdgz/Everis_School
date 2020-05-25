package main;

import clases.Servidor;

public class AplicacionServidor {

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		System.out.println("Iniciando servidor\n");
		servidor.initServidor();
	}

}
