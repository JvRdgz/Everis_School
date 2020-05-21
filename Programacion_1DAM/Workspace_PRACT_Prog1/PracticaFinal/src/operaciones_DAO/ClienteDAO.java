package operaciones_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Cliente;

public class ClienteDAO {

	private static Connection conexion;

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		ClienteDAO.conexion = conexion;
	}

	public static void registrarCliente(Cliente cliente) {
		int res_stmt = 0;
		PreparedStatement stmt;
		String query = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		System.out.println(query);
		try {
			stmt = conexion.prepareStatement(query);
			stmt.setInt(1, cliente.getCodigo_cliente());
			stmt.setString(2, cliente.getNombre_cliente());
			stmt.setString(3, cliente.getNombre_contacto());
			stmt.setString(4, cliente.getApellido_contacto());
			stmt.setString(5, cliente.getTelefono());
			stmt.setString(6, cliente.getFax());
			stmt.setString(7, cliente.getLinea_direccion1());
			stmt.setString(8, cliente.getLinea_direccion2());
			stmt.setString(9, cliente.getCiudad());
			stmt.setString(10, cliente.getRegion());
			stmt.setString(11, cliente.getPais());
			stmt.setString(12, cliente.getCodigo_postal());
			stmt.setInt(13, cliente.getCodigo_empleado_rep_ventas());
			stmt.setDouble(14, cliente.getLimite_credito());
			res_stmt = stmt.executeUpdate();
			if (res_stmt == 1)
				System.out.println("Cliente insertado correctamente.");
			else
				System.err.println("\n\tERROR AL INSERTAR EN LA BASE DE DATOS.");
			conexion.commit();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("\n\tERROR SQL CON LA BASE DE DATOS.");
			e.printStackTrace();
		}
	}

	public static ArrayList<Cliente> consultarClientes() {
		ArrayList<Cliente> arr_clientes = new ArrayList<Cliente>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cliente;");
			// EL ResultSet ES UN ARRAY DE VARIAS TABLAS.
			while (rs.next()) {
				int codigo_cliente = rs.getInt("codigo_cliente");
				String nombre_cliente = rs.getString("nombre_cliente");
				String nombre_contacto = rs.getString("nombre_contacto");
				String apellido_contacto = rs.getString("apellido_contacto");
				String telefono = rs.getString("telefono");
				String fax = rs.getString("fax");
				String linea_direccion1 = rs.getString("linea_direccion1");
				String linea_direccion2 = rs.getString("linea_direccion2");
				String ciudad = rs.getString("ciudad");
				String region = rs.getString("region");
				String pais = rs.getString("pais");
				String codigo_postal = rs.getString("codigo_postal");
				int codigo_empleado_rep_ventas = rs.getInt("codigo_empleado_rep_ventas");
				double limite_credito = rs.getDouble("limite_credito");
				Cliente c = new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono,
						fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal,
						codigo_empleado_rep_ventas, limite_credito);
				// System.out.println(c);
				arr_clientes.add(c);
			}
			conexion.commit();
			return arr_clientes;
		} catch (SQLException e) {
			System.err.println("\n\tERROR AL LEER DATOS EN LA TABLA.");
			return null;
		}
	}
}
