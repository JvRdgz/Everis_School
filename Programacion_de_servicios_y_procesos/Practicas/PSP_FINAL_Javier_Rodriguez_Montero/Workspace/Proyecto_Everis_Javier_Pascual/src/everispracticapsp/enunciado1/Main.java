/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everispracticapsp.enunciado1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Main {

    public static Connection conexion;
    public static Statement st;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conexion = Conexion.getConexion();
        try {
            st = conexion.createStatement();

            if (conexion != null) {

                EntradaDatos entrada = new EntradaDatos();
                //Cremoa el objeto para controlar el menu
                MenuPrincipal menu = new MenuPrincipal();

                do {
                    menu.mostrarOpciones();
                    entrada.leerEnteroSeguro();
                    //Llamamos al menu siempre que el usuario no quiera salir.
                    if (entrada.getDatoEntero() != 0) {
                        menu.controlarMenu(entrada);

                    } else {
                        System.out.println("Operaciones de cierre de la aplicacion");
                    }
                } while (entrada.getDatoEntero() != 0);
              
                HiloDemonioActualizacion.detenerDemonioActualizacion = true;
                HiloDemonioContar.detenerDemonioClientes = true;
                //Esperamos mas que el demonio para que de tiempo a que deje de entrar en el bucle
                //y ya podemos cerrar la aplicacion sin que haya Excepciones
                Thread.sleep(10000);
                st.close();

                Conexion.desconectar();
            } else {
                System.out.println("Conexion no realizada");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
