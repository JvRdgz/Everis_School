package main;

import java.util.Scanner;

import clases.Mail;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// PIDO DATOS DE CORREO EMISOR, RECEPTOR, CONTRASENA, ASUNTO Y TEXTO DEL MENSAJE.
		System.out.println("\n\tACTIVIDAD 3 UNIDAD 4\n");
		System.out.println("Introduce un correo emisor:");
		String correoEmisor = sc.nextLine();
		System.out.println("Introduce tu contrasena:");
		String contrasenaEmisor = sc.nextLine();
		System.out.println("Escribe el correo al que se lo quieres enviar:");
		String correoReceptor = sc.nextLine();
		System.out.println("Escribe el asunto del correo:");
		String asunto = sc.nextLine();
		System.out.println("Escribe el mensaje que quieres enviar:");
		String mensaje = sc.nextLine();
		System.out.println("\nPerfecto, ahora indicame si quieres enviar un correo con archivo adjunto incluido o no:");
		System.out.println("(Introduce 1 para enviar con adjunto o 2 para enviar sin adjunto.");
		sc = new Scanner(System.in);
		int op = sc.nextInt();
		while (op != 1 && op != 2) {
			System.out.println(
					"Error, tienes que introducir 1 para enviar con adjunto o 2 para enviar sin adjunto.\nVuelve a intentarlo:");
			sc = new Scanner(System.in);
			op = sc.nextInt();
		}
		tipoDeCorreo(op, correoEmisor, contrasenaEmisor, correoReceptor, asunto, mensaje);
	}

	// SEGUN LA OPCION INTRODUCIDA, LLAMA A LA FUNCION CON ADJUNTO O SIN ADJUNTO.
	private static void tipoDeCorreo(int op, String correoEmisor, String contrasenaEmisor, String correoReceptor,
			String asunto, String cuerpoMensaje) {
		if (op == 1) {
			Mail.enviarMailAdjunto(correoEmisor, contrasenaEmisor, correoReceptor, asunto, cuerpoMensaje);
		} else
			Mail.enviarMail(correoEmisor, contrasenaEmisor, correoReceptor, asunto, cuerpoMensaje);
	}
}
