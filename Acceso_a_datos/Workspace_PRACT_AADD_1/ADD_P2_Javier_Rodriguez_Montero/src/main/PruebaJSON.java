package main;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Pregunta;

public class PruebaJSON {

	public static void main(String[] args) {
		Pregunta p = new Pregunta("Como estas?", "Bien", "Mal", "Sin mas", "Bien");
		String JSON = "";
		Gson gson = new Gson();
		JSON += gson.toJson(p);
		System.out.println(JSON);

		Pregunta p2 = new Pregunta("Como estas?", "Bien", "Mal", "Sin mas", "Bien");
		Pregunta p3 = new Pregunta("Como estas?", "Bien", "Mal", "Sin mas", "Bien");
		Pregunta p4 = new Pregunta("Como estas?", "Bien", "Mal", "Sin mas", "Bien");
		Pregunta p5 = new Pregunta("Como estas?", "Bien", "Mal", "Sin mas", "Bien");

		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

		preguntas.add(p2);
		preguntas.add(p3);
		preguntas.add(p4);
		preguntas.add(p5);

		// CONVERTIMOS A JSON EL ARRAYLIST

		String amigosJSON = gson.toJson(preguntas);
		System.out.println(amigosJSON);

		// CONVERTIMOS EL JSON A ARRAYLIST
		// CREAMOS EL TIPO QUE REPRESENTE EL ARRAYLIST DE OBJ. Pregunta

		Type tipo = new TypeToken<ArrayList<Pregunta>>() {
		}.getType();
		ArrayList<Pregunta> preguntas2 = gson.fromJson(amigosJSON, tipo);
		System.out.println(preguntas2);
	}

}
