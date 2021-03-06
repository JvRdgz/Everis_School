package calculo_de_areas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float base = 0.0f, altura = 0.0f, radio = 0.0f;
		char op;

		do {
			System.out.println("\n\tMENU PRINCIPAL\n");
			System.out.println("Selecciona una opcion:\n");
			System.out.println("a) Area de un rectangulo:");
			System.out.println("b) Area de un triangulo:");
			System.out.println("c) Area de un circulo:");
			System.out.println("d) Salir:\n");

			op = sc.next().charAt(0);

			switch (op) {
			case 'a':
				System.out.println("Introduce base:");
				base = sc.nextFloat();
				sc = new Scanner(System.in);
				System.out.println("Introduce altura:");
				altura = sc.nextFloat();
				sc = new Scanner(System.in);
				System.out.println("Area del rectangulo: " + base * altura);
				break;
			case 'b':
				System.out.println("Introduce base:");
				base = sc.nextFloat();
				sc = new Scanner(System.in);
				System.out.println("Introduce altura:");
				altura = sc.nextFloat();
				sc = new Scanner(System.in);
				System.out.println("Area del triangulo: " + (base * altura) / 2);
				break;
			case 'c':
				System.out.println("Introduce radio:");
				radio = sc.nextFloat();
				sc = new Scanner(System.in);
				System.out.println("Area del circulo: " + Math.PI * Math.pow(radio, 2));
			case 'd':
				break;
			}
		} while (op != 'd');
	}

}
