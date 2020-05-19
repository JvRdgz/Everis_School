package clases;

public class Cuenta {

	// Atributos privados
	private String nombre;
	private String cuenta;
	private int saldo;

	// Constructor
	public Cuenta(String nombreCliente, String numeroCuenta, int saldoCuenta) {
		nombre = nombreCliente;
		cuenta = numeroCuenta;
		saldo = saldoCuenta;
	}

	// Metodo que devuelve el saldo disponible en cada momento
	public int obtenerSaldo() {
		return saldo;
	}

	// TODO: Probar con Junit
	// Metodo para ingresar cantidades en la cuenta. Modifica el saldo.
	public void ingresar(int cantidad) throws Exception {
		if (cantidad < 0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		saldo = saldo + cantidad;
	}

	// TODO: Probar con Junit
	// Metodo para retirar cantidades en la cuenta. Modifica el saldo.
	public void retirar(int cantidad) throws Exception {
		if (cantidad < 0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (obtenerSaldo() < cantidad)
			throw new Exception("No hay suficiente saldo");
		saldo = saldo - cantidad;
	}
}
