package fecha;

import java.util.Scanner;

public class Main {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int dia = 0;
		int mes = 0;
		int anio = 0;

		System.out.print("\nIntroduce dia: ");
		dia = sc.nextInt();
		sc = new Scanner(System.in);
		System.out.print("\nIntroduce mes: ");
		mes = sc.nextInt();
		sc = new Scanner(System.in);
		System.out.print("\nIntroduce anio: ");
		anio = sc.nextInt();
		System.out.println();

		if (dia < 10 && mes < 10) {

			System.out.println("0" + dia + "0" + mes + "" + anio);
			System.out.println(anio + "0" + mes + "0" + dia);
			System.out.println("0" + dia + "-0" + mes + "-" + anio);

		} else if (dia < 10) {

			System.out.println("0" + dia + "" +  mes + "" +  anio);
			System.out.println(anio + "" + mes + "0" + dia);
			System.out.println("0" + dia + "-" + mes + "-" + anio);

		} else if (mes < 10){

			System.out.println(dia + "0" + mes + "" + anio);
			System.out.println(anio + "0" + mes + "" + dia);
			System.out.println(dia + "-0" + mes + "-" + anio);

		} else {
			
			System.out.println(dia + "" + mes + "" + anio);
			System.out.println(anio + "" + mes + "" + dia);
			System.out.println(dia + "-" + mes + "-" + anio);
		}

		System.out.println(dia + "/" + mes + "/" + anio);
		System.out.println(dia + " del " + mes + " de " + anio);
		
	}
}
