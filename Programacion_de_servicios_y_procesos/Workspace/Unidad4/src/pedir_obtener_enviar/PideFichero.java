package pedir_obtener_enviar;

import java.io.Serializable;

public class PideFichero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreFichero;
	
	public PideFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public String getNombreFichero() {
		return nombreFichero;
	}
	
	
}
