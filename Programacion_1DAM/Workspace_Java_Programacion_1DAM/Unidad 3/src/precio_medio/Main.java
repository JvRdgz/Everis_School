package precio_medio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float []precio = new float[4];
		double media = 0.0;
		for (int i = 0; i < precio.length; i++) {
			System.out.println("Introduce el precio del establecimiento " + (i + 1));
			precio[i] = Float.parseFloat(sc.nextLine());
			media += precio[i];
		}
		
		System.out.println("Media del producto de los cuatro establecimientos: " + media / precio.length);
	}

}
