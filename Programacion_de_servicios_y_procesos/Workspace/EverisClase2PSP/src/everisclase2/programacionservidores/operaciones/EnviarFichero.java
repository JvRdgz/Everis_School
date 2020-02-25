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
public class EnviarFichero implements Serializable {
    
    byte[] contenidoFichero;
    String nombre;
    String directorio;
    
    public EnviarFichero(byte[] contenidoFichero, String nombre, String directorio)
    {
        this.contenidoFichero = contenidoFichero;
        this.nombre = nombre;
        this.directorio = directorio;
        
    }
    
    public byte[] getContenidoFichero()
    {
        return contenidoFichero;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    
    public String getDirectorio()
    {
        return directorio;
    }
    
    
}
