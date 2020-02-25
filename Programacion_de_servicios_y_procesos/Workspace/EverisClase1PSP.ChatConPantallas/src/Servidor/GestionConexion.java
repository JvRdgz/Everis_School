package Servidor;

import Ventanas.VentanaServidor;
import Hilos.servidor.HiloGestionConexionClienteEscribir;
import Hilos.servidor.HiloGestionConexionClienteLeer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javi
 */
public class GestionConexion extends Thread {

    Socket socketCliente;
    int numConexion;
    VentanaServidor frmServidor;

    public GestionConexion(Socket socketCliente, int numConexiones) {
        this.socketCliente = socketCliente;
        this.numConexion = numConexiones;
        this.frmServidor = new VentanaServidor();
        this.frmServidor.setVisible(true);
        this.frmServidor.setTitle("Servidor" + this.numConexion);
        frmServidor.panelServidor.oculto.setVisible(false);
        this.frmServidor.panelServidor.chatServidor.setText("Cliente " + this.numConexion + " conectado, envie o espere a recibir mensajes\n");
    }

    @Override
    public void run() {
        try {

            
            
            
            
            HiloGestionConexionClienteEscribir escribe = new HiloGestionConexionClienteEscribir(new DataOutputStream(Servidor.listaConexiones.get(numConexion).getOutputStream()), this.frmServidor, numConexion);
            HiloGestionConexionClienteLeer lee = new HiloGestionConexionClienteLeer(new DataInputStream(Servidor.listaConexiones.get(numConexion).getInputStream()), this.frmServidor);
            //System.out.println(Servidor.listaConexiones.get(numConexion));
            escribe.start();
            lee.start();
            
            

        } catch (IOException ex) {
            Logger.getLogger(GestionConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}

//class HiloGestionConexionClienteEscribir extends Thread {
//
//    DataOutputStream salida;
//    VentanaServidor ventanaServidor;
//    int numConexion;
//
//    HiloGestionConexionClienteEscribir(DataOutputStream salida, VentanaServidor ventana, int numConexion) {
//        this.salida = salida;
//        this.ventanaServidor = ventana;
//        this.numConexion = numConexion;
//    }
//
//    @Override
//    public void run() {
//
//        String msn = "";
//        String anterior = "";
//        Scanner teclado = new Scanner(System.in);
//        do {
//
//            if (this.ventanaServidor.panelServidor.oculto.getText() != null) {
//
//                msn = this.ventanaServidor.panelServidor.oculto.getText();
//
//                try {
//                    if ((msn != null) && (!msn.equals(anterior))) {
//                        new DataOutputStream(Servidor.listaConexiones.get(this.numConexion).getOutputStream()).writeUTF(msn);
//                        anterior = msn;
//                    }
//
//                } catch (IOException ex) {
//                    System.out.println("peta escribir server");
//                } catch (NullPointerException ex) {
//                    System.out.println("peta escrbir server nullpointer");
//                }
//            }
//        } while (!msn.equals("fin"));
//
//    }
//
//}
//
//class HiloGestionConexionClienteLeer extends Thread {
//
//    DataInputStream entrada;
//    VentanaServidor ventanaServidor;
//
//    HiloGestionConexionClienteLeer(DataInputStream entrada, VentanaServidor ventana) {
//        this.entrada = entrada;
//        this.ventanaServidor = ventana;
//    }
//
//    @Override
//    public void run() {
//
//        String mensajeRecibido = "";
//        String anterior = "";
//        do {
//            //System.out.println("Escriba un msn para enviar");            
//            try {
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//
//                if (!mensajeRecibido.equals(anterior)) {
//
//                    mensajeRecibido+="\n";
//                    this.ventanaServidor.panelServidor.chatServidor.append("El cliente dice:" + mensajeRecibido);
//                    anterior = mensajeRecibido;
//                }
//
//            } catch (IOException ex) {
//                System.out.println("Revisa esta excepcion");
//            }
//
//        } while (!mensajeRecibido.equals("fin"));
//
//    }
//}
