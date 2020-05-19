package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTestIngresar {

	Cuenta c;

	@Before
	public void iniciarCuenta() {
		c = new Cuenta("Pepe", "ABCDE1234", 2500);
	}

	@Test
	public void testIngresar() throws Exception {
		c.ingresar(500);
		assertEquals(3000, c.obtenerSaldo());
	}
}
