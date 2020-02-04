package actividad8.parte1;

//package actividad8;
/*
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javie
 */
public class MostrarCinco {
    
    public void parametro(String arg) {
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ".- " + arg);
        }
    }
    
    public static void main(String[]args) {
        
        new MostrarCinco().parametro(args[0]);
        
       /* 
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "actividad8.MostrarCinco", args[0]);
            Process p;
            p = pb.start();
            
            int cod = p.waitFor();
            System.out.println("Ejercicio MostrarCinco finalizado con codigo de error: " + cod);
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(MostrarCinco.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
}
