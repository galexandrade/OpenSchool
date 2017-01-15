package security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Encryptor {
	
	public static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA512";
	public static final int KEY_LENGTH = 512;
	public static final int ITERATIONS = 3000;
	public static final String SALT_ALGORITHM= "SHA1PRNG";
	public static final int SALT_LENGTH = 32;
	public static final String ENCODING = "UTF-8";
	
	private static final char[] HEXADECIMAL = { 
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
	        'e', 'f' 
	    }; 

	public static String encrypt(String plain, String salt) {
		String encrypted = null;
		PBEKeySpec keySpec = null;
		SecretKeyFactory factory = null;
		byte[] encoded = null;
		
		try {
			keySpec = new PBEKeySpec(plain.toCharArray(), salt.getBytes(ENCODING), ITERATIONS, KEY_LENGTH);
			factory = SecretKeyFactory.getInstance(HASH_ALGORITHM);
			encoded = factory.generateSecret(keySpec).getEncoded();
			encrypted = encode(encoded);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return encrypted;
	}
	
	public static String genSalt(){
		String salt = null;
		byte[] byteArray = new byte[SALT_LENGTH];
		try {
			SecureRandom.getInstance(SALT_ALGORITHM).nextBytes(byteArray);
			salt = encode(byteArray);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return salt;
	}
	
	private static String encode(byte[] binaryData) { 
        int n = binaryData.length; 
        char[] buffer = new char[n * 2]; 
        for (int i = 0; i < n; i++) { 
            int low = (binaryData[i] & 0x0f); 
            int high = ((binaryData[i] & 0xf0) >> 4); 
            buffer[i * 2] = HEXADECIMAL[high]; 
            buffer[(i * 2) + 1] = HEXADECIMAL[low]; 
        } 
 
        return new String(buffer); 
    }
}
