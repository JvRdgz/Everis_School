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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Servidor1 {

    private final int PUERTO = 1234;
    private final String HOST = "localhost";
    private String mensajeRecibido;
    private String mensajeEnviado;
    private ServerSocket ss;
    private Socket cs;
    private DataInputStream entradaMensajesCliente;
    private DataOutputStream salidaMensajesServidor;


    public static void main(String... args) {
        Servidor1 servidor = new Servidor1();

        servidor.initServidor();
    }

    public void initServidor() {

        Scanner teclado = new Scanner(System.in);
        try {
            ss = new ServerSocket(PUERTO);
             cs = new Socket();

            System.out.println("Esperando conexión...");
            //esperamos la conexion hasta que entra y la aceptamos

            cs = ss.accept();
            System.out.println("Se conecto uno... Esperando a recibir mensaje");

            //obtenemos los flujos de Entrada y Salida
            entradaMensajesCliente = new DataInputStream(cs.getInputStream());

            //recogemos aquí el mensaje para enviar
            mensajeRecibido = "";
            //mientras no sea x el mensaje enviado no sea x mantenemos la comunicacion abierta
            while (!mensajeRecibido.equals("x")) {

                mensajeRecibido = entradaMensajesCliente.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);

                
            } 
            
            //vamos a contestar
//            mensajeEnviado = "Transmision realizada correctamente";
//            
//            salidaMensajesServidor = new DataOutputStream(cs.getOutputStream());
//            salidaMensajesServidor.writeUTF(mensajeEnviado);
//            
//            do
//            {
//                
//            }while(true);
            
            
            //Cerrariamos los flujos
            
          //  ss.close();
        } catch (Exception e) {

        }
    }

}
