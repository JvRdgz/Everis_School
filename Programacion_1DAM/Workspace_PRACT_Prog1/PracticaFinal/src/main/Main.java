package main;

import interfaz_grafica.InterfazFormulario;

public class Main {

	public static void main(String[] args) {

		InterfazFormulario fm = new InterfazFormulario();
		fm.setVisible(true);
		fm.setLocationRelativeTo(null);

		/*
		 * ProductoDAO.setConexion(ConexionDAO.getConexion()); ArrayList<Producto>
		 * productos = new ArrayList<Producto>(); productos =
		 * ProductoDAO.consultarProductos();
		 * 
		 * Producto p[][] = new Producto[productos.size()][9];
		 */

		/*
		 * for (int i = 0; i < productos.size(); i++) {
		 * System.out.println(productos.get(i)); }
		 */

		/*
		 * double lim_credito = 15.35; String str = String.valueOf(lim_credito); int
		 * parte_entera = Integer.parseInt(str.substring(0, str.indexOf('.'))); // SI DA
		 * PROBLEMAS, PROBAR CON ',' EN // VEZ DE '.' int parte_decimal =
		 * Integer.parseInt(str.substring(str.indexOf('.') + 1)); int
		 * num_digitos_parte_decimal = String.valueOf(parte_decimal).length();
		 * System.out.println("Parte entera: " + parte_entera);
		 * System.out.println("Parte decimal: " + parte_decimal);
		 * System.out.println("Numero de digitos total: " + str.replace(".",
		 * "").length()); System.out.println("Numero de digitos parte decimal: " +
		 * num_digitos_parte_decimal); System.out.println(
		 * "\n\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
		 */

		// System.out.println(Cliente.getUltimoCodigoCliete());

		/*
		 * Cliente c = new Cliente("Forocoches S.L.", "Ilitri", "678987456",
		 * "678987456", "Calle del Ilitri", "Palencia");
		 * System.out.println(c.getCodigo_cliente()); Cliente c2 = new
		 * Cliente("SpaceX Inc.", "Elon", "699631353", "699631353", "Groove Street",
		 * "Los Santos"); System.out.println(c2.getCodigo_cliente());
		 */
		/*
		 * ClienteDAO.setConexion(ConexionDAO.getConexion()); //
		 * ClienteDAO.registrarCliente(c); // ClienteDAO.registrarCliente(c2);
		 * ArrayList<Cliente> arrCliente = new ArrayList<Cliente>(); arrCliente =
		 * ClienteDAO.consultarClientes(); for (int i = 0; i < arrCliente.size(); i++) {
		 * System.out.println(arrCliente.get(i)); }
		 */

		/*
		 * boolean existe = Cliente.existeCodClienteLogIn(40);
		 * System.out.println("\n\nComprobando si existe el usuario: " + existe);
		 * 
		 * boolean comprobarContrasena = Cliente.comprobarContrasena("SpaceX Corp.",
		 * 40); System.out.println("\n\nComprobando si la contraseña es correcta: " +
		 * comprobarContrasena);
		 */
	}
}
