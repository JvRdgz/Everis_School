package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

/**
 * @author davidrc
 */
public class OperacionesBD {

	private static Connection conexion;
	private static Statement st;

	public static void main(String[] args) {

		conexion = Conexion.getConexion();
		try {
			st = conexion.createStatement();

			if (conexion != null) {
				//borrarTabla();
				//crearTabla();
				//insertar();
				//crearTabla();
				//consultar();
				//insertar();
				//consultar();

				st.close();
				Conexion.desconectar();
			} else {
				System.out.println("Conexion no realizada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			if(conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// CREAR BASE DE DATOS
	public static void crearBaseDeDatos() throws SQLException {
		// Crea la bbdd (comprueba que NO existe)
		// Para crearla es necesario establecer en la conexi�n una bbdd que ya existe previamente
		st.executeUpdate("CREATE DATABASE IF NOT EXISTS dam");
	}

	// CREAR TABLA
	public static void crearTabla() throws SQLException {
		//st.executeQuery("use dam"); //solo necesario en el caso de no hacer la conexi�n con la bbdd objetivo
		
		// Crea la tabla alumno (comprueba que NO existe)
		st.executeUpdate("CREATE TABLE IF NOT EXISTS alumno (" 
				+ "id INT AUTO_INCREMENT, " 
				+ "PRIMARY KEY(id), "
				+ "nombre VARCHAR(255), "
				+ "apellidos VARCHAR(255), "
				+ "telefono VARCHAR(255)" 
				+ ")");
	}

	// INSERTAR REGISTRO (METODO 1)
	public static void insertar() throws SQLException {
		String nombre = "Pepe";
		String apellidos = "Rubio Crespo";
		String telefono = "678453412";
		
		System.out.println("Insertar registro:");
		String query = "INSERT INTO alumno (nombre, apellidos, telefono) " 
				+ "VALUES ('" + nombre + "', '" + apellidos
				+ "', '" + telefono + "');";
		System.out.println(query);
		int resultado = st.executeUpdate(query);

		if (resultado == 0)
			System.out.println("NO se ha podido insertar");
		conexion.commit();
	}

	// INSERTAR REGISTO (METODO 2)
	public static void insertar2() throws SQLException {
		String nombre = "Ursula";
		String apellidos = "Rubio Crespo";
		String telefono = "674123456";
		
		System.out.println("Insertar registro:");
		PreparedStatement ps = conexion
				.prepareStatement("INSERT INTO alumno (nombre, apellidos, correo) " + "VALUES (?, ?, ?)");

		ps.setString(1, nombre);
		ps.setString(2, apellidos);
		ps.setString(3, telefono);
		int resultado = ps.executeUpdate();

		if (resultado == 0)
			System.out.println("NO se ha podido insertar");
		// conexion.commit();

		ps.close();
	}
	
	// CONSULTAR REGISTRO (METODO 1)
	public static void consultar() throws SQLException {
		System.out.println("Consultar registros:");
		String query = "SELECT * FROM alumno";
		System.out.println(query);
		ResultSet rs = st.executeQuery(query);

		// Columnas de la tabla: nombre, apellidos y telefono
		while (rs.next()) {
			String nombre = rs.getString(2); // rs.getString("nombre");
			String apellidos = rs.getString(3); // rs.getString("apellidos");
			String telefono = rs.getString(4); // rs.getString("telefono");

			System.out.println(nombre + "\t" + apellidos + "\t" + telefono);
		}
		rs.close();
	}

	// CONSULTAR REGISTRO (METODO 2)
	//https://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
	public static void consultar2() throws SQLException {
		System.out.println("Consultar registros:");
		String query = "SELECT * FROM alumno WHERE nombre like ?";
		//System.out.println(query);
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, "B%");
		
		ResultSet rs = ps.executeQuery();
		
		// Columnas de la tabla: nombre, apellidos y telefono
		while (rs.next()) {
			String nombre = rs.getString(2); // rs.getString("nombre");
			String apellidos = rs.getString(3); // rs.getString("apellidos");
			String telefono = rs.getString(4); // rs.getString("telefono");

			System.out.println(nombre + "\t" + apellidos + "\t" + telefono);
		}
		rs.close();
		ps.close();
	}
	
	// ACTUALIZAR REGISTRO
	public static void actualizar() throws SQLException {
		System.out.println("Actualizar registro:");
		String query = "UPDATE alumno SET nombre='Ernesto' WHERE id=1";
		System.out.println(query);
		int res = st.executeUpdate(query);
		if (res == 0)
			System.out.println("NO se ha podido actualizar");
		// conexion.commit();
	}

	// BORRAR REGISTRO
	public static void borrar() throws SQLException {
		System.out.println("Borrar registro:");
		String query = "DELETE FROM alumno WHERE id=1";
		System.out.println(query);
		int res = st.executeUpdate(query);
		if (res == 0)
			System.out.println("NO se ha podido borrar");
		// conexion.commit();
	}

	// BORRAR TABLA
	public static void borrarTabla() throws SQLException {
		//st.executeQuery("use dam");
		// Borra la tabla alumno (comprueba que existe)
		st.executeUpdate("DROP TABLE IF EXISTS alumno");
	}

	// BORRAR BASE DE DATOS
	public static void borrarBaseDeDatos() throws SQLException {
		// Borra la bbdd (comprueba que NO existe)
		st.executeUpdate("DROP DATABASE dam2");
	}
	
}
