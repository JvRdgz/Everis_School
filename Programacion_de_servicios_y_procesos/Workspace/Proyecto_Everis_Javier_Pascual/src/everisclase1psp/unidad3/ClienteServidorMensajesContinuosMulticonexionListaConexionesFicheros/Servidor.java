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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Servidor {

    static int PUERTO = 5000;
    ServerSocket serverSocket;
    Socket socketCliente;
    DataOutputStream salida;
    String mensajeRecibido;
    static int numConexiones = 0;
    public static List<String> recibidos = Collections.synchronizedList(new ArrayList());
    //  public static List<String> clienteEnvia =  new ArrayList(); 
    public static ArrayList<Socket> listaConexiones = new <Socket> ArrayList();
    public File ficheroCliente;
    public final static String RUTA = "./FicherosCreados";
    public static boolean entrar = false;

    // public static List<Integer> arrayList = Collections.synchronizedList(new ArrayList());
    public void initServidor() {

        Scanner teclado = new Scanner(System.in);
        //Llamamos a esta función para que si no existe la carpeta de los ficheros la cree y si existe que borre su contenido.
        vaciarCarpetaConversaciones();

        try {
            serverSocket = new ServerSocket(PUERTO);
            socketCliente = new Socket();

            System.out.println("Esperando conexión...");

            do {
                //Esperamos a que se produzca la conexion del cliente
                socketCliente = serverSocket.accept();
                System.out.println("Se conecto uno... Esperando a recibir mensaje");

                //añadimos el socketCliente a la lista de Conexiones
                listaConexiones.add(socketCliente);

                //Enviamos al cliente el numero que hace para luego poderlo identificar
                DataOutputStream output = new DataOutputStream(socketCliente.getOutputStream());
                output.writeUTF(Integer.toString(numConexiones));

                //Creamos el fichero correspondiente para poder leer de ahi la conversacion con el cliente
                ficheroCliente = new File(RUTA + "/FicheroCliente" + numConexiones + ".txt");
                ficheroCliente.createNewFile();

                //Lanzamos el hilo que gestiona la conexion de cada cliente
                GestionConexion conexion = new GestionConexion(socketCliente, numConexiones, ficheroCliente);
                conexion.start();
                numConexiones++;

            } while (true);

        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        Servidor o = new Servidor();
        o.initServidor();
    }

    public void vaciarCarpetaConversaciones() {
        File ruta = new File(RUTA);

        if (!(ruta.exists())) {
            ruta.mkdir();
        } else {
            if (!(ruta == null) || (ruta.list().length > 1)) {
                String[] listado = ruta.list();
                for (int i = 0; i < listado.length; i++) {
                    File fichero = new File(RUTA + "/" + listado[i]);
                    fichero.delete();
                }

            }
        }

    }

}
