/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.programacionservidores;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Javi
 */
public class EstructuraFicheros implements Serializable {

    private String nombre;
    private String path;
    private boolean esDir;
    private int numFich;
    private EstructuraFicheros[] lista;

    
    
    public EstructuraFicheros(String dir) {
        File f = new File(dir);
        this.nombre = f.getName();
        this.path = f.getPath();
        this.esDir = f.isDirectory();
        this.lista = getListaFiles();
        if (f.isDirectory()) {
            File[] ficheros = f.listFiles();
            if (ficheros != null) {
                this.numFich = ficheros.length;
            }
        }
    }

    public EstructuraFicheros(String nombre, String path, boolean esDir, int numFich) {
        this.nombre = nombre;
        this.path = path;
        this.esDir = esDir;
        this.numFich = numFich;
    }

    public String getNombre() {
        String nombreDir = this.nombre;
        if (this.esDir) {
            int pos = this.path.lastIndexOf(File.separator);
            nombreDir = this.path.substring(pos + 1, this.path.length());
        }

        return nombreDir;
    }

    public String getPath() {
        return path;
    }

    public boolean isEsDir() {
        return esDir;
    }

    public int getNumFich() {
        return numFich;
    }

    public EstructuraFicheros[] getLista() {
        return lista;
    }

    @Override
    public String toString() {
        String nombre = this.nombre;
        if (this.esDir) {
            nombre = "DIR " + this.nombre;
        }
        return nombre;
    }

    public EstructuraFicheros[] getListaFiles() {
        EstructuraFicheros[] lista = null;
        String sDirectorio = this.path;
        File f = new File(sDirectorio);
        File[] ficheros = f.listFiles();
        int longitud = ficheros.length;

        if (longitud > 0) {
            lista = new EstructuraFicheros[longitud];
            for (int i = 0; i < ficheros.length; i++) {
                EstructuraFicheros elemento;
                String nombre = ficheros[i].getName();
                String path = ficheros[i].getPath();
                boolean esDir = ficheros[i].isDirectory();
                int num = 0;

                if (esDir) {
                    File[] fich = ficheros[i].listFiles();
                    if (fich != null) {
                        num = fich.length;
                    }

                }
                elemento = new EstructuraFicheros(nombre, path, esDir, num);
                lista[i] = elemento;
            }//for
        }//if

        return lista;
    }//metodo
}
