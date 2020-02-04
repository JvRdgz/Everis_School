package es_datos;

import java.util.Scanner;

public class Main {

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero entero: ");
		int num = sc.nextInt();
		System.out.println(num * 2);
	}
}
