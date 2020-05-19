package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTestRetirar {

	Cuenta c;

	@Before
	public void iniciarCuenta() {
		c = new Cuenta("Pepe", "ABCDE1234", 2500);
	}
	
	@Test
	public void testRetirar() throws Exception {
		c.retirar(1000);
		assertEquals(1500, c.obtenerSaldo());
	}

}
