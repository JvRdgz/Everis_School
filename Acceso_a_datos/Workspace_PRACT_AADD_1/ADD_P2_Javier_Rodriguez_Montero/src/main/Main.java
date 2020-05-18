package main;

import clases.Menu;
import properties.Persistencia;

public class Main {

	public static void main(String[] args) {
		System.out.println("\n\tBIENVENIDO/A AL JUEGO DE PREGUNTAS Y RESPUESTAS.");
		if (Persistencia.comprobarFicheroPersistencia())
			Menu.menuPrincipal();
		else
			System.err.println("\n\tERROR, DEBES CONFIGURAR EL ARCHIVO persistencia.properties CORRECTAMENTE.");
	}
}