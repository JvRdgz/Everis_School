/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexion;

/**
 *
 * @author Javi
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Servidor3MensajesContinuosMultiCliente_old {

    static int PUERTO = 5000;
    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;

    public void initServidor() {

        Scanner teclado = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(PUERTO);
            socket = new Socket();

            System.out.println("Esperando conexión...");
            //esperamos la conexion hasta que entra y la aceptamos

            do {
               
                socket = serverSocket.accept();
                
                System.out.println("Se conecto uno... Esperando a recibir mensaje");
                //new DataOutputStream(socket.getOutputStream()).writeUTF("menu");
                GestionConexionCliente_old conexion = new GestionConexionCliente_old(socket);
                conexion.start();

               
            } while (true);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Servidor3MensajesContinuosMultiCliente_old o = new Servidor3MensajesContinuosMultiCliente_old();
        o.initServidor();
    }

}

//class hiloEscribe2 extends Thread {
//
//    DataOutputStream salida;
//
//    hiloEscribe2(DataOutputStream salida) {
//        this.salida = salida;
//    }
//
//    @Override
//    public void run() {
//        String msn = "";
//        Scanner teclado = new Scanner(System.in);
//        do {
//            //System.out.println("Escriba un msn para enviar");
//            msn = teclado.nextLine();
//            try {
//                salida.writeUTF("El servidor dice: \n" + msn);//enviamos mensaje
//            } catch (IOException ex) {
//                Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } while (!msn.equals("fin"));
//    }
//}
//
//class hiloLee2 extends Thread {
//
//    DataInputStream entrada;
//
//    hiloLee2(DataInputStream entrada) {
//        this.entrada = entrada;
//    }
//
//    @Override
//    public void run() {
//        String mensajeRecibido = "";
//        do {
//            //System.out.println("Escriba un msn para enviar");            
//            try {
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                System.out.println(mensajeRecibido);
//            } catch (IOException ex) {
//                Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } while (!mensajeRecibido.equals("fin"));
//    }
//}

