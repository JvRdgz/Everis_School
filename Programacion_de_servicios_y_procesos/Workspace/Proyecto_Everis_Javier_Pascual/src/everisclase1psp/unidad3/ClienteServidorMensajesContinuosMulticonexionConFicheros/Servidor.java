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
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    static int PUERTO = 5000;
    ServerSocket serverSocket;
    Socket socketCliente;
    DataOutputStream salida;

    static int numConexiones = 0;
    public static ArrayList<Socket> listaConexiones = new <Socket> ArrayList();
    public File ficheroCliente;
    public final static String RUTA = "./FicherosCreados";

    // public static List<Integer> arrayList = Collections.synchronizedList(new ArrayList());
    public void initServidor() {

        try {

            //Creamos los sockets
            serverSocket = new ServerSocket(PUERTO);
            socketCliente = new Socket();

            Scanner teclado = new Scanner(System.in);
            //Llamamos a esta función para que si no existe la carpeta de los ficheros la cree y si existe que borre su contenido.
            vaciarCarpetaConversaciones();
            
            //Creamos y lanzamos el hilo que va a gestionar la conversaciones a traves de la entrada de carpetas
            HiloGestionarConversaciones gestionConversacion = new HiloGestionarConversaciones();
            gestionConversacion.start();

            do {
                //Realizamos las operaciones de apertura de la aplicacion
                operacionesApertura();

                //Utilizamos un bucle para mantener el socket abierto y que mientras alguien quiera conectarse pueda hacerlo
                gestionarConexion();
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

        //Si no existe la carpeta donde creamos los Ficheros la creamos
        if (!(ruta.exists())) {
            ruta.mkdir();
        } else {
            //Si no, si no es nula o su longitud no es una al menos es que no ha escrito ningun cliente.
            if (!(ruta == null) || (ruta.list().length > 1)) {
                String[] listado = ruta.list();
                //Obtenemos el listado de Ficheros de la carpeta y luego los borramos todos.
                for (int i = 0; i < listado.length; i++) {
                    File fichero = new File(RUTA + "/" + listado[i]);
                    fichero.delete();
                }
            }
        }//fin ruta.exists

    }//fin vaciarCarpetaConversaciones

    void operacionesApertura() throws IOException {

        System.out.println("Esperando conexión...");

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
    }

    void gestionarConexion() {
        //Lanzamos el hilo que gestiona la conexion de cada cliente
        GestionConexion conexion = new GestionConexion(socketCliente, numConexiones, ficheroCliente);
        conexion.start();
        numConexiones++;
    }

}
