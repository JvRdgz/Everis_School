package everisclase1pspChatConPantallas.Hilos.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

import everisclase1pspChatConPantallas.Ventanas.VentanaServidor;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javi
 */
public class HiloGestionConexionClienteEscribir extends Thread {

    DataOutputStream salida;
    VentanaServidor ventanaServidor;
    int numConexion;

    public HiloGestionConexionClienteEscribir(DataOutputStream salida, VentanaServidor ventana, int numConexion) {
        this.salida = salida;
        this.ventanaServidor = ventana;
        this.numConexion = numConexion;

    }

    @Override
    public void run() {

        String msn = "";
        String anterior = "";
        Scanner teclado = new Scanner(System.in);

        try {
            this.salida.writeUTF(enviarMenu());

            do {

                if (this.ventanaServidor.panelServidor.oculto.getText() != null) {

                    msn = this.ventanaServidor.panelServidor.oculto.getText();

                    if ((msn != null) && (!msn.equals(anterior))) {
                        this.salida.writeUTF(msn);
                        this.salida.flush();
                        anterior = msn;
                    }
                }
            } while (!msn.equals("fin"));
        } catch (IOException ex) {
            System.out.println("peta escribir server");
        } catch (NullPointerException ex) {
            System.out.println("peta escrbir server nullpointer");
        }

    }

    public String enviarMenu() {

        String menu = "El menu esta sin programar, habria que trabajar a partir de aquí\n";
        menu += "1.- Reserva Billete\n";
        menu += "2.- Abrir chat con el servicio técnico\n";
        menu += "3.- Salir";

        return menu;

    }
//
//    public void controlMenu() throws IOException {
//        int opcion = -1;
//        String opcionCadena = "";
//        //Enviamos el menú
//        new DataOutputStream(this.socketCliente.getOutputStream()).writeUTF(enviarMenu());
//        do {
//
//            opcionCadena = new DataInputStream(this.socketCliente.getInputStream()).readUTF();
//            if (!opcionCadena.equals("")) {
//                switch (opcionCadena) {
//
//                    case "1"://Reservar Billete
//                        break;
//                    case "2":
//                        break;//Lanzar Chat
//                    case "3": //Recibir billete de venta por mail.
//
//                    default:
//                        System.out.println("La opcion introducida no es la correcta, introduzca una de las opciones del menu");
//                        new DataOutputStream(this.socketCliente.getOutputStream()).writeUTF(enviarMenu());
//
//                }
//            }
//
//        } while ((opcion != 1) || (opcion != 2));
//    }

}
