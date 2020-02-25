/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everispracticapsp.enunciado1;



/**
 *
 * @author Javi
 */
public class OperacionesSincronizadasBD {

    private int amount = 10000;
    private boolean flag = false;

    synchronized void desbloquearRecurso(boolean flag) {

        /*
        System.out.println("Desbloqueo completado ");
        notify();*/
        
        System.out.println("Vamos a desbloquear");
        flag = true;
        System.out.println("Desbloqueo completo ");
        notify();

    }

    //habra que pasar siempre false para bloquear el recurso, lo llama el demonio
    synchronized void bloqueaRecurso(boolean flag) {

        System.out.println("Comprobando para bloqueo");

        if (!flag) {
            System.out.println("Bloqueando...");
            try {
                wait();
                OperacionesBD.insertar1();
            } catch (Exception e) {
                System.out.println("esta cascando");
            }

        }
        flag = false;
        System.out.println("insercion completada");

    }
}
