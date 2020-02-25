/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.programacionservidores.cliente;

import everisclase2.programacionservidores.operaciones.EnviarFichero;
import everisclase2.programacionservidores.EstructuraFicheros;
import everisclase2.programacionservidores.operaciones.ObtieneFichero;
import everisclase2.programacionservidores.operaciones.PideFichero;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class HiloCliente_copia  implements Runnable {

    private Socket cliente;
    private EstructuraFicheros raiz;
    private EstructuraFicheros nodo;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String dirSelec;
    private String fichSelec;
    private String pathSelec;
    private FrameCliente frame;
    

    public HiloCliente_copia(Socket hilo) throws IOException {
        this.cliente = hilo;
        this.salida = new ObjectOutputStream(hilo.getOutputStream());
        this.entrada = new ObjectInputStream(hilo.getInputStream());
        this.frame = new FrameCliente();
    }
    
    public HiloCliente_copia()
    {
        
    }

    @Override
    public void run() {
        try {
            this.frame.setVisible(true);
            this.frame.cabecera1.setText("CONECTANDO CON EL SERVIDOR...");
            this.raiz = (EstructuraFicheros) entrada.readObject();
            EstructuraFicheros[] dir = this.raiz.getLista();
            this.dirSelec = this.raiz.getPath();
            llenarLista(dir, this.raiz.getNumFich());
            this.frame.cabecera2.setText("Raiz: " + this.dirSelec);
            this.frame.cabecera1.setText("CONECTANDO AL SERVIDOR DE FICHEROS");
            this.frame.pie2.setText("Nº DE FICHEROS EN EL DIRECTORIO");
            this.raiz.getNumFich();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error");
        }
    }

    public void subirActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setDialogTitle("Selecciona el fichero a subir en el servidor");
        int resp = jfc.showDialog(this.frame, "Subir");
        if (resp == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            String nombreArchivo = f.getName();
            BufferedInputStream bis;
            try {
                bis = new BufferedInputStream(new FileInputStream(f.getAbsolutePath()));
                byte[] buffer = new byte[(int) f.length()];
                int i, j = 0;
                while ((i = bis.read()) != -1) {
                    buffer[j] = (byte) i;
                    j++;
                }

                bis.close();

                Object ob = new EnviarFichero(buffer, nombreArchivo, dirSelec);
                this.salida.writeObject(ob);
                JOptionPane.showMessageDialog(null, "FICHERO SUBIDO");

                this.nodo = (EstructuraFicheros) this.entrada.readObject();
                EstructuraFicheros[] dir = this.nodo.getLista();
                this.dirSelec = this.nodo.getPath();
                llenarLista(dir, this.nodo.getNumFich());
                this.frame.pie2.setText("Nº Ficheros en el directorio: " + dir.length);

            } catch (IOException ex) {
                System.out.println("Errores");
            } catch (ClassNotFoundException ex) {
                System.out.println("Errores");
            }
        }
    }

    public void llenarLista(EstructuraFicheros[] files, int num) {
        if (num == 0) {
            return;
        }

        DefaultListModel modeloLista = new DefaultListModel();
        this.frame.lista.removeAll();
        for (EstructuraFicheros file : files) {
            modeloLista.addElement(file);

        }

        this.frame.lista.setModel(modeloLista);
    }

    public void descargarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.pathSelec.equals("")) {
            return;
        }
        
        try{
            PideFichero pidoFich = new PideFichero(this.pathSelec);
            salida.writeObject(pidoFich);
            FileOutputStream fos = new FileOutputStream(this.fichSelec);
            
            Object obtengoFichero = entrada.readObject();
            if(obtengoFichero instanceof ObtieneFichero)
            {
                ObtieneFichero fich = (ObtieneFichero) obtengoFichero;
                fos.write(fich.getContenidoFichero());
                fos.close();
                JOptionPane.showMessageDialog(null, "FICHERO DESCARGADO");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente_copia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloCliente_copia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    public void salirActionPerformed(java.awt.event.ActionEvent evt)
    {
        try {
            this.cliente.close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente_copia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
//        if(super.lista.getValueIsAdjusting())
//        {
//            String seleccion = super.lista.getSelectedValue();
//            
//            File fichero = new File(seleccion);
//            if(fichero.isDirectory())
//                super.pie1.setText("Función No implementada");
//            else
//            {
//                this.fichSelec = fichero.getName();
//                this.pathSelec = fichero.getPath();
//                this.pie1.setText("Fichero seleccionado: " + this.fichSelec);
//            }
//            
//        }
    }

}
