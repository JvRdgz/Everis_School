package Hilos.servidor;

import Sincronizacion.OperacionesSincronizadas;
import Ventanas.VentanaServidor;
import java.io.DataInputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javi
 */
public class HiloGestionConexionClienteLeer extends Thread {

    DataInputStream entrada;
    VentanaServidor ventanaServidor;

    public HiloGestionConexionClienteLeer(DataInputStream entrada, VentanaServidor ventana) {
        this.entrada = entrada;
        this.ventanaServidor = ventana;
    }

    @Override
    public void run() {

        String mensajeRecibido = "";
        String anterior = "";
        do {
            //System.out.println("Escriba un msn para enviar");            
            try {
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                
                if(mensajeRecibido.equals("1"))
                {
                    OperacionesSincronizadas.reservarAsiento(9);
                    
                    //Enviar Mail desde aquí
                }
                
                 if(mensajeRecibido.equals("2"))
                {
                    System.out.println("Opcion 2");
                }

                if (!mensajeRecibido.equals(anterior)) {
                    //mensajeRecibido+="\n";
                    this.ventanaServidor.panelServidor.chatServidor.append("El cliente dice:" + mensajeRecibido+"\n");
                    anterior = mensajeRecibido;
                }

            } catch (IOException ex) {
                System.out.println("Revisa esta excepcion");
            }

        } while (!mensajeRecibido.equals("fin"));

    } 
    
}
