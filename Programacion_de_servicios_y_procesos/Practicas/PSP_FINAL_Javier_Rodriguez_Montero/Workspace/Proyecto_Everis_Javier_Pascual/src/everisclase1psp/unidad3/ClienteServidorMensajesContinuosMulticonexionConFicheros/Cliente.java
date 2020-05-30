package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexionConFicheros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    static String HOST = "localhost";
    static int PUERTO = 5000;
    private Socket socketCliente;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private int numConexion;
    private File ficheroServidor;
    public final String RUTA = "./FicherosCreados";

    public void initCliente() {
        Scanner teclado = new Scanner(System.in);
        try {

            //Hacemos las operaciones de apertura de la conexion
            operacionesApertura();

            //Lanzamos los hilos para poder leer las contestaciones del Servidor y escribir en el fichero.
            HiloEscribeMensajeCliente escribir = new HiloEscribeMensajeCliente(salida, numConexion, ficheroServidor);
            escribir.start();
            HiloLeeContestacionCliente leer = new HiloLeeContestacionCliente(entrada, numConexion, ficheroServidor);
            leer.start();

            do {
                //Aqui tendriamos que poner condiciones de salida para cuando acabemos la conexion y que se cierre el programa de forma ordenada
                //Condicion de cierre.
            } while (true);

        } catch (Exception e) {
            //Hacemos las operaciones de cierre si salta una excepcion
            operacionesCierre();
        }

        //Si se cumple la condicion de salida para finalizar el programa realizamos las operaciones de cierre
        operacionesCierre();
    }

    public static void main(String[] args) {
        Cliente o = new Cliente();
        o.initCliente();
    }

    public void operacionesCierre() {

        //Rellenar las operaciones de cierre
    }

    public void operacionesApertura() {

        try {
            socketCliente = new Socket(HOST, PUERTO);
            //obtenemos el flujo para leer la entrada
            salida = new DataOutputStream(socketCliente.getOutputStream());
            //obtenemos el flujo para leer la entrada
            entrada = new DataInputStream(socketCliente.getInputStream());
            //aquí vamos a recoger el mensaje que escribamos desde el cliente

            //Recibimos el numero que nos envia el servidor cuando acepta nuestra conexion y lo asignamos a la varible de la clase
            String conexion = entrada.readUTF();
            this.numConexion = Integer.parseInt(conexion);

            System.out.println("Ocupa el siguiente numero en la cola: " + numConexion);
            //Creamos el fichero que va a utilizar el cliente para escribir

            ficheroServidor = new File(RUTA + "/FicheroServidor" + numConexion + ".txt");
            ficheroServidor.createNewFile();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class HiloEscribeMensajeCliente extends Thread {

    DataOutputStream salida;
    int numConexion;
    File ficheroServidor;
    public final String RUTA = "./FicherosCreados";

    HiloEscribeMensajeCliente(DataOutputStream salida, int numConexion, File ficheroServidor) {
        this.salida = salida;
        this.numConexion = numConexion;
        this.ficheroServidor = this.ficheroServidor = ficheroServidor;
    }

    @Override
    public void run() {
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
    }
}

class HiloLeeContestacionCliente extends Thread {

    DataInputStream entrada;
    int numConexion;
    File ficheroServidor;
    public final String RUTA = "./FicherosCreados";

    HiloLeeContestacionCliente(DataInputStream entrada, int numConexion, File ficheroServidor) {
        this.entrada = entrada;
        this.numConexion = numConexion;
        this.ficheroServidor = ficheroServidor;
    }

    @Override
    public void run() {
        String mensajeRecibido = "";
        do {
            //System.out.println("Escriba un msn para enviar");            
            try {
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println("Servidor: " + mensajeRecibido);
            } catch (IOException ex) {
                //  Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }
      } while (!mensajeRecibido.equals("fin"));
    }
}
