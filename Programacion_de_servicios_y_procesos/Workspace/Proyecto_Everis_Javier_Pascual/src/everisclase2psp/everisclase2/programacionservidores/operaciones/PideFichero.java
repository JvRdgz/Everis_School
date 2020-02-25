/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2psp.everisclase2.programacionservidores.operaciones;

import java.io.Serializable;

/**
 *
 * @author Javi
 */
public class PideFichero implements Serializable{
    
    private String nombreFichero;
    
    public PideFichero(String nombreFichero)
    {
        this.nombreFichero = nombreFichero;
    }
    
    public String getNombreFichero()
    {
        return nombreFichero;
    }
            
    
}
