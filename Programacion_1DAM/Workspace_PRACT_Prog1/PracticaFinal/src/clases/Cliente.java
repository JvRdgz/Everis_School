package clases;

import java.util.ArrayList;

import operaciones_DAO.ClienteDAO;
import operaciones_DAO.ConexionDAO;

public class Cliente {

	private int codigo_cliente; // AUTOINCREMENT
	private String nombre_cliente;
	private String nombre_contacto;
	private String apellido_contacto; // DEFAULT NULL
	private String telefono;
	private String fax;
	private String linea_direccion1;
	private String linea_direccion2; // DEFAULT NULL
	private String ciudad;
	private String region; // DEFAULT NULL
	private String pais; // DEFAULT NULL
	private String codigo_postal; // DEFAULT NULL
	private int codigo_empleado_rep_ventas; // CLASE EMPLEADO. DEFAULT NULL
	private double limite_credito; // DEFAULT NULL

	// CONSTRUCTOR PARA REGISTRAR CLIENTE
	public Cliente(String nombre_cliente, String nombre_contacto, String telefono, String fax, String linea_direccion1,
			String ciudad) {
		// AL NO SER EL codigo_cliente AUTOINCREMENT EN LA BBDD,
		// TENGO QUE GUARDARLO DE FORMA AUTOMATICA A PARTIR DEL VALOR DEL ULTIMO CLIENTE
		this.codigo_cliente = getUltimoCliente() + 1;
		this.nombre_cliente = nombre_cliente;
		this.nombre_contacto = nombre_contacto;
		this.apellido_contacto = null;
		this.telefono = telefono;
		this.fax = fax;
		this.linea_direccion1 = linea_direccion1;
		this.linea_direccion2 = null;
		this.ciudad = ciudad;
		this.region = null;
		this.pais = null;
		this.codigo_postal = null;
		this.codigo_empleado_rep_ventas = 12; // ES UNA FOREIGN KEY DE EMPLEADO, POR TANTO LE PONDRE UNA VALIDA POR
												// DEFECTO 12
		this.limite_credito = 0; // POR DEFECTO 0
	}

	// CONSTRUCTOR PARA CONSULTAS SQL
	public Cliente(int codigo_cliente, String nombre_cliente, String nombre_contacto, String apellido_contacto,
			String telefono, String fax, String linea_direccion1, String linea_direccion2, String ciudad, String region,
			String pais, String codigo_postal, int codigo_empleado_rep_ventas, double limite_credito) {
		this.codigo_cliente = codigo_cliente;
		this.nombre_cliente = nombre_cliente;
		this.nombre_contacto = nombre_contacto;
		this.apellido_contacto = apellido_contacto;
		this.telefono = telefono;
		this.fax = fax;
		this.linea_direccion1 = linea_direccion1;
		this.linea_direccion2 = linea_direccion2;
		this.ciudad = ciudad;
		this.region = region;
		this.pais = pais;
		this.codigo_postal = codigo_postal;
		this.codigo_empleado_rep_ventas = codigo_empleado_rep_ventas;
		this.limite_credito = limite_credito;
	}

	// DEVUELVE EL CODIGO DE CLIENTE DEL ULTIMO CLIENTE INSERTADO EN LA BASE DE
	// DATOS.
	private int getUltimoCliente() {
		int codCliente = 0;
		ClienteDAO.setConexion(ConexionDAO.getConexion());
		ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
		arrCliente = ClienteDAO.consultarClientes();
		int j = 0;
		while (j < arrCliente.size()) {
			codCliente = arrCliente.get(j).getCodigo_cliente();
			j++;
		}
		return codCliente;
	}

	// SI EL RESULTADO ES TRUE, ES QUE EL USUARIO EXISTE EN LA BASE DE DATOS.
	public static boolean existeCodClienteLogIn(int codCliente) {
		boolean result = false;
		ClienteDAO.setConexion(ConexionDAO.getConexion());
		ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
		arrCliente = ClienteDAO.consultarClientes();
		for (int i = 0; i < arrCliente.size(); i++) {
			if (codCliente == arrCliente.get(i).getCodigo_cliente()) {
				result = true;
			}
		}
		return result;
	}

	// SI EL RESULTADO ES TRUE, ES QUE LA CONTRASEÑA ES CORRECTA Y COINCIDE CON EL
	// CODIGO DE CLIENTE.
	public static boolean comprobarContrasena(String nombreCliente, int codCliente) {
		boolean result = false;
		ClienteDAO.setConexion(ConexionDAO.getConexion());
		ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
		arrCliente = ClienteDAO.consultarClientes();
		for (int i = 0; i < arrCliente.size(); i++) {
			if (codCliente == arrCliente.get(i).getCodigo_cliente()
					&& nombreCliente.equals(arrCliente.get(i).getNombre_cliente())) {
				result = true;
			}
		}
		return result;
	}

	// PARA REGISTRO DE NUEVOS USUARIOS.
	// SI EL RESULTADO ES TRUE, ES QUE EL USUARIO YA EXISTE EN LA BASE DE DATOS
	public static boolean comprobarExisteCliente(String nombreCliente) {
		boolean result = false;
		ClienteDAO.setConexion(ConexionDAO.getConexion());
		ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
		arrCliente = ClienteDAO.consultarClientes();
		for (int i = 0; i < arrCliente.size(); i++) {
			if (nombreCliente.equalsIgnoreCase(arrCliente.get(i).getNombre_cliente())) {
				result = true;
			}
		}
		return result;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getApellido_contacto() {
		return apellido_contacto;
	}

	public void setApellido_contacto(String apellido_contacto) {
		this.apellido_contacto = apellido_contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLinea_direccion1() {
		return linea_direccion1;
	}

	public void setLinea_direccion1(String linea_direccion1) {
		this.linea_direccion1 = linea_direccion1;
	}

	public String getLinea_direccion2() {
		return linea_direccion2;
	}

	public void setLinea_direccion2(String linea_direccion2) {
		this.linea_direccion2 = linea_direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public int getCodigo_empleado_rep_ventas() {
		return codigo_empleado_rep_ventas;
	}

	public void setCodigo_empleado_rep_ventas(int codigo_empleado_rep_ventas) {
		this.codigo_empleado_rep_ventas = codigo_empleado_rep_ventas;
	}

	public double getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(double limite_credito) {
		this.limite_credito = limite_credito;
	}

	@Override
	public String toString() {
		return "Cliente [codigo_cliente=" + codigo_cliente + ", nombre_cliente=" + nombre_cliente + ", nombre_contacto="
				+ nombre_contacto + ", apellido_contacto=" + apellido_contacto + ", telefono=" + telefono + ", fax="
				+ fax + ", linea_direccion1=" + linea_direccion1 + ", linea_direccion2=" + linea_direccion2
				+ ", ciudad=" + ciudad + ", region=" + region + ", pais=" + pais + ", codigo_postal=" + codigo_postal
				+ ", codigo_empleado_rep_ventas=" + codigo_empleado_rep_ventas + ", limite_credito=" + limite_credito
				+ "]";
	}

	/**
	 * VALIDA QUE EL NUMERO PASADO POR PARAMETRO ESTE CORRECTAMENTE FORMADO SEGUN EL
	 * TIPO DE DATO 'NUMERIC' SQL INDICADO EN EL SCRIPT SQL RESPETANDO LA PRECISION
	 * Y LA ESCALA INDICADOS.
	 * 
	 * EN ESTE CASO, EL NUMERO NO PUEDE CONTENER MAS DE 15 CIFRAS EN TOTAL, CONTANDO
	 * AMBOS LADOS DEL SEPARADOR DECIMAL (PRECISION), ASI COMO NO TENER MAS DE 2
	 * CIFRAS A LA DERECHA DEL SEPARADOR (ESCALA).
	 * 
	 * LA VARIABLE SERA DE TIPO DOUBLE Y NO FLOAT, DADO QUE FLOAT SOLO PERMITE
	 * ALMACENAR HASTA 7 DIGITOS.
	 * 
	 * SI DEVUELVE 'true', EL FORMATO ES CORRECTO.
	 */
	/*
	 * ME ACABO DE DAR CUENTA DE QUE NO ME HACE FALTA ESTO, DADO QUE EN LA BASE DE
	 * DATOS ES UN REGISTRO DEFAULT NULL ;( private boolean
	 * validar_limite_credito(double lim_credito) { boolean correcto = false; String
	 * str = String.valueOf(lim_credito); // SI DA PROBLEMAS, PROBAR CON ',' EN VEZ
	 * DE '.' int parte_decimal = Integer.parseInt(str.substring(str.indexOf('.') +
	 * 1)); int num_digitos_parte_decimal = String.valueOf(parte_decimal).length();
	 * int num_digitos_total = str.replace(".", "").length();
	 * 
	 * if (num_digitos_total <= 15 && num_digitos_parte_decimal <= 2) correcto =
	 * true; return correcto; }
	 */
}
