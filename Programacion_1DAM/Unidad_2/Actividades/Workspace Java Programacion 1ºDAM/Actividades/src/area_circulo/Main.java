package area_circulo;

import java.util.Scanner;

public class Main {

	static double pi = 3.1415;

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduce radio: ");
		double radio = sc.nextDouble();

		double result = pi*radio*radio;
		System.out.println("\nEl area del circulo es: " + result);
	}
}
