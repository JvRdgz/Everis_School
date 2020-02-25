/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexionListaConexionesFicheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class GestionConexion extends Thread {

    DataOutputStream salida;
    DataInputStream entrada;
    int numConexion;
    File ficheroCliente;

    GestionConexion(Socket socketCliente, int numConexion, File FicheroCliente) {

        try {
            this.entrada = new DataInputStream(socketCliente.getInputStream());
            this.salida = new DataOutputStream(socketCliente.getOutputStream());
            this.numConexion = numConexion;
            this.ficheroCliente = FicheroCliente;
        } catch (IOException ex) {
            Logger.getLogger(GestionConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

//        HiloLeeContestacionServidor leer = new HiloLeeContestacionServidor(entrada, this.numConexion, this.ficheroCliente);
//        leer.start();
//        HiloEscribeMensajeServidor escribir = new HiloEscribeMensajeServidor(salida, this.numConexion, this.ficheroCliente);
//        escribir.start();

        //Hay que lanzar otro hilo en un bucle infinito para lanzar el procesamiento de ficheros desde la carpeta.
        //Quitar todas las trazas!!!!
    }

}

class HiloEscribeMensajeServidor extends Thread {

    DataOutputStream salida;
    int numConexion;
    File FicheroCliente;

    HiloEscribeMensajeServidor(DataOutputStream salida, int numConexion, File ficheroCliente) {
        this.salida = salida;
        this.numConexion = numConexion;
    }

    @Override
    public void run() {
//
//        try {
//            new OperacionesSincronizadas().escribirEnviadosServidor(numConexion, this.salida);
//        } catch (IOException ex) {
//            Logger.getLogger(HiloEscribeMensajeServidor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(HiloEscribeMensajeServidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
        String msn = "";
        Scanner teclado = new Scanner(System.in);
        do {
            //System.out.println("Escriba un msn para enviar");
            System.out.print("Tu dices:");
            msn = teclado.nextLine();
            try {
                salida.writeUTF(this.numConexion + " dice: \n" + msn);//enviamos mensaje

            } catch (IOException ex) {
                // Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!msn.equals("fin"));

//
//
//        
//        String msn = "";
//        Scanner teclado = new Scanner(System.in);
//        do {
//            //System.out.println("Escriba un msn para enviar");
////            teclado = new Scanner(System.in);
////            String contestacion = teclado.nextLine();
//            try {
////                salida.writeUTF("El servidor le dice al cliente: " + this.numConexion + "\n -- " + msn);//enviamos mensaje
//
////             Aqui hay que controlar que el servidor envia mensajes al cliente y el cliente los tiene que recibir y escribir en su fichero
//                new OperacionesSincronizadas().escribirEnviadosServidor(this.numConexion);
//
//            } catch (IOException ex) {
//                //Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(HiloEscribeMensajeServidor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } while (!msn.equals("fin"));
    }
}

class HiloLeeContestacionServidor extends Thread {

    DataInputStream entrada;
    int numConexion;
    File ficheroCliente;
    public final String RUTA = "./FicherosCreados";

    HiloLeeContestacionServidor(DataInputStream entrada, int numConexion, File ficheroCliente) {
        this.entrada = entrada;
        this.numConexion = numConexion;
        this.ficheroCliente = ficheroCliente;
    }

    @Override
    public void run() {

        String mensajeRecibido = "";
        do {
            //System.out.println("Escriba un msn para enviar");            
            try {
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                FileWriter escribir = new FileWriter(this.ficheroCliente, true);
                escribir.write(mensajeRecibido);
                escribir.close();
                
                //System.out.println(mensajeRecibido);
            } catch (IOException ex) {
                //  Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!mensajeRecibido.equals("fin"));

//        String mensajeRecibido = "";
//        do {
//            //System.out.println("Escriba un msn para enviar"); 
//            String msn = "";
//            Scanner teclado = new Scanner(System.in);
//            System.out.print("Tu dices:");
//            msn = teclado.nextLine();
//            try {
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                new OperacionesSincronizadas().escribirRecibidosServidor(numConexion, mensajeRecibido);
//                System.out.println("Almacenado mensaje de cliente" + this.numConexion);
//            } catch (IOException ex) {
//                //     Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                // Logger.getLogger(hiloLeeServidor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } while (!mensajeRecibido.equals("fin"));
    }
}
