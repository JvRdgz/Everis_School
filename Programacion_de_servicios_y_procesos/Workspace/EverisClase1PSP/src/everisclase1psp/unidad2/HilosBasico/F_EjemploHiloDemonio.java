/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad2.HilosBasico;

public class F_EjemploHiloDemonio extends Thread {

    public void run() {
        if (Thread.currentThread().isDaemon()) {//checking for daemon thread  
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }

    
    
    public static void main(String[] args) {
        F_EjemploHiloDemonio t1 = new F_EjemploHiloDemonio();//creating thread  
        F_EjemploHiloDemonio t2 = new F_EjemploHiloDemonio();
        F_EjemploHiloDemonio t3 = new F_EjemploHiloDemonio();

        t1.setDaemon(true);//now t1 is daemon thread  

        t1.start();//starting threads  
        t2.start();
        t3.start();
    }
}
