package project.QRCode;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Security {
	private static final String ALGO = "AES";
	private static byte[] keyValue = UUID.randomUUID().toString().substring(0, 32).getBytes();
	
	public static String Encrypt(String data) {
		Key key = generateKey();
		Cipher c;
		try {
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(data.getBytes());
			String encrypted =  Base64.getEncoder().encodeToString(encVal);
			return encrypted;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return " ";
	}
	
	public static String Decrypt(String data) {
		Key key = generateKey();
		String decryptedValue;
		Cipher c;
		try {
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE,key);
			byte[] decodedValue = Base64.getDecoder().decode(data);
			byte[] decVal = c.doFinal(decodedValue);
			 decryptedValue = new String(decVal);
			return decryptedValue;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		catch(BadPaddingException e) {
			return decryptedValue = "Invalid QR Code";
		}
		
		return " ";
	}
	
	private static Key generateKey() {
		Key key = new SecretKeySpec(keyValue,ALGO);
		return key;
	}

}