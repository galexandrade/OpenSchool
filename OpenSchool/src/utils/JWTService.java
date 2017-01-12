package utils;

import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import model.User;

public abstract class JWTService {
	private static int EXPIRATION_DAYS = 10;
	private static String SECRET = "OpenSchoo@TheSkyIsTh3L1mm1t";
	
	public static String generateKey(User user) {
		String jwt = "";
		try{
			jwt = Jwts.builder()
				  .setSubject("users/TzMUocMF4p")
				  .setExpiration(JWTService.getDateExpiration())
				  .claim("key", JWTService.encrypt(String.valueOf(user.getId())))
				  .claim("UserName", user.getUserName())
				  .signWith(
				    SignatureAlgorithm.HS256,
				    JWTService.SECRET.getBytes("UTF-8")
				  )
				  .compact();
		}catch(Exception e){
			System.out.println("Error generating the key: " + e);
		}
		
		return jwt;
	}
	
	public static boolean validateKey(String tokenId){
		try {

		    Jwts.parser().setSigningKey(JWTService.SECRET).parseClaimsJws(tokenId);

		    return true;

		} catch (SignatureException e) {

		    return false;
		}		
	}
	
	private static Date getDateExpiration(){
		Date dtExpiration = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dtExpiration);
		c.add(Calendar.DATE, JWTService.EXPIRATION_DAYS);
		
		return c.getTime();
	}
	
	public static String MD5Encode(String md5) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}
	
	public static String encrypt(String text){
		try{
            Key aesKey = new SecretKeySpec(JWTService.SECRET.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            
            return new String(encrypted);            
        }
        catch(Exception e){
            return "";
        }
	}
	
	public static String decrypt(String text){
		String decrypted = "";
		try{
            // Create key and cipher
            Key aesKey = new SecretKeySpec(JWTService.SECRET.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(text.getBytes()));
            return decrypted;
        }
        catch(Exception e) {
        	return decrypted;
        }	
	}
}
