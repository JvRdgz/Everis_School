package com.example.pmddmm_p3_javier_rodriguez_montero;

public class Conversor {

    public static String decimal_a_binario(String numero) {
        String binario = "";
        int num = Integer.parseInt(numero);

        if (num > 0) {
            while (num > 0) {
                if (num % 2 == 0)
                    binario = "0" + binario;
                else
                    binario = "1" + binario;
                num /= 2;
            }
        } else if (num == 0)
            binario = "0";
        return binario;
        //return Integer.toBinaryString(num);
    }

    public static String decimal_a_hexadecimal(String numero) {
        char digitHex[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int num = Integer.parseInt(numero);
        String hex = "";
        int resto, aux = num;
        while (aux > 0) {
            resto = aux % 16;
            hex += digitHex[resto];
            aux /= 16;
        }
        return hex;
        //return Integer.toHexString(num);
    }

    public static String hexadecimal_a_decimal(String numero) {
        int numhex = Integer.parseInt(numero, 16);
        String num = String.valueOf(numhex);
        return num;
    }

    public static String binario_a_decimal(String numero) {
        long num = Long.parseLong(numero), digito, decimal = 0;
        int exp = 0;

        while (num != 0) {
            digito = num % 10;
            decimal = decimal + digito * (int)Math.pow(2, exp);
            exp++;
            num /= 10;
        }
        String numDec = String.valueOf(num);
        return numDec;
    }

    public static String hexadecimal_a_binario(String numero) {
        String decimal = hexadecimal_a_decimal(numero);
        String bin = decimal_a_binario(decimal);
        // int numhex = Integer.parseInt(numero, 16);
        //String bin = Integer.toBinaryString(numhex);
        return bin;
    }

    public static String bianario_a_hexadecimal(String numero) {
        String decimal = binario_a_decimal(numero);
        String hex = decimal_a_hexadecimal(decimal);
        return hex;
    }

}
