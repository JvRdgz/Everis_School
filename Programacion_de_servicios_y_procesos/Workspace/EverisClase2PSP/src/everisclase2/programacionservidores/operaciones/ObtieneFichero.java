/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.programacionservidores.operaciones;

import java.io.Serializable;

/**
 *
 * @author Javi
 */
public class ObtieneFichero implements Serializable{

    private byte[] contenidoFichero;

    public ObtieneFichero(byte[] contenidoFichero) {
        this.contenidoFichero = contenidoFichero;
    }

    public byte[] getContenidoFichero() {

        return contenidoFichero;
    }
}
