package com.example.pmddmm_p3_javier_rodriguez_montero;

public class CalculoEnesimoPrimo {

    public static int calculoEnesimo(int num) {
        int[] primos = new int[num];
        primos[0] = 2;
        primos[1] = 3;
        int numPrimosActual = 2, probar = 3;

        while (numPrimosActual < num) {
            probar = probar + 2;
            int cont = 0;

            while (probar % primos[cont] > 0 && cont < numPrimosActual && probar * 10 / primos[cont] > 9) {
                if (cont + 1 == numPrimosActual) {
                    primos[numPrimosActual] = probar;
                    numPrimosActual = (numPrimosActual + 1);
                    System.out.println(primos[numPrimosActual - 1]);
                } else {
                    cont++;
                }
            }
        }
        return primos[num - 1];
    }
}
