/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.programacionservidores.cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class AplicacionCliente {
    
    private static final int PUERTO = 1234;
    private static final String HOST = "localhost";
    
    
    public static void main(String[] args)
    {
        try {
            Socket s = new Socket(HOST, PUERTO);
            HiloCliente cliente = new HiloCliente(s);
            Thread hilo = new Thread(cliente);
            hilo.start();
        } catch (IOException ex) {
            Logger.getLogger(AplicacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
    
    
}
