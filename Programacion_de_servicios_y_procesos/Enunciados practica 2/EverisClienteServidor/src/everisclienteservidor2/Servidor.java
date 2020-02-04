/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclienteservidor2;

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
 
public class Servidor{
    static int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
 
    public void initServidor(){
         
        Scanner teclado = new Scanner(System.in);
        try{
            sc = new ServerSocket(PUERTO);
            so = new Socket();
             
            System.out.println("Esperando conexión...");
            //esperamos la conexion hasta que entra y la aceptamos
            so = sc.accept();
            System.out.println("Se conecto uno... Esperando a recibir mensaje");
           
//             System.out.println("1.- Reservar Billete");
//                System.out.println("2.- Chat");
//                System.out.println("0.-Salir");
//            
            //obtenemos los flujos de Entrada y Salida
            entrada = new DataInputStream(so.getInputStream());
            salida = new DataOutputStream(so.getOutputStream());
            
            //recogemos aquí el mensaje para enviar
            String msn = "";
            
            //mientras no el mensaje enviado no sea x mantenemos la comunicacion
            while(!msn.equals("x")){
                 
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);
               
               // System.out.println("Escriba un msn para enviar");
                msn = teclado.nextLine();
                salida.writeUTF("El servicio tecnico dice: \n"+msn + "\n\nEscriba su respuesta.");//enviamos mensaje
 
            }
            
            //cerramos el flujo.
            sc.close();
        }catch(Exception e){
 
        }
    }
 
    public static void main(String[] args){
        Servidor o = new Servidor();
        o.initServidor();
    }
 
}