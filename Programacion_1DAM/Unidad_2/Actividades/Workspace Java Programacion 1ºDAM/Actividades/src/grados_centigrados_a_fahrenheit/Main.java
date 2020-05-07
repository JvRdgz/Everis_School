package grados_centigrados_a_fahrenheit;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		float num;
		System.out.println("Introduce Grados Centrigrados: ");
		num = sc.nextFloat();
		System.out.println((((num * 9) / 5) + 32));
	}
}
