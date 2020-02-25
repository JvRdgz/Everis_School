/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3.ClienteServidorBasico;

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Servidor1Basico {

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

            socket = serverSocket.accept();
            System.out.println("Se conecto uno... Esperando a recibir mensaje");
        

          
            //obtenemos los flujos de Entrada y Salida
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            //recogemos aquí el mensaje para enviar
             String msn = "Introduzca cualquiera de las opciones del menu.\n" +  ("1.- Reservar Automaticamente el billete\n") + ("2.- Elegir la plaza de la reserva\n") +   ("3.- Anular Reserva\n");

            //mientras no el mensaje enviado no sea x mantenemos la comunicacion
            while (!msn.equals("x")) {

                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);

                // System.out.println("Escriba un msn para enviar");
                msn = teclado.nextLine();
                salida.writeUTF("El servicio tecnico dice: \n" + msn + "\n\nEscriba su respuesta.");//enviamos mensaje

            }

            //cerramos el flujo.
            serverSocket.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
    	Servidor1Basico o = new Servidor1Basico();
        o.initServidor();
    }

}
