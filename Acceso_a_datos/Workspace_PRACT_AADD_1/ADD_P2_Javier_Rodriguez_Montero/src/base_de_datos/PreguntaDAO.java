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

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		PreguntaDAO.conexion = conexion;
	}

	public static int insertarPregunta(Pregunta pregunta) {
		try {
			PreparedStatement stmt = conexion.prepareStatement(
					"INSERT INTO preguntas (,pregunta respuesta1, respuesta2, respuesta3, respuesta_correcta)\n"
							+ "VALUES(?,?,?,?,?);");
			stmt.setString(1, pregunta.getPregunta());
			stmt.setString(2, pregunta.getRespuesta1());
			stmt.setString(3, pregunta.getRespuesta2());
			stmt.setString(4, pregunta.getRespuesta3());
			stmt.setString(5, pregunta.getRespuesta_correcta());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("\n\tERROR AL INGRESAR DATOS EN LA TABLA.");
			e.printStackTrace();
			return -1;
		}
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