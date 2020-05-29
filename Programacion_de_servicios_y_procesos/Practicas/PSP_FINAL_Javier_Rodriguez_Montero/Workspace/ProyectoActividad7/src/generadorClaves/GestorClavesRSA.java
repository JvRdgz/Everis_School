package generadorClaves;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class GestorClavesRSA {

	private KeyPair claves; // PAR DE CLAVES
	private KeyPairGenerator generadorClaves; // GENERA LAS CLAVES
	private Cipher cifrador;

	public GestorClavesRSA() throws NoSuchAlgorithmException, NoSuchPaddingException {
		generadorClaves = KeyPairGenerator.getInstance("RSA");
		generadorClaves.initialize(1024);
		claves = generadorClaves.generateKeyPair();
		cifrador = Cipher.getInstance("RSA");
	}

	public PublicKey getPublica() {
		return claves.getPublic();
	}

	public PrivateKey getPrivada() {
		return claves.getPrivate();
	}

	public String cifrar(String msgOriginal, Key claveCifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] resultado; // ALMACENA EL MENSAJE CIFRADO
		cifrador.init(Cipher.ENCRYPT_MODE, claveCifrado); // EL CIFRADOR LO ESTABLECEMOS COMO MODO ENCRIPTADO
		resultado = cifrador.doFinal(msgOriginal.getBytes());
		return bytesToString(resultado);
	}

	public String descifrar(String msgCifrado, Key claveDescifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] resultado; // ALMACENA EL MENSAJE CIFRADO
		cifrador.init(Cipher.DECRYPT_MODE, claveDescifrado); // EL CIFRADOR LO ESTABLECEMOS COMO MODO DESENCRIPTADO
		resultado = cifrador.doFinal(stringToBytes(msgCifrado));
		return new String(resultado);
	}
	
	public byte[] stringToBytes(String s) {
	    byte[] b2 = new BigInteger(s, 36).toByteArray();
	    return Arrays.copyOfRange(b2, 1, b2.length);
	}
	
	public String bytesToString(byte[] b) {
	    byte[] b2 = new byte[b.length + 1];
	    b2[0] = 1;
	    System.arraycopy(b, 0, b2, 1, b.length);
	    return new BigInteger(b2).toString(36);
	}
}
