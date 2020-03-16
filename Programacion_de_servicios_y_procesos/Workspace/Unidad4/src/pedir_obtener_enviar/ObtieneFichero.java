package pedir_obtener_enviar;

import java.io.Serializable;

public class ObtieneFichero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] contenidoFichero;

	public ObtieneFichero(byte[] contenidoFichero) {
		this.contenidoFichero = contenidoFichero;
	}

	public byte[] getContenidoFichero() {
		return contenidoFichero;
	}
}
