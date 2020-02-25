/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sincronizacion;

import Servidor.Servidor;

/**
 *
 * @author Javi
 */
public class OperacionesSincronizadas {

    public static synchronized void reservarAsiento(int numAsientos) {
        int contador = 0;

        do {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 4; j++) {
                    
                    if (Servidor.vagon[i][j].equals("L") && (contador < numAsientos) ) {
                        Servidor.vagon[i][j] = "O";
                        contador++;
                    }
                }
            }

        } while (contador < numAsientos);

        if ((contador) == numAsientos) {
            System.out.println("La reserva se ha realizado correctamente");
        } else {
            System.out.println("No se han podido reservar mas que: " + contador + " asientos");
        }
    }
}
