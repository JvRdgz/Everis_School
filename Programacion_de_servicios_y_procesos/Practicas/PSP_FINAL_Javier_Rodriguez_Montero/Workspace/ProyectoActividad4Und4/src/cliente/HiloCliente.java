/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import operaciones.EstructuraFicheros;

/**
 *
 * @author Javi
 */
public class HiloCliente extends FrameCliente implements Runnable {

    private Socket cliente;
    private EstructuraFicheros raiz;
    private EstructuraFicheros nodo;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String dirSelec;
    private String fichSelec;
    private String pathSelec;

    public HiloCliente(Socket socket) throws IOException {
        //llamamos al constructor de la clase padre
        super();

        //
        this.cliente = socket;
        this.salida = new ObjectOutputStream(socket.getOutputStream());
        this.entrada = new ObjectInputStream(socket.getInputStream());
       
    }

    @Override
    public void run() {
        try {
            super.setVisible(true);
            
            super.cabecera1.setText("CONECTANDO CON EL SERVIDOR...");
            
            this.raiz = (EstructuraFicheros) entrada.readObject();
            
            EstructuraFicheros[] dir = this.raiz.getLista();
            
            this.dirSelec = this.raiz.getPath();
            
            llenarLista(dir, this.raiz.getNumFich());
            
            super.cabecera2.setText("Raiz: " + this.dirSelec);
            
            super.cabecera1.setText("CONECTANDO AL SERVIDOR DE FICHEROS");
            
            super.pie2.setText("Nº DE FICHEROS EN EL DIRECTORIO");
            
            this.raiz.getNumFich();
            
            super.setVariables(salida, entrada, dirSelec, fichSelec, pathSelec, raiz, nodo);
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error");
        }
    }


//Aqui estaba el metodo llenar lista

   

}
