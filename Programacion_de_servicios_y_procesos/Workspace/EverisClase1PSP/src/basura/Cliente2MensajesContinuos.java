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

public class Cliente2MensajesContinuos {

    static String HOST = "localhost";
    static int PUERTO = 5000;
    Socket sc;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;

    public void initCliente() {
        Scanner teclado = new Scanner(System.in);
        try {
            sc = new Socket(HOST, PUERTO);
//            obtenemos el flujo para leer la entrada
            salida = new DataOutputStream(sc.getOutputStream());
            //obtenemos el flujo para leer la entrada
            entrada = new DataInputStream(sc.getInputStream());
            //aquí vamos a recoger el mensaje que escribamos desde el cliente
            String msn = "";
            //mientras no enviemos una x seguimos pidiendo mensajes

            hiloEscribe escribir = new hiloEscribe(salida);
            escribir.start();
            hiloLee leer = new hiloLee(entrada);
            leer.start();
            do{
                
            }while(true);
            
//            while (!msn.equals("x")) {
////                System.out.println("Escriba un msn para enviar");
////                msn = teclado.nextLine();
////                entrada.writeUTF("El cliente dice: \n" + msn + "\n\nEcriba su respueta.");//enviamos mensaje
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                System.out.println(mensajeRecibido);
//            }

            //sc.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Cliente2MensajesContinuos o = new Cliente2MensajesContinuos();
        o.initCliente();
    }

}

class hiloEscribe extends Thread {
DataOutputStream salida;
    hiloEscribe(DataOutputStream salida) {
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
                salida.writeUTF("El cliente dice: \n" + msn);//enviamos mensaje
            } catch (IOException ex) {
                Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!msn.equals("fin"));
    }
}


class hiloLee extends Thread
{DataInputStream entrada;
    hiloLee(DataInputStream entrada) {
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