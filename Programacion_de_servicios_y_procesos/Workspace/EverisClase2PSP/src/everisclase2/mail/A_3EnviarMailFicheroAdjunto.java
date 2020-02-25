/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everisclase2.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Javi
 */
public class A_3EnviarMailFicheroAdjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            Properties prop = new Properties();
            
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.starttls.enable", "true");
            prop.setProperty("mail.smtp.port", "587");
            prop.setProperty("mail.smtp.user", "tucuentadecorreo@dominio.extension");
            prop.setProperty("mail.smtp.auth", "true");
            
            Session sesion = Session.getDefaultInstance(prop);
            
            BodyPart texto = new MimeBodyPart();
            texto.setText("Este seria el texto del mensaje");
            
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("./tufichero")));
            adjunto.setFileName("NombreAdjunto.png");
            
            
            MimeMultipart mensajeCompuesto = new MimeMultipart();
            mensajeCompuesto.addBodyPart(texto);
            
           // mensajeCompuesto.addBodyPart(texto);
            mensajeCompuesto.addBodyPart(adjunto);
            
            
            MimeMessage mensaje = new MimeMessage(sesion);    
           
            
            mensaje.setFrom(new InternetAddress("tucuentadecorreo@dominio.extension"));
            
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("direccion destino"));
            
            mensaje.setSubject("Ejemplo con java mail");
            
            mensaje.setContent(mensajeCompuesto);
            
            Transport t = sesion.getTransport("smtp");
            t.connect("tucuentadecorreo@dominio.extension", "contraseña");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            
            t.close();
            
            
        } catch (AddressException ex) {
            Logger.getLogger(A_3EnviarMailFicheroAdjunto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(A_3EnviarMailFicheroAdjunto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
