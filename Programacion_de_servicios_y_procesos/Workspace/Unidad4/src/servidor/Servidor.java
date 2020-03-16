package servidor;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;

public class Servidor {

	private final int puerto = 1234;
	private EstructuraFicheros NF;
	private ServerSocket servidor;
	
	public void conectarServidor() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setDialogTitle("Selecciona la carpeta donde se encuentran los ficheros");
		int resp = jfc.showDialog(null, "Seleccionar");
		File f = null;
		if (resp == JFileChooser.APPROVE_OPTION)
			f = jfc.getSelectedFile();
		if (f == null)
			System.out.println("Debe seleccionar una carpeta.");
		else {
			try {
				servidor = new ServerSocket(this.puerto);
				while (true) {
					Socket cliente = servidor.accept();
					System.out.println("Cliente en linea...");
					NF = new EstructuraFicheros(f.getAbsolutePath());
					HiloServidor hiloServidor = new HiloServidor(cliente, NF);
					Thread hilo = new Thread(hiloServidor);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
