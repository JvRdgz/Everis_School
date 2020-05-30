/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everispracticapsp.enunciado1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class HiloBloqueo extends Thread {

    OperacionesSincronizadasBD operaciones;

    public HiloBloqueo(OperacionesSincronizadasBD operaciones) {
        this.operaciones = operaciones;
    }

    @Override
    public void run() {

        if (Thread.currentThread().getName().equals("b")) {
            operaciones.bloqueaRecurso(false);
        } else {
            try {
                operaciones.desbloquearRecurso(true);
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloBloqueo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
