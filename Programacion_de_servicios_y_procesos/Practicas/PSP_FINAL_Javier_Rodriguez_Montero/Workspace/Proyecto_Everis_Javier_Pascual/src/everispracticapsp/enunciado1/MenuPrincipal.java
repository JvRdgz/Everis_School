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
public class MenuPrincipal {

    private int opcion;
    public static boolean detenerDemonioActualizacion = false;
    OperacionesSincronizadasBD operacionesBD;

    public MenuPrincipal() {
        this.opcion = -1;

        operacionesBD = new OperacionesSincronizadasBD();
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public void controlarMenu(EntradaDatos entrada) {

        OperacionesBD operaciones = new OperacionesBD();

        switch (entrada.getDatoEntero()) {
            case 1:
                //operaciones.realizarVenta(listaProductos);
                HiloCargarDatos hilo = new HiloCargarDatos();
                HiloCargarDatos hilo2 = new HiloCargarDatos();
                HiloCargarDatos hilo3 = new HiloCargarDatos();

                hilo.setPriority(Thread.MAX_PRIORITY);
                hilo.setName("MaximaPrioridad");
                hilo2.setPriority(Thread.NORM_PRIORITY);
                hilo2.setName("PrioridadNormal");
                hilo3.setPriority(Thread.MIN_PRIORITY);
                hilo3.setName("MinimaPrioridad");

                hilo.start();
                hilo2.start();
                hilo3.start();
                break;
            case 2:

                HiloDemonioContar hiloDemonio = new HiloDemonioContar();
                hiloDemonio.start();
                break;
            case 3:

                HiloDemonioActualizacion hiloDemonio2 = new HiloDemonioActualizacion();
                hiloDemonio2.start();

                break;
            case 4:
                HiloBloqueo hiloBloq = new HiloBloqueo(operacionesBD);
                hiloBloq.setName("b");
                hiloBloq.start();

                break;
            case 5:
                HiloBloqueo hiloBloq2 = new HiloBloqueo(operacionesBD);
                hiloBloq2.setName("d");
                hiloBloq2.start();
                // operaciones.imprimirFactura();
                break;
            default:
                System.out.println("No has introducido la opcion correcta");
        }
    }
    //Este es el menu real del curso de java

//    public void mostrarOpciones() {
//        System.out.println("Introduzca cualquiera de las opciones del menu.\n");
//        System.out.println("1.- Rellenar Tablas");
//        System.out.println("2.- Hilo Demonio Contar Clientes");
//        System.out.println("3.- Hilo Demonio 2");
//        System.out.println("4.- Bloquear insercion tabla");
//        System.out.println("4.- DesBloquear insercion tabla");
//        System.out.println("0.- Salir");
//    }
//    
    public void mostrarOpciones() {
        System.out.println("Introduzca cualquiera de las opciones del menu.\n");
        System.out.println("1.- Crear Ficheros");
        System.out.println("2.- Hilo Demonio Contar Lineas");
        System.out.println("3.- Hilo DControl Inserciones");
        System.out.println("4.- Bloquear metodo escritura");
        System.out.println("5.- DesBloquear metodo escritura");
        System.out.println("0.- Salir");
    }

}
