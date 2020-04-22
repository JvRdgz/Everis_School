package clases;

public class Jugador {

	private String nombre;
	private int puntuacion;
	private int num_preguntas_acertadas;

	public Jugador() {
		this.nombre = "";
		this.puntuacion = 0;
		this.num_preguntas_acertadas = 0;
	}

	public Jugador(String nombre, int puntuacion, int num_preguntas_acertadas) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.num_preguntas_acertadas = num_preguntas_acertadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getNum_pregunta_fallada() {
		return num_preguntas_acertadas;
	}

	public void setNum_pregunta_fallada(int num_preguntas_acertadas) {
		this.num_preguntas_acertadas = num_preguntas_acertadas;
	}

	public String toString() {
		return ("\nNombre: " + this.nombre + "\nPuntuacion total: " + this.puntuacion
				+ "\nNumero de preguntas acertadas: " + this.num_preguntas_acertadas + "\n");
	}
}
