package clases;

import java.io.File;
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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	public static void enviarMail(String correoEmisor, String contrasenaEmisor, String correoReceptor, String asunto,
			String cuerpoMensaje) {

		// PROPIEDADES DE LA CONEXION
		try {
			Properties propiedades = new Properties();
			propiedades.setProperty("mail.smtp.host", "smtp.gmail.com"); // NOMBRE DEL SERVIDOR DE SALIDA
			propiedades.setProperty("mail.smtp.starttls.enable", "true"); // HABILITAR TLS
			propiedades.setProperty("mail.smtp.port", "587"); // PUERTO DE ESCUCHA
			propiedades.setProperty("mail.smtp.user", correoEmisor); // USUARIO
			propiedades.setProperty("mail.smtp.auth", "true"); // HABILITAMOS LA AUTENTICACION

			// CREAMOS UN OBJETO SESION
			Session sesion = Session.getDefaultInstance(propiedades);
			// CREAMOS UN OBJETO MENSAJE A TRAVES DE LA SESION
			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress(correoEmisor)); // CUENTA DE CORREO DESDE DONDE SE VA A ENVIAR.
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor)); // CUENTA DE CORREO A
																									// LA QUE VA A
																									// LLEGAR.
			mensaje.setSubject(asunto); // ASUNTO DEL CORREO
			mensaje.setText(cuerpoMensaje); // CUERPO DEL MENSAJE

			// CREAMOS OBJETO Transport PARA HACER EL ENVIO DEL MENSAJE MEDIANTE EL
			// PROTOCOLO QUE INDICAMOS (EN ESTE CASO SMTP)
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect(correoEmisor, contrasenaEmisor); // REALIZAMOS LA CONEXION
			transporte.sendMessage(mensaje, mensaje.getAllRecipients()); // ENVIAMOS EL MENSAJE

			transporte.close(); // CERRAMOS LA CONEXION
		} catch (MessagingException e) {
			System.err.println("\n\tERROR AL ENVIAR EL CORREO");
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}

	public static void enviarMailAdjunto(String correoEmisor, String contrasenaEmisor, String correoReceptor,
			String asunto, String cuerpoMensaje) {
		// PROPIEDADES DE LA CONEXION
		try {
			Properties propiedades = new Properties();
			propiedades.setProperty("mail.smtp.host", "smtp.gmail.com"); // NOMBRE DEL SERVIDOR DE SALIDA
			propiedades.setProperty("mail.smtp.starttls.enable", "true"); // HABILITAR TLS
			propiedades.setProperty("mail.smtp.port", "587"); // PUERTO DE ESCUCHA
			propiedades.setProperty("mail.smtp.user", correoEmisor); // USUARIO
			propiedades.setProperty("mail.smtp.auth", "true"); // HABILITAMOS LA AUTENTICACION

			// CREAMOS UN OBJETO SESION
			Session sesion = Session.getDefaultInstance(propiedades);
			// PARA EL CASO DE ENVIAR UN CORREO CON ADJUNTO, EL MENSAJE DEBE CREARSE POR
			// PARTES.
			// PARA ELLO CREAMOS DOS OBJETOS BodyPart, UNO PARA EL MENSAJE Y OTRO PARA EL
			// ADJUNTO.
			BodyPart texto = new MimeBodyPart();
			texto.setText(cuerpoMensaje); // CUERPO DEL MENSAJE

			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(
					new FileDataSource("." + File.separator + "ArchivoAdjunto" + File.separator + "Bienvenido.png")));
			adjunto.setFileName("ArchivoAdjunto.png");

			// CREAMOS EL OBJETO MimeMultipart PARA CREAR EL MENSAJE COMPLEJO COMPUESTO
			MimeMultipart mensajeCompuesto = new MimeMultipart();
			mensajeCompuesto.addBodyPart(texto); // ANADIMOS EL MENSAJE TEXTO AL CUERPO DEL MENSAJE
			mensajeCompuesto.addBodyPart(adjunto); // ANADIMOS EL ARCHIVO ADJUNTO AL CUERPO DEL MENSAJE

			// CREAMOS UN OBJETO MENSAJE A TRAVES DE LA SESION
			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress(correoEmisor)); // CUENTA DE CORREO DESDE DONDE SE VA A ENVIAR.
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor)); // CUENTA DE CORREO A
																									// LA QUE VA A
																									// LLEGAR.
			mensaje.setSubject(asunto); // ASUNTO DEL CORREO
			mensaje.setContent(mensajeCompuesto); // INDICAMOS QUE SU CONTENIDO ES EL MENSAJE COMPUESTO QUE HEMOS CREADO

			// CREAMOS OBJETO Transport PARA HACER EL ENVIO DEL MENSAJE MEDIANTE EL
			// PROTOCOLO QUE INDICAMOS (EN ESTE CASO SMTP)
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect(correoEmisor, contrasenaEmisor); // REALIZAMOS LA CONEXION
			transporte.sendMessage(mensaje, mensaje.getAllRecipients()); // ENVIAMOS EL MENSAJE

			transporte.close(); // CERRAMOS LA CONEXION
			System.out.println("\nCorreo enviado!");
		} catch (MessagingException e) {
			System.err.println("\n\tERROR AL ENVIAR EL CORREO");
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
}
