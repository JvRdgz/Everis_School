/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basura;

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor2MensajesContinuos {

    static int PUERTO = 5000;
    ServerSocket serverSocket;
    Socket Socket;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;

    public void initServidor() {

        Scanner teclado = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(PUERTO);
            Socket = new Socket();

            System.out.println("Esperando conexión...");
            //esperamos la conexion hasta que entra y la aceptamos

            do {
                Socket = serverSocket.accept();
                System.out.println("Se conecto uno... Esperando a recibir mensaje");

                //obtenemos los flujos de Entrada y Salida
                entrada = new DataInputStream(Socket.getInputStream());
                salida = new DataOutputStream(Socket.getOutputStream());

                hiloLee2 leer = new hiloLee2(entrada);
                leer.start();
                hiloEscribe2 escribir = new hiloEscribe2(salida);
                escribir.start();

            } while (Socket == null);
//
////            System.out.println("Se conecto uno... Esperando a recibir mensaje");
////
////            //obtenemos los flujos de Entrada y Salida
////            entrada = new DataInputStream(Socket.getInputStream());
////            salida = new DataOutputStream(Socket.getOutputStream());
//            //recogemos aquí el mensaje para enviar
//            String msn = "Introduzca cualquiera de las opciones del menu.\n" + ("1.- Reservar Automaticamente el billete\n") + ("2.- Elegir la plaza de la reserva\n") + ("3.- Anular Reserva\n");
//
//            //mientras no el mensaje enviado no sea x mantenemos la comunicacion
//            while (!msn.equals("x")) {
//
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                System.out.println(mensajeRecibido);
//
//                // System.out.println("Escriba un msn para enviar");
//                msn = teclado.nextLine();
//                salida.writeUTF("El servicio tecnico dice: \n" + msn + "\n\nEscriba su respuesta.");//enviamos mensaje
//
//            }
//
//            //cerramos el flujo.
//            serverSocket.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Servidor2MensajesContinuos o = new Servidor2MensajesContinuos();
        o.initServidor();
    }

}

class hiloEscribe2 extends Thread {

    DataOutputStream salida;

    hiloEscribe2(DataOutputStream salida) {
        this.salida = salida;
    }

    @Override
    public void run() {
        String msn = "";
        Scanner teclado = new Scanner(System.in);
        do {
            //System.out.println("Escriba un msn para enviar");
            msn = teclado.nextLine();
            try {
                salida.writeUTF("El servidor dice: \n" + msn);//enviamos mensaje
            } catch (IOException ex) {
                Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!msn.equals("fin"));
    }
}

class hiloLee2 extends Thread {

    DataInputStream entrada;

    hiloLee2(DataInputStream entrada) {
        this.entrada = entrada;
    }

    @Override
    public void run() {
        String mensajeRecibido = "";
        do {
            //System.out.println("Escriba un msn para enviar");            
            try {
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);
            } catch (IOException ex) {
                Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!mensajeRecibido.equals("fin"));
    }
}
