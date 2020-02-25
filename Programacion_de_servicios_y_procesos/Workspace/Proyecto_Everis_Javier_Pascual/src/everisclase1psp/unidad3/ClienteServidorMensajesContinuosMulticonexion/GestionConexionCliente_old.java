package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class GestionConexionCliente_old extends Thread {

    DataOutputStream salida;
    DataInputStream entrada;

    GestionConexionCliente_old(Socket socketCliente) {

        try {
            this.salida = new DataOutputStream(socketCliente.getOutputStream());
            this.entrada = new DataInputStream(socketCliente.getInputStream());
            //socketCliente.bind(socketCliente.getLocalSocketAddress());
        } catch (IOException ex) {
//            Logger.getLogger(GestionConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        

            HiloGestionConexionClienteLeer leer = new HiloGestionConexionClienteLeer(this.entrada);
            leer.start();
            HiloGestionConexionClienteEscribir escribir = new HiloGestionConexionClienteEscribir(this.salida);
            escribir.start();
        

    }

}

class HiloGestionConexionClienteEscribir extends Thread {

    DataOutputStream salida;

    HiloGestionConexionClienteEscribir(DataOutputStream salida) {
        this.salida = salida;
    }

    @Override
    public void run() {
        String msn = "";
        Scanner teclado = new Scanner(System.in);
        do {
            //System.out.println("Escriba un msn para enviar");
           // msn = teclado.nextLine();
            try {
                salida.writeUTF("El servidor dice: \n" + msn);//enviamos mensaje
            } catch (IOException ex) {
                Logger.getLogger(HiloGestionConexionClienteEscribir.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!msn.equals("fin"));
    }
}

class HiloGestionConexionClienteLeer extends Thread {

    DataInputStream entrada;

    HiloGestionConexionClienteLeer(DataInputStream entrada) {
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
                Logger.getLogger(HiloGestionConexionClienteEscribir.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!mensajeRecibido.equals("fin"));
    }
}
