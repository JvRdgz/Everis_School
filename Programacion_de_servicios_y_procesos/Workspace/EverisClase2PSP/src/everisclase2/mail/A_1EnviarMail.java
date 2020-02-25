/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Javi
 */
public class A_1EnviarMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            
            //Propiedades de la conexion
            Properties prop = new Properties();
            //Nombre del servidor de salida
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            //Habilitamos TLS
            prop.setProperty("mail.smtp.starttls.enable", "true");
            //Indicamos el puerto
            prop.setProperty("mail.smtp.port", "587");
            //Indicamos el usuario
            prop.setProperty("mail.smtp.user", "tucuentadecorreo@dominio.extension");
            //Indicamos que requiere autenticación
            prop.setProperty("mail.smtp.auth", "true");
            
            //Creamos un objeto sesion
            Session sesion = Session.getDefaultInstance(prop);
            //Creamos un objeto mensaje a traves de la sesion
            MimeMessage mensaje = new MimeMessage(sesion);
            
            //Indicamos la cuenta desde la que se va a enviar
            mensaje.setFrom(new InternetAddress("tucuentadecorreo@dominio.extension"));
            
            //Añadimos el recipiente al mensaje al que va a ir dirigido el mensaje
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("destinatario"));
            
            //Creamos el asunto del mensaje
            mensaje.setSubject("Ejemplo con java mail");
            
            //Creamos el cuerpo del mensaje
            mensaje.setText("Este seria el cuerpo del mail");
            
            //Utilizamos un objeto transport para hacer el envio indicando el protocolo
            Transport t = sesion.getTransport("smtp");
            //Hacemos la conexion
            t.connect("tucuentadecorreo@dominio.extension", "tucontraseña");
            //Enviamos el mensaje
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            
            //Cerramos la conexion
            t.close();
            
            
        } catch (AddressException ex) {
            Logger.getLogger(A_1EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(A_1EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
