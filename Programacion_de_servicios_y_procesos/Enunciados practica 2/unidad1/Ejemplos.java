/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Ejemplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //abrirEjecutableRuta();
        EjecutarConsolaSinSalida();
        EjecutarConsolaConSalida();
        EjecutarClase();

//        Lanzador l = new Lanzador();
//        l.crearProceso(4, 15, "FicheroResultado.txt");
//        l.crearProceso(2, 7, "FicheroResultado.txt");
    }

    public static void abrirEjecutableRuta() {
        try {
            ProcessBuilder proceso = new ProcessBuilder("C:\\Program Files (x86)\\Notepad++\\Notepad++.exe");

            proceso.start();
        } catch (IOException ex) {
            Logger.getLogger(Ejemplos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void EjecutarConsolaSinSalida() {
        try {

            //No saca nada por que sale por la consola standar
            ProcessBuilder proceso = new ProcessBuilder("cmd", "/c", "netstat");

            proceso.start();
        } catch (IOException ex) {
            Logger.getLogger(Ejemplos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void EjecutarConsolaConSalida() {
        try {

            //No saca nada por que sale por la consola standar
            ProcessBuilder builder = new ProcessBuilder();
            //cambiando el comando netstat podriamos utilizarlo para ejecutar varios comandos
            builder.command("cmd", "/c", "netstat");
            Process proceso = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //obtenemos el código del proceso
            int codigo = proceso.waitFor();

            System.out.println("El codigo producido ha sido " + codigo);

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Ejemplos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void EjecutarClase() {
        try {

            //No saca nada por que sale por la consola standar
            ProcessBuilder builder = new ProcessBuilder();
            //cambiando el comando netstat podriamos utilizarlo para ejecutar varios comandos
            builder.command("java", "everisclase1psp.unidad1.Clase");
            builder.directory(new File("./build/classes/"));
            Process proceso = builder.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //obtenemos el código del proceso
            int codigo = proceso.waitFor();

            System.out.println("El codigo producido ha sido " + codigo);

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Ejemplos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class Lanzador {

    public void crearProceso(Integer n1, Integer n2, String FichResultado) {

        try {
            //No saca nada por que sale por la consola standar
            ProcessBuilder builder = new ProcessBuilder();
            //cambiando el comando netstat podriamos utilizarlo para ejecutar varios comandos
            builder.command("java", "everisclase1psp.unidad1.Proceso", n1.toString(), n2.toString());
            builder.redirectError(new File("FicheroErrores.txt"));
            builder.redirectOutput(new File("FicheroSalida.txt"));
            builder.directory(new File("./build/classes/"));
            Process proceso = builder.start();
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
