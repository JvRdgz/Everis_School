/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad2.HilosSincronizacion;

/**
 *
 * @author Javi
 */
class Customer {

    int cantidad = 10000;

    synchronized void retirada(int cantidad) {
        System.out.println("vamos a retirar...");

        if (this.cantidad < cantidad) {
            System.out.println("No hay saldo, esperando a realizar ingreso...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.cantidad -= cantidad;
        System.out.println("Retirada Completada...");
    }

    synchronized void deposito(int amount) {
        System.out.println("Vamos a ingresar saldo...");
        this.cantidad += amount;
        System.out.println("Deposito completado... ");
        notify();
    }
}

class Test {

    public static void main(String args[]) {
        final Customer c = new Customer();
        
        new Thread() {
            @Override
            public void run() {
                int a = 5;
                c.retirada(15000);
                int c = 4;
            }
        }.start();
        
        new Thread() {            
            @Override
            public void run() {
                int x = 4;
                c.deposito(10000);
                int z = 5;
            }
        }.start();

    }
}
