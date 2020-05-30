/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2psp.everisclase2.mail;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.AddressException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Javi
 */
public class A_2LeerrMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Configuramos las propiedades de la sesion
            Properties prop = new Properties();

            //habilitamos el TLS
            prop.setProperty("mail.pop3.starttls.enable", "true");
            //Indicamos que vamos a utiilzar SSL
            prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //Propiedad que permite recueperarse despues de un error
            prop.setProperty("mail.pop3.socketFactory.fallback", "false");
            //Indicamos porque puerto vamos a recibir
            prop.setProperty("mail.pop3.port", "995");
            prop.setProperty("mail.pop3.socketFactory.port", "995");

            //Creamos la sesion
            Session sesion = Session.getDefaultInstance(prop);

            //Necesitamos un objeto store para almacenar lo que venga por el correo
            Store store = sesion.getStore("pop3");

            //Realizamos la conexion
            store.connect("pop.gmail.com", "tucuentadecorreo@dominio.extension", "contraseña");
            //Recogemos lo que haya en la carpeta INBOX
            Folder folder = store.getFolder("INBOX");
            //Especificamos el acceso que sea de solo lectura
            folder.open(Folder.READ_ONLY);

            //Recogemos todos los mensajes que haya en la carpeta
            Message[] mensajes = folder.getMessages();

            for (int i = 0; i < mensajes.length; i++) {
                System.out.println(mensajes[i].getFrom());
                System.out.println(mensajes[i].getSubject());
                mostrarMensaje(mensajes[i]);
            }

            
            //Este seria el listado de carpetas que nos devuelve el servidor
            Folder[] listaCarpetas = store.getDefaultFolder().list("*");

            //Procesamos el listado de carpetas
            for (Folder carpeta : listaCarpetas) {
                System.out.println(carpeta.getName());
            }

            //Cerramos las conexiones
            folder.close(false);
            store.close();

        } catch (AddressException ex) {
            Logger.getLogger(A_2LeerrMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(A_2LeerrMail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mostrarMensaje(Part mensaje) {
        try {
            
            //Si el mensaje recibido es multipart, es decir, que esta compuesto de varias partes, un cuerpo y un adjunto o varios.
            if (mensaje.isMimeType("multipart/*")) {
                //Si es de tipo multipart creamos un objeto multipart
                Multipart multi;
                multi = (Multipart) mensaje.getContent();

                //Comprobamos cuantas partes tiene el mensaje y por cada parte llamamos a la función mostrarMensaje tantas veces como partes tiene
                for (int i = 0; i < multi.getCount(); i++) {
                    mostrarMensaje(multi.getBodyPart(i));
                }

                //Si la parte del mensaje es de tipo texto, sacamos el tipo de contenido y el contenido en si
            } else if (mensaje.isMimeType("text/*")) {
                System.out.println("Texto: " + mensaje.getContentType());
                System.out.println("Texto: " + mensaje.getContent());
                //Si esa parte del mensaje es una imagen, lo que tenemos que hacer es procesarla como tal. Primero, mostramos el contenido y el nombre del fichero  
            } else if (mensaje.isMimeType("image/*")) {
                System.out.println("Imagen: " + mensaje.getContentType());
                System.out.println("Fichero: " + mensaje.getFileName());
                //Guardamos la imagen y la mostramos
                guardarImagen(mensaje);
                mostrarImagen(mensaje);
                //Si no es de ningun tipo de los anteriores mostramos solo el tipo de contenido y el contenido en sí.
            } else if (mensaje.isMimeType("application/*")) {
                System.out.println("Imagen: " + mensaje.getContentType());
                System.out.println("Fichero: " + mensaje.getFileName());
                //Guardamos la imagen y la mostramos
                guardarImagen(mensaje);
                mostrarImagen(mensaje);
                //Si no es de ningun tipo de los anteriores mostramos solo el tipo de contenido y el contenido en sí.
            } else {
                System.out.println(mensaje.getContentType());
                System.out.println(mensaje.getContent());
            }

        } catch (MessagingException ex) {
            Logger.getLogger(A_2LeerrMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(A_2LeerrMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void guardarImagen(Part mensaje) throws IOException, MessagingException {
        //Creamos un frame para mostrar la imagen
        JFrame frame = new JFrame();
        //Creamos un objeto imagen para poder asignarlo a la imagen del mensaje
        ImageIcon icono = new ImageIcon(ImageIO.read(mensaje.getInputStream()));
        //En una etiqueta incrustamos la imagen
        JLabel imagen = new JLabel(icono);
        //Añadimos la imagen al panel
        frame.getContentPane().add(imagen);
        //Comprimir frame
        frame.pack();
        //Lo hacemos visible
        frame.setVisible(true);

    }

    public static void mostrarImagen(Part mensaje) throws MessagingException, FileNotFoundException, IOException {

        //Creamos un nuevo fichero para grabar la imagen
        FileOutputStream fichero = new FileOutputStream("./" + mensaje.getFileName());
        //Creamos un input stream para poder grabar la imagen
        InputStream imagen = mensaje.getInputStream();
        //Creamos un array de bytes para ir controlando la escritura del fichero
        byte[] bytes = new byte[1024];
        //Contador para indicar los bytes que llevamos leidos
        int leidos = 0;

        while ((leidos = imagen.read(bytes)) > 0) {
            fichero.write(bytes, 0, leidos);
        }
    }

}
