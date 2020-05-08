package everisclase1psp.unidad2.HilosSincronizacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class Tabla2 {

    void printTable(int n) {
            
        
        
        synchronized (this) {//synchronized block  
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }//end of the method  
}

class MiHilo1 extends Thread {

    Tabla2 t;

    MiHilo1(Tabla2 t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }

}

class MiHilo2 extends Thread {

    Tabla2 t;

    MiHilo2(Tabla2 t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

public class B_EjemploBloqueSincronizado {

    public static void main(String args[]) {
        Tabla2 obj = new Tabla2();//only one object  
        MiHilo1 t1 = new MiHilo1(obj);
        MiHilo2 t2 = new MiHilo2(obj);
        t1.start();
        t2.start();
    }
}
