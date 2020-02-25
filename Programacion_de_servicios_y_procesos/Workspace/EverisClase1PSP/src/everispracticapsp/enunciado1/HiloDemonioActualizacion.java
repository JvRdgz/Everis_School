/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everispracticapsp.enunciado1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class HiloDemonioActualizacion extends Thread {

    public static Thread hilo;
    private int contador;
    public static Connection conexion;
    public static Statement st;
    public static boolean detenerDemonioActualizacion = false;

    public HiloDemonioActualizacion() {

        hilo = new Thread();
        hilo.setDaemon(true);
        hilo.setName("DemonioActualizacion");
        try {
            contador = OperacionesBD.contarClientes();
        } catch (SQLException ex) {
            Logger.getLogger(HiloDemonioActualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (!detenerDemonioActualizacion) {
            try {

                if (OperacionesBD.contarClientes() > contador) {
                    this.contador = OperacionesBD.contarClientes();
                    System.out.println("Ha habido una actualizacion en el fichero y el numero actual de lineas ahora es: " + this.contador);
                }
                //vamos a comentar la insercion para que se haga desde el metodo del bloqueo y desbloqueo
                //OperacionesBD.insertar1();
                Thread.sleep(5000);

            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(HiloDemonioContar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
