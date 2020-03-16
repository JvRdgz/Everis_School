package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import servidor.EstructuraFicheros;

public class HiloCliente extends javax.swing.JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket cliente; // SOCKET DEL CLIENTE
	private EstructuraFicheros nodo; // OBJETO ACTUAL
	private EstructuraFicheros raiz; // RAIZ
	private ObjectOutputStream salidaServidor;
	private ObjectInputStream entradaServidor;
	private String dirSelec;
	private String fichSelec;
	private String pathSelec;
	
	public HiloCliente(Socket hilo) {
		initComponents();
		setFrame();
		this.cliente = hilo;
		this.salidaServidor = new ObjectOutputStream(cliente.getOutputStream());
		this.entradaServidor = new ObjectInputStream(cliente.getInputStream());
	}
	
	@Override
	public void run() {
		try {
		this.cabecera1.setText("CONECTANDO CON EL SERVIDOR...");
		this.raiz = (EstructuraFicheros) entradaServidor.readObject();
		EstructuraFicheros[] dir = this.raiz.getLista();
		this.dirSelec = this.raiz.getPath();
		llenarLista(dir, this.raiz.getNumFich());
		this.cabecera2.setText("RAIZ: " + this.dirSelec);
		this.cabecera1.setText("CONECTADO AL SERVIDOR DE FICHEROS");
		this.pie2.setText("Nº de ficheros en el direcotorio: " + this.raiz.getNumFich());
		} catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
