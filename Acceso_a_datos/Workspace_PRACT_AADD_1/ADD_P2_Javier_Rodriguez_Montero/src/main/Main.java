package main;

import clases.Juego;
import clases.Menu;

public class Main {

	public static void main(String[] args) {
		Juego.crear_ficheros();
		Menu.menuPrincipal();
	}
}