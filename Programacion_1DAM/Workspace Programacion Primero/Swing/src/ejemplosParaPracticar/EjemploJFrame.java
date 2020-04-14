package ejemplosParaPracticar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class EjemploJFrame {

	public static void main(String[] args) {
		Frame f = new Frame("Ejemplo de marco");
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
