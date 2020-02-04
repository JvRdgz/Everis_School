/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author Javier
 */
public class Main {
    public static double ft_mod(double a, double b) {
        return (Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2))));
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        double ax, ay, bx, by, v_A, v_B, mod, u_A, u_B;
        
        System.out.println("\nPunto A:");
        System.out.println("Introduce coordenada X: ");
        ax = sc.nextInt();
        System.out.println("Introduce coordenada Y: ");
        ay = sc.nextInt();
        System.out.println("\nPunto B:");
        System.out.println("Introduce coordenada X: ");
        bx = sc.nextInt();
        System.out.println("Introduce coordenada Y: ");
        by = sc.nextInt();
        v_A = bx - ax;
        v_B = by - ay;
        System.out.println("\nCoordenadas del Vector AB: ");
        System.out.println("(" + v_A + ", " + v_B + ")");
        mod = ft_mod(v_A, v_B);
        System.out.println("\nModulo: " + mod);
        u_A = v_A / mod;
        u_B = v_B / mod;
        System.out.println("\nCoordenadas del Vector Unitario: \n(" + u_A + ", " + u_B + ")");
    }
}
