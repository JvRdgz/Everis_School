package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexionConFicheros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        HiloLeeContestacionServidor leer = new HiloLeeContestacionServidor(entrada, this.numConexion, this.ficheroCliente);
        leer.start();
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

        String msn = "";
        Scanner teclado = new Scanner(System.in);
        do {

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
            } catch (IOException ex) {

            }
        } while (!mensajeRecibido.equals("fin"));

    }
}

//Esta clase lo que hace es estar leyendo constantemente la carpeta de FicherosCreados para ver que conversaciones mantenemos con los clientes
class HiloGestionarConversaciones extends Thread {

    public final static String RUTA = "./FicherosCreados";
    DataOutputStream salida;

    File FicheroCliente;

    HiloGestionarConversaciones() {

    }

    public void procesarConversaciones() throws FileNotFoundException, IOException {

        //Hacemos las operaciones necesarias de comprobacion de existencia de rutas y tamaño de listas
        File ruta = new File(RUTA);

        if ((ruta.exists())) {
            if (ruta.list().length > 0) {
                Scanner teclado = new Scanner(System.in);
                //Mostramos conversaciones pendientes
                String listado[] = mostrarConversaciones(ruta);

                int cliente = seleccionConversacionCliente();

                mostrarConversacionCliente(listado, cliente);

                if (contestarConversacion()) {
                    enviarMensaje(cliente);
                }
            } else {
                System.out.println("No hay ficheros");
            }
        } else {
            System.out.println("No existe la ruta");
        }

    } // Fin procesarConversación

    public String[] mostrarConversaciones(File ruta) {

        //Si hay algo en la lista es que tenemos conversaciones que procesar
        String[] listado = ruta.list();
        System.out.println("Hemos encontrado conversaciones de Clientes para procesar");

        //Mostramos las conversaciones para procesar
        for (int i = 0; i < listado.length; i++) {
            if (listado[i].contains("Cliente")) {
                System.out.println(listado[i]);
            }
        }

        return listado;
    }

    public int seleccionConversacionCliente() {
        //Preguntamos al servidor que conversacion quiere leer
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la conversación a procesar");
        int cliente = teclado.nextInt();
        return cliente;
    }

    public void mostrarConversacionCliente(String[] listado, int cliente) throws FileNotFoundException, IOException {
        //Establecemos un lector para procesar el fichero de conversacion elegido
        FileReader lector = null;

        //Procesamos el fichero hasta encontrar el que nos ha dicho el servidor
        for (int i = 0; i < listado.length; i++) {
            if (listado[i].contains("Cliente")) {
                if (listado[i].contains(Integer.toString(cliente))) {
                    lector = new FileReader(RUTA + "/" + listado[i]);
                }
            }
        }
        //Estamos ignorando los errores y esto solo funcionara en el caso que estemos introduciendo los datos correcto en cada pregunta
        BufferedReader lectorBuffer = new BufferedReader(lector);

        //Leemos la primera linea del fichero para empezar a procesar
        String linea = lectorBuffer.readLine();

        //Procesamos el fichero y lo imprimimos por pantalla
        while (linea != null) {
            System.out.println(linea);
            linea = lectorBuffer.readLine();
        }

    }

    public boolean contestarConversacion() {
        Scanner teclado = new Scanner(System.in);
        //teclado.nextLine();
        String opcion = "";

        //Le preguntamos al servidor si quiere contestar 
        do {
            System.out.println("Contestar Conversacion");
            teclado.nextLine();
        } while (opcion.equals("s"));

        return true;
    }

    public void enviarMensaje(int cliente) throws IOException {
        //Mostramos el OutputStream que vamos a enseñar al cliente
        System.out.println(Servidor.listaConexiones.get(cliente).getOutputStream());
        //Recuperamos el OutputStream del cliente que escribe el fichero
        this.salida = new DataOutputStream(Servidor.listaConexiones.get(cliente).getOutputStream());
        // de forma automatica, enviamos una linea al cliente correspondiente
        this.salida.writeUTF("Contestacion al cliente " + cliente);
    }

    @Override
    public void run() {

        //Solo lo utilizamos para llamar al metodo procesarConversacinoes.
        try {
            do {
                procesarConversaciones();
            } while (true); //Poner una condicion para las condicionies de salida

        } catch (IOException ex) {
            Logger.getLogger(HiloGestionarConversaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
