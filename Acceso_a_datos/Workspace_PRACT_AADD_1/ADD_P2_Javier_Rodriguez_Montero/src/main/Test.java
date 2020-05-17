package main;

import java.util.ArrayList;

import base_de_datos.ConexionDAO;
import base_de_datos.PreguntaDAO;
import clases.Pregunta;

public class Test {

	public static void main(String[] args) {
		PreguntaDAO.setConexion(ConexionDAO.getConexion());
		ArrayList<Pregunta> pregunta = PreguntaDAO.consultarPreguntas();

		for (int i = 0; i < pregunta.size(); i++) {
			System.out.println(pregunta.get(i).toString());
		}

		int i = 0;
		while (i < pregunta.size()) {
			Pregunta p = new Pregunta(pregunta.get(i).getPregunta(), pregunta.get(i).getRespuesta1(), pregunta.get(i).getRespuesta2(), pregunta.get(i).getRespuesta3());
			System.out.println(p);
			i++;
		}

	}

}
