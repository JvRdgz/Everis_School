package everisclase1pspChatConPantallas.Hilos.cliente;

import java.io.DataInputStream;
import java.io.IOException;

import everisclase1pspChatConPantallas.Ventanas.VentanaCliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javi
 */
public class HiloLeerCliente extends Thread {

    DataInputStream entrada;
    VentanaCliente ventanaCliente;

  public  HiloLeerCliente(DataInputStream entrada, VentanaCliente ventana) {
        this.entrada = entrada;
        this.ventanaCliente = ventana;
    }

    @Override
    public void run() {

        String mensajeRecibido = "";
        String anterior = "";
        do {

            try {
                //Si hay algun mensaje en el flujo de entrada lo recoge
                mensajeRecibido = entrada.readUTF();//Leemos respuesta

                //Si no es igual que el mensaje anterior lo pintamos por pantalla. Esto es asi para el ejemplo, pero no sería así en realidad
                if (!mensajeRecibido.equals(anterior)) {
                    this.ventanaCliente.panelCliente.chatCliente.append("El servicio tecnico dice:" + mensajeRecibido+"\n");
                    anterior = mensajeRecibido;
                }

            } catch (IOException ex) {
                System.out.println("Revisar esta excepcion");
            }

        } while (!mensajeRecibido.equals("fin"));
    }

}


