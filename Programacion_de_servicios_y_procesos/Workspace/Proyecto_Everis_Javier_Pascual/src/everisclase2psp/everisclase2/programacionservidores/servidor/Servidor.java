/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2psp.everisclase2.programacionservidores.servidor;

import everisclase2psp.everisclase2.programacionservidores.EstructuraFicheros;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author Javi
 */
public class Servidor {

    private final int puerto = 1234;
    private EstructuraFicheros estructura;
    private ServerSocket servidor;

    public void conectarServidor() {
        //Seleccionamos la carpeta del servidor que va a estar disponible para compartir
        JFileChooser jfc = new JFileChooser();
        //Solo dejamos escoger directorios para esta operacion
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //Ponemos titulo al cuadro de dialogo
        jfc.setDialogTitle("Selecciona la carpeta donde se encuentran los ficheros");
        //recogemos la opcion leida
        int resp = jfc.showDialog(null, "Seleccionar");
        File f = null;
        //Si es la opcion esperada
        if (resp == JFileChooser.APPROVE_OPTION) {
            //rellenamos nuestra variable file a traves de la seleccion del cuadro de dialogo
            f = jfc.getSelectedFile();
        }

        //Si no hay seleccion
        if(f==null)
        {
            System.out.println("Debe seleccionar una carpeta");
        }
        else
        {
            //Si hemos seleccionado bien lanzamos el servidor
            try{
                servidor = new ServerSocket(this.puerto);
                while(true)
                {
                    //Esperamos la conexion del cliente
                    Socket cliente = servidor.accept();
                    
                    System.out.println("Cliente en linea");
                    //Recogemos la ruta de los ficheros para luego  utilizarla
                    estructura = new EstructuraFicheros(f.getAbsolutePath());
                    //Lanzamos el hilo
                    HiloServidor hiloServidor = new HiloServidor(cliente, estructura);
                    Thread Hilo = new Thread(hiloServidor);
                    Hilo.start();
                }
            }catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        
    }
    
    
    public static void main(String[] args)
    {
        Servidor s = new Servidor();
        s.conectarServidor();
    }

}
