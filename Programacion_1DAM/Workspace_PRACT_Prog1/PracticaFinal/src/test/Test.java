package test;

public class Test {

	public static void main(String[] args) {
		double lim_credito = 15.35;
		String str = String.valueOf(lim_credito);
		int parte_entera = Integer.parseInt(str.substring(0, str.indexOf('.'))); // SI DA PROBLEMAS, PROBAR CON ',' EN VEZ DE '.'
		int parte_decimal = Integer.parseInt(str.substring(str.indexOf('.') + 1));
		int num_digitos_parte_decimal = String.valueOf(parte_decimal).length();
		System.out.println("Parte entera: " + parte_entera);
		System.out.println("Parte decimal: " + parte_decimal);
		System.out.println("Numero de digitos total: " + str.replace(".", "").length());
		System.out.println("Numero de digitos parte decimal: " + num_digitos_parte_decimal);
	}

}
