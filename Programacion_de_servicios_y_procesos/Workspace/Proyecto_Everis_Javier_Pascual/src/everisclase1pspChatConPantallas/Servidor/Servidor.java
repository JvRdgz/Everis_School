package everisclase1pspChatConPantallas.Servidor;

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

public class Servidor {

    static int PUERTO = 5000;
    ServerSocket serverSocket;
    Socket socketCliente;
    DataOutputStream salida;

    static int numConexiones = 0;
    public static ArrayList<Socket> listaConexiones = new <Socket> ArrayList();
    public static String[][] vagon;

    // public static List<Integer> arrayList = Collections.synchronizedList(new ArrayList());
    public void initServidor() {

        inicializarVagon();
        
        try {

            //Creamos los sockets
            serverSocket = new ServerSocket(PUERTO);
            socketCliente = new Socket();

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

    void operacionesApertura() throws IOException {

        System.out.println("Esperando conexión...");

        //Esperamos a que se produzca la conexion del cliente
        socketCliente = serverSocket.accept();
//        System.out.println("Se conecto uno... Esperando a recibir mensaje");

        //añadimos el socketCliente a la lista de Conexiones
        listaConexiones.add(socketCliente);

        //Enviamos al cliente el numero que hace para luego poderlo identificar
        DataOutputStream output = new DataOutputStream(socketCliente.getOutputStream());
        output.writeUTF(Integer.toString(numConexiones));
        output.flush();

    }

    void gestionarConexion() {
        //Lanzamos el hilo que gestiona la conexion de cada cliente
        GestionConexion conexion = new GestionConexion(socketCliente, numConexiones);
        conexion.start();
        numConexiones++;
    }
    
    void inicializarVagon()
    {
        vagon = new String[9][4];
        
        for(int i = 0; i<9;i++)
        {
            for(int j = 0; j<4;j++)
            {
                this.vagon[i][j] = "L";
            }
        }
    }

}
