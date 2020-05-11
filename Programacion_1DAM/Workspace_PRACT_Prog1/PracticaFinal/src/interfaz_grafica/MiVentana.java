package interfaz_grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MiVentana extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void crearVentana() {
		JFrame f = new JFrame("Formulario");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// RECONOCE LAS DIMENSIONES DE LA PANTALLA ACTUAL.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// DIVIDIENDO LA ANCHURA Y LA ALTURA DE LA PANTALLA ENTRE DOS, APARECERA
		// EL JFrame DEL TAMAÑO DE LA PANTALLA EN LA MITAD DE SU ESCALA ORIGINAL.
		f.setSize(pantalla.width / 2, pantalla.height / 2);
		f.setBackground(Color.CYAN);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
