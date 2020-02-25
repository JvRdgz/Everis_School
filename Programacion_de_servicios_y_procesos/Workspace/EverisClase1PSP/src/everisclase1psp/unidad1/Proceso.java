/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase1psp.unidad1;

import java.util.Arrays;

/**
 *
 * @author Javi
 */
public class Proceso {

    public  void llenarArray(Integer a, Integer b) {

        int[] array = new int[b - a + 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
    }
    
    public static void main(String... args)
    {
         new Proceso().llenarArray(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

}
