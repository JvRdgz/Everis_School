/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Cliente1 {

    private final int PUERTO = 1234;
    private final String HOST = "localhost";
    private String mensajeRecibido;
    private String mensajeEnviado;
    private Socket cs;
    private DataInputStream entradaMensajesServidor;
    private DataOutputStream salidaMensajesCliente;
    
    
    public void iniciarCliente()
    {
        try {
            cs = new Socket(HOST, PUERTO);
            
            //Creamos el flujo de datos hacia el servidor
            salidaMensajesCliente = new DataOutputStream(cs.getOutputStream());
            
            for(int i = 0; i<2; i++)
            {
                salidaMensajesCliente.writeUTF("mensaje " + (i+1));
            }
            
//            salidaMensajesCliente.writeUTF("x");
//            
//            //Vamos a leer el mensaje que ha enviado el servidor
//            entradaMensajesServidor = new DataInputStream(cs.getInputStream());
//            mensajeRecibido = entradaMensajesServidor.readUTF();
//            System.out.println(mensajeRecibido);
            
            cs.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String... args)
    {
        Cliente1 cliente = new Cliente1();
        
        cliente.iniciarCliente();
    }


}
