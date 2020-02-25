/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad3.ClienteServidorMensajesContinuosMulticonexionListaConexionesFicheros;

import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class OperacionesSincronizadas {

    boolean finalizadoLeer;

    OperacionesSincronizadas() {

    }

    public synchronized void escribirRecibidosServidor(int numConexion, String mensaje) throws InterruptedException {

//        Servidor.clienteEnvia.add(Integer.toString(numConexion));
//        Servidor.recibidos.add(mensaje);
        //System.out.println("Escriba un msn para enviar");            
        try {
//                DataInputStream entrada = new DataInputStream(Servidor.listaConexiones.get(numConexion).getInputStream());
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta

            FileWriter escribir = new FileWriter(Servidor.RUTA + "/FicheroCliente" + numConexion + ".txt", true);
            escribir.write(mensaje);
            escribir.close();

            //System.out.println(mensajeRecibido);
        } catch (IOException ex) {
            //  Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized void escribirEnviadosServidor(int numConexion, DataOutputStream salida) throws IOException, InterruptedException {

        String msn = "";
        Scanner teclado = new Scanner(System.in);

        do {
            //System.out.println("Escriba un msn para enviar");
            System.out.print("Tu dices para el cliente:" + numConexion);
            msn = teclado.nextLine();
            try {
                salida.writeUTF("ServidorC" + numConexion + " dice: \n" + msn);//enviamos mensaje

            } catch (IOException ex) {
                // Logger.getLogger(hiloEscribe2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!msn.equals("fin"));

    }

    // eliminarMensajes(contador); Recuerda que hay que contar lineas mostradas para poder quitarlas del fichero o contar desde esa linea


public static void eliminarMensajes(int posicion) {

    }

}
