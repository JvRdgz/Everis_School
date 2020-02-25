/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everispracticapsp.enunciado1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class HiloDemonioContar extends Thread {

    private Thread hilo;
    public static boolean detenerDemonioClientes = false;

    public HiloDemonioContar() {

        hilo = new Thread();
        hilo.setDaemon(true);
    }

    @Override
    public void run() {
        do {
            try {
                System.out.println("El numero de lineas del fichero es: " + OperacionesBD.contarClientes());
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloDemonioContar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HiloDemonioContar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!detenerDemonioClientes);
    }

}
