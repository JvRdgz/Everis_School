package Cliente;


/**
 *
 * @author Javi
 */

import Ventanas.VentanaCliente;
import Hilos.cliente.HiloEscribirCliente;
import Hilos.cliente.HiloLeerCliente;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

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

            VentanaCliente frmCliente = new VentanaCliente();
            frmCliente.setName("Cliente");
            frmCliente.setVisible(true);
            frmCliente.setTitle("Cliente" + entrada.readUTF());
            frmCliente.panelCliente.setName("Cliente");
            frmCliente.panelCliente.oculto.setVisible(false);
            frmCliente.panelCliente.chatCliente.setText("Conectado, envie o espere a recibir mensajes\n\n");

            HiloLeerCliente leer = new HiloLeerCliente(entrada, frmCliente);
            HiloEscribirCliente escribir = new HiloEscribirCliente(salida, frmCliente);
            escribir.start();
            leer.start();

            do {

            } while (true);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Cliente o = new Cliente();
        o.initCliente();
    }

}

//class HiloEscribirCliente extends Thread {
//
//    DataOutputStream salida;
//    VentanaCliente ventanaCliente;
//
//    HiloEscribirCliente(DataOutputStream salida, VentanaCliente ventana) {
//        this.salida = salida;
//        this.ventanaCliente = ventana;
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
//            //Si el campo oculto del formulario contiene texto entramos
//            if (this.ventanaCliente.panelCliente.oculto.getText() != null) {
//
//                //Recogemos el mensaje que hay en la caja
//                msn = this.ventanaCliente.panelCliente.oculto.getText();
//                try {
//                    //Si no es nulo o no es el mismo mensaje que el anerior
//                    if ((msn != null) && (!msn.equals(anterior))) {
//                        //mandamos el mensaje de la caja por el flujo de salida
//                        salida.writeUTF(msn);
//                        //almacenamos el mensaje anterior para que no sea el mismo
//                        anterior = msn;
//                    }
//
//                } catch (IOException ex) {
//                    System.out.println("peta escribir server");
//                } catch (NullPointerException ex) {
//                    System.out.println("peta escrbir server nullpointer");
//                }
//            }
//        } while (true);
//
//    }
//
//}
//
//class HiloLeerCliente extends Thread {
//
//    DataInputStream entrada;
//    VentanaCliente ventanaCliente;
//
//    HiloLeerCliente(DataInputStream entrada, VentanaCliente ventana) {
//        this.entrada = entrada;
//        this.ventanaCliente = ventana;
//    }
//
//    @Override
//    public void run() {
//
//        String mensajeRecibido = "";
//        String anterior = "";
//        do {
//
//            try {
//                //Si hay algun mensaje en el flujo de entrada lo recoge
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//
//                //Si no es igual que el mensaje anterior lo pintamos por pantalla. Esto es asi para el ejemplo, pero no sería así en realidad
//                if (!mensajeRecibido.equals(anterior)) {
//                    this.ventanaCliente.panelCliente.chatCliente.append("El servicio tecnico dice:" + mensajeRecibido + "\n");
//                    anterior = mensajeRecibido;
//                }
//
//            } catch (IOException ex) {
//                System.out.println("Revisar esta excepcion");
//            }
//
//        } while (!mensajeRecibido.equals("fin"));
//    }
//
//}
