package main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import generadorClaves.GestorClavesAES;
import generadorClaves.GestorClavesRSA;

public class Main {

	public static void main(String[] args) {
		try {
			String clave = "clavesecreta"; // CLAVE SECRETA
			String texto = "Quiero aprobar PSSPP"; // TEXTO DE PRUEBAS

			System.out.println("Texto para encriptar y desencriptar: " + texto);

			GestorClavesRSA rsa = new GestorClavesRSA();
			GestorClavesAES aes = new GestorClavesAES();

			PublicKey clavePublica = rsa.getPublica(); // CLAVE PUBLICA GENERADA POR RSA
			PrivateKey clavePrivada = rsa.getPrivada(); // CLAVE PRIVADA GENERADA POR RSA

			/*
			 * PROCESO PARA ENCRIPTAR EL TEXTO
			 */

			// ENCRIPTAMOS EL TEXTO CON LA CLAVE SECRETA
			String textoEncriptado = aes.encriptar(texto, clave);
			System.out.println("\nTexto encriptado: " + textoEncriptado);

			/*
			 * PROCESO PARA ENCRIPTAR LA CLAVE SECRETA
			 */

			// CIFRAMOS NUESTRA CLAVE SECRETA 'clave' MEDIANTE LA CLAVE PUBLICA
			String claveCifrada = rsa.cifrar(clave, clavePublica);
			// System.out.println("Clave secreta encriptada: " + claveCifrada); // MOSTRAMOS LA CLAVE CIFRADA. (GUARDADA EN
																				// 'claveCifrada')

			/*
			 * PROCESO PARA PROCESO PARA DESENCRIPTAR LA CLAVE SECRETA
			 */

			// DESCIFRAMOS LA CLAVE QUE HEMOS CIFRADO 'claveCifrada' (MEDIANTE LA CLAVE
			// PRIVADA)
			String claveDescifrada = rsa.descifrar(claveCifrada, clavePrivada);
			// System.out.println("Clave secreta desencriptada: " + claveDescifrada); // MOSTRAMOS LA CLAVE DESCIFRADA
																					// (GUARDADA EN 'claveDescifrada')

			/*
			 * PROCESO PARA DESENCRIPTAR EL TEXTO
			 */

			// DESENCRIPTAMOS EL TEXTO ENCRIPTADO CON LA CLAVE SECRETA DESENCRIPTADA
			String textoDesencriptado = aes.desencriptar(textoEncriptado, claveDescifrada);
			System.out.println("\nTexto desencriptado: " + textoDesencriptado);

		} catch (NoSuchAlgorithmException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al genererar claves RSA", e);
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al genererar claves RSA", e);
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al crear la clave de encriptacion con AES",
					e);
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al crear la clave de encriptacion con AES",
					e);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al crear la clave de encriptacion con AES",
					e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al encriptar el texto", e);
			e.printStackTrace();
		}

	}

}
