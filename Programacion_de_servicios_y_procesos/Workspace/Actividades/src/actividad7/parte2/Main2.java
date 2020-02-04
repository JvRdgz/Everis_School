/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad7.parte2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Main2 {
    
    public void crearProcesoProgramaAnterior(String argumento) {
        
        ProcessBuilder pb = new ProcessBuilder("java", "actividad7.parte1."
                + "MostrarMayusculas", argumento);
        // pb.directory(new File("./build/classes"));
        pb.redirectError(new File("errores.txt"));
        try {
            Process p = pb.start();
            int cod = p.waitFor();

            System.out.println("\n\tFinalizado con codigo de error: " + cod);
            
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String []args) {
        Main2 m = new Main2();
        m.crearProcesoProgramaAnterior("hola como estas");
    }
}
