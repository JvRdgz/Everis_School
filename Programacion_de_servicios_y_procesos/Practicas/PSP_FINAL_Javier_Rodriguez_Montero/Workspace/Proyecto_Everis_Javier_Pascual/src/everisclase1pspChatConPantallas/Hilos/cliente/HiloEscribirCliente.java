package everisclase1pspChatConPantallas.Hilos.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

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
public class HiloEscribirCliente extends Thread {

    DataOutputStream salida;
    VentanaCliente ventanaCliente;

    public HiloEscribirCliente(DataOutputStream salida, VentanaCliente ventana) {
        this.salida = salida;
        this.ventanaCliente = ventana;
    }

    @Override
    public void run() {

        String msn = "";
        String anterior = "";
        Scanner teclado = new Scanner(System.in);
        do {

            //Si el campo oculto del formulario contiene texto entramos
            if (this.ventanaCliente.panelCliente.oculto.getText() != null) {

                //Recogemos el mensaje que hay en la caja
                msn = this.ventanaCliente.panelCliente.oculto.getText();
                try {
                    //Si no es nulo o no es el mismo mensaje que el anerior
                    if ((msn != null) && (!msn.equals(anterior))) {
                        //mandamos el mensaje de la caja por el flujo de salida
                        salida.writeUTF(msn);
                        salida.flush();
                        //almacenamos el mensaje anterior para que no sea el mismo
                        anterior = msn;
                    }

                } catch (IOException ex) {
                    System.out.println("peta escribir server");
                } catch (NullPointerException ex) {
                    System.out.println("peta escrbir server nullpointer");
                }
            }
        } while (true);

    }

}
