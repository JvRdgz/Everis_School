package listas.enlazada;

public class Nodo {

	/**
	 * UN NODO ES UN OBJETO, COMO CUALQUIER OTRO, QUE, A DIFERENCIA DE UN ARRAY
	 * ASIGNA ESPACIO PARA CADA ELEMENTO QUE SE GUARDA, POR SEPARADO, EN SU PROPIO
	 * BLOQUE DE MEMORIA. SUS ATRIBUTOS SON LOS ENCARGADOS DE HACER EL TRABAJO DE
	 * ALMACENAR Y APUNTAR A OTRO NODO.
	 */

	private Nodo siguiente; // PARA HACER REFERENCIA AL SIGUIENTE NODO DE LA LISTA.
	private Object contenido; // PARA ALMACENAR UN OBJETO.

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Object getContenido() {
		return contenido;
	}

	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}
}
