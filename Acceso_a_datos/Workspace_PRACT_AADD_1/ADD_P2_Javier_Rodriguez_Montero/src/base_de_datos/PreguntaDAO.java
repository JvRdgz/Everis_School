package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Pregunta;

public class PreguntaDAO {

	// SI NO INSERTA, COMPROBAR SI ES POR LA CONEXION A LA BASE DE DATOS. EN EL
	// PROYECTO QUE HICE
	// EL AÑO PASADO, CREO UNA CONEXION POR CADA CLASE DAO QUE TENGO, AUNQUE NO
	// ENTIENDO POR QUE.
	// SI NO FUNCIONA, PROBAR A HACERLO DE ESA FORMA.
	private static Connection conexion;
	// private static Statement st;

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		PreguntaDAO.conexion = conexion;
	}

	public static void insertarPregunta(Pregunta pregunta) {
		int res_stmt = 0;
		// EL PreparedStatement ME ESTA DANDO PROBLEMAS, NO INSERTA EN LA BASE DE DATOS.
		// ME DABA PROBLEMAS POR NO PONER EL MALDITO conexion.commit();!!!!!!!!!
		// LLEVO MAS DE 5 HORAS PERDIDAS POR ESE P***** FALLO.

		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement(
					"INSERT INTO preguntas (pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta) VALUES(?,?,?,?,?);");
			stmt.setString(1, pregunta.getPregunta());
			stmt.setString(2, pregunta.getRespuesta1());
			stmt.setString(3, pregunta.getRespuesta2());
			stmt.setString(4, pregunta.getRespuesta3());
			stmt.setString(5, pregunta.getRespuesta_correcta());
			System.out.println(stmt.toString());
			res_stmt = stmt.executeUpdate();
			if (res_stmt == 1)
				System.out.println("Pregunta insertada correctamente.");
			else
				System.err.println("\n\tERROR AL INSERTAR EN LA BASE DE DATOS.");
			conexion.commit(); // ME CAGO EN EL COMMIT!!!
			stmt.close();
		} catch (SQLException e) {
			System.err.println("\n\tERROR EN LA CONEXION CON LA BASE DE DATOS.");
			e.printStackTrace();
		}

		// OPCION NUMERO 2, FUNCIONA TAMBIEN PERFECTAMENTE.
		/*
		 * String query =
		 * ("INSERT INTO preguntas (pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta) VALUES('"
		 * + pregunta.getPregunta() + "','" + pregunta.getRespuesta1() + "','" +
		 * pregunta.getRespuesta2() + "','" + pregunta.getRespuesta3() + "','" +
		 * pregunta.getRespuesta_correcta() + "');"); System.out.println(query); try {
		 * st = conexion.createStatement(); res_stmt = st.executeUpdate(query); if
		 * (res_stmt == 1) { System.out.println("Pregunta insertada correctamente."); }
		 * else System.out.println("\n\tERROR AL INSERTAR EN LA BASE DE DATOS.");
		 * conexion.commit(); } catch (SQLException e) {
		 * System.err.println("\n\tERROR EN LA CONEXION CON LA BASE DE DATOS.");
		 * e.printStackTrace(); }
		 */

	}

	public static ArrayList<Pregunta> consultarPreguntas() {
		ArrayList<Pregunta> arr_preguntas = new ArrayList<Pregunta>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM preguntas;");
			// EL ResultSet ES UN ARRAY DE VARIAS TABLAS.
			while (rs.next()) {
				String pregunta = rs.getString("pregunta");
				String respuesta1 = rs.getString("respuesta1");
				String respuesta2 = rs.getString("respuesta2");
				String respuesta3 = rs.getString("respuesta3");
				String respuesta_correcta = rs.getString("respuesta_correcta");
				Pregunta p = new Pregunta(pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta);
				arr_preguntas.add(p);
			}
			return arr_preguntas;
		} catch (SQLException e) {
			System.err.println("\n\tERROR AL LEER DATOS EN LA TABLA.");
			return null;
		}
	}
}