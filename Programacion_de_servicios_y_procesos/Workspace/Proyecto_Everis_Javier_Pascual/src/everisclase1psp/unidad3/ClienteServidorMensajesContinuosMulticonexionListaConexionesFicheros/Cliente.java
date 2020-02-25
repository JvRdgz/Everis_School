/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexionListaConexionesFicheros;

/**
 *
 * @author Javi
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

    static String HOST = "localhost";
    static int PUERTO = 5000;
    Socket socketCliente;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
    private int numConexion;
    File ficheroServidor;
    public final String RUTA = "./FicherosCreados";

    public void initCliente() {
        Scanner teclado = new Scanner(System.in);
        try {
            socketCliente = new Socket(HOST, PUERTO);
//            obtenemos el flujo para leer la entrada
            salida = new DataOutputStream(socketCliente.getOutputStream());
            //obtenemos el flujo para leer la entrada
            entrada = new DataInputStream(socketCliente.getInputStream());
            //aquí vamos a recoger el mensaje que escribamos desde el cliente

            String conexion = entrada.readUTF();
            this.numConexion = Integer.parseInt(conexion);

            System.out.println("Numero Cliente" + numConexion);
            ficheroServidor = new File(RUTA + "/FicheroServidor" + numConexion + ".txt");
            ficheroServidor.createNewFile();

            //mientras no enviemos una x seguimos pidiendo mensajes
            String msn = "";
            //mientras no enviemos una x seguimos pidiendo mensajes

            hiloEscribeMensajeCliente escribir = new hiloEscribeMensajeCliente(salida, numConexion, ficheroServidor);
            escribir.start();
            HiloLeeContestacionCliente leer = new HiloLeeContestacionCliente(entrada, numConexion, ficheroServidor);
            leer.start();
            do {

                //Meter aquí el hilo que nos permita leer el fichero todo el rato y mostrar los mensajes por pantalla cuando haya.
            } while (true);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Cliente o = new Cliente();
        o.initCliente();
    }

}

class hiloEscribeMensajeCliente extends Thread {

    DataOutputStream salida;
    int numConexion;
    File ficheroServidor;
    public final String RUTA = "./FicherosCreados";
    

    hiloEscribeMensajeCliente(DataOutputStream salida, int numConexion, File ficheroServidor) {
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
                FileWriter escribir = new FileWriter(this.ficheroServidor, true);
                escribir.write(mensajeRecibido);
                escribir.close();
              
                //System.out.println(mensajeRecibido);
            } catch (IOException ex) {
                //  Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!mensajeRecibido.equals("fin"));
    }
}
