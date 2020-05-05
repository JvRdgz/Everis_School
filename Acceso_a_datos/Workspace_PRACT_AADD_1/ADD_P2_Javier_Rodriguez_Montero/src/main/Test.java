package main;

import java.util.ArrayList;

import base_de_datos.PreguntaDAO;
import clases.Pregunta;

public class Test {

	public static void main(String[] args) {
		ArrayList<Pregunta>pregunta = PreguntaDAO.consultarPreguntas();
		for (int i = 0; i < pregunta.size(); i++) {
			System.out.println(pregunta.get(i));
		}
	}

}
