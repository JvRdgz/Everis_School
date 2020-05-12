package clases;

public class Calculo {
	
	public static Double result(String operacion, Double op1, Double op2) {
		Double resultado = 0.0;
		switch(operacion) {
		case "1":
			resultado = suma(op1, op2);
			// System.out.println(resultado);
			break;
		case "2":
			resultado = resta(op1, op2);
			break;
		case "3":
			resultado = multiplicar(op1, op2);
			break;
		case "4":
			resultado = divir(op1, op2);
			break;
		}
		return (resultado);
	}
	
	public static Double suma(Double op1, Double op2) {
		return op1 + op2;
	}
	
	public static Double resta(Double op1, Double op2) {
		return op1 - op2;
	}
	
	public static Double multiplicar(Double op1, Double op2) {
		return op1 * op2;
	}
	
	public static Double divir(Double op1, Double op2) {
		return op1 / op2;
	}
}
