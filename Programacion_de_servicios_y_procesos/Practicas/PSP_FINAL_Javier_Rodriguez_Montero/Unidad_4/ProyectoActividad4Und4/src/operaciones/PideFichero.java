/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.Serializable;

public class PideFichero implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreFichero;

	public PideFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

}
