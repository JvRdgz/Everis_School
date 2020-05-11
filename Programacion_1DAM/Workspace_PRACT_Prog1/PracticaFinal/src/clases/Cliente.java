package clases;

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
		this.limite_credito = limite_credito;
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
