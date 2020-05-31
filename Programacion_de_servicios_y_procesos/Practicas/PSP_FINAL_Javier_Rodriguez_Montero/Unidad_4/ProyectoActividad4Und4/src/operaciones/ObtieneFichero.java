/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.Serializable;

public class ObtieneFichero implements Serializable {

	private static final long serialVersionUID = 1L;
	private byte[] contenidoFichero;

	public ObtieneFichero(byte[] contenidoFichero) {
		this.contenidoFichero = contenidoFichero;
	}

	public byte[] getContenidoFichero() {

		return contenidoFichero;
	}
}
