package interfaz_grafica;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import operaciones_DAO.ConexionDAO;
import operaciones_DAO.ProductoDAO;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JTableTest extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;

	public JTableTest() {
		super(new GridLayout(1, 0));

		String[] columnas = { "Codigo de producto", "Nombre", "Gama", "Dimensiones", "Proveedor", "Descripcion",
				"Cantidad en stock", "Precio de venta", "Precio del proveedor", "Añadir" };

		/*
		 * Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new
		 * Boolean(false) }, { "John", "Doe", "Rowing", new Integer(3), new
		 * Boolean(true) }, { "Sue", "Black", "Knitting", new Integer(2), new
		 * Boolean(false) }, { "Jane", "White", "Speed reading", new Integer(20), new
		 * Boolean(true) }, { "Joe", "Brown", "Pool", new Integer(10), new
		 * Boolean(false) } };
		 */

		DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
		ArrayList<Producto> arr_producto = new ArrayList<Producto>();
		ProductoDAO.setConexion(ConexionDAO.getConexion());
		arr_producto = ProductoDAO.consultarProductos();
		/*
		 * JCheckBox jcheckBox = new JCheckBox(); jcheckBox.setSelected(false);
		 * jcheckBox.setBounds(10, 10, 150, 30); jcheckBox.setVisible(true);
		 */
		for (int i = 0; i < arr_producto.size(); i++) {
			String codigoProducto = arr_producto.get(i).getCodigo_producto();
			String nombre = arr_producto.get(i).getNombre();
			String gama = arr_producto.get(i).getGama();
			String dimensiones = arr_producto.get(i).getDimensiones();
			String proveedor = arr_producto.get(i).getProveedor();
			String descripcion = arr_producto.get(i).getDescripcion();
			int cantidadStock = arr_producto.get(i).getCantidadEnStock();
			int precioVenta = arr_producto.get(i).getPrecioVenta();
			int precioProveedor = arr_producto.get(i).getPrecioProveedor();
			// jcheckBox.setVisible(true);
			/*
			 * jl = new JLabel(); jl.add(jcheckBox); jl.setVisible(true);
			 */
			Object[] producto = { codigoProducto, nombre, gama, dimensiones, proveedor, descripcion, cantidadStock,
					precioVenta, precioProveedor };

			tableModel.addRow(producto);
		}

		final JTable table = new JTable(tableModel);
		// table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setFillsViewportHeight(true);

		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data: ");
		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JTableTest newContentPane = new JTableTest();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/*
	 * public static void main(String[] args) { // Schedule a job for the
	 * event-dispatching thread: // creating and showing this application's GUI.
	 * javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * createAndShowGUI(); } }); }
	 */
}
