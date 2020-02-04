package pruebas;

import java.util.Arrays;

public class Proceso {

	/*
	 * ESTE PROGRAMA DEBE EJECUTARSE DESDE LINEA DE COMANDOS
	 */

	public void llenar(Integer a, Integer b) {
		int array[] = new int[b - a + 1];

		for (int i = 0; i < array.length; i++)
			array[i] = a++;
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		new Proceso().llenar(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}

}
