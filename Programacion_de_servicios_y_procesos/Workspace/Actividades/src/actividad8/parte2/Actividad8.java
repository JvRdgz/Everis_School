/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad8.parte2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class Actividad8 {
    public void crearProcesoProgramaAnterior(String args, String ficheroResultado) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "actividad8.parte1.MostrarCinco", args);
            pb.directory(new File("./build/classes/"));
            pb.redirectOutput(new File(ficheroResultado));
            System.out.println(pb.redirectError());
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(Actividad8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Actividad8 a = new Actividad8();
        a.crearProcesoProgramaAnterior("Hola", "resultadosMostrarCincoParte2.txt");
    }
}
