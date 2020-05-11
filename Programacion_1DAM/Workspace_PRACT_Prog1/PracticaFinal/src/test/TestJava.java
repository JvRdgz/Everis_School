package test;

import clases.Cliente;
import operaciones_DAO.ClienteDAO;
import operaciones_DAO.ConexionDAO;

public class TestJava {

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
		System.out.println("\n\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
		Cliente c = new Cliente("Forocoches S.L.", "Ilitri", "678987456", "678987456", "Calle del Ilitri", "Palencia");
		System.out.println(c.getCodigo_cliente());
		Cliente c2 = new Cliente("SpaceX Inc.", "Elon", "699631353", "699631353", "Groove Street", "Los Santos");
		System.out.println(c2.getCodigo_cliente());
		
		ClienteDAO.setConexion(ConexionDAO.getConexion());
		ClienteDAO.registrarCliente(c);
		ClienteDAO.registrarCliente(c2);
	}
}
