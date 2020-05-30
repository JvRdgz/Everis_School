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
public class HiloCargarDatos extends Thread {

    Thread t;

    public HiloCargarDatos() {

        t = new Thread();

    }

    @Override
    public void run() {

        boolean flagMaximaPrioridad = false;
        boolean flagPrioridadNormal = false;

        try {
            if (Thread.currentThread().getName().equals("MaximaPrioridad")) {
                OperacionesBD.crearTabla1();
                //System.out.println("Carga de tabla1 desde el hilo " + Thread.currentThread().getName());
                System.out.println("Creacion del fichero desde el hilo " + Thread.currentThread().getName());
            }

            if (Thread.currentThread().getName().equals("PrioridadNormal")) {
                Thread.sleep(5000);
                OperacionesBD.crearTabla2();
               // System.out.println("Carga de tabla2 desde el hilo " + Thread.currentThread().getName());
                 System.out.println("Creacion del fichero2 desde el hilo " + Thread.currentThread().getName());
            }

            if (Thread.currentThread().getName().equals("MinimaPrioridad")) {
                Thread.sleep(10000);
                OperacionesBD.crearTabla3();
                //System.out.println("Carga de tabla3 desde el hilo " + Thread.currentThread().getName());
                 System.out.println("Creacion del fichero3 desde el hilo " + Thread.currentThread().getName());
            }
            //System.out.println("El hilo: " + Thread.currentThread().getName() + "ha realizado su tarea");
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(HiloCargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
