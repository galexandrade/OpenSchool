package security;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import model.User;
import security.KeyObfuscator;

public class JWTService{

	private static final String SECRET = "GravityFalls@884123!";
	private static final String ISSUER = "totvs-task-manager";
	private static final int EXPIRATION_DAYS = 10;

	public String encodeToken(User user) throws Exception {
		try {
			return JWT.create()
					.withIssuer(ISSUER)
					.withExpiresAt(getExpirationDate())
					.withClaim("key", KeyObfuscator.encode(User.class, user.getId()))
					.withClaim("userName", user.getUserName())
					.sign(Algorithm.HMAC512(SECRET));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public User decodeToken(String token) throws Exception {
		User user = null;

		try {
			JWTVerifier verifier = JWT
					.require(Algorithm.HMAC512(SECRET))
					.acceptLeeway(1)
					.withIssuer(ISSUER)
					.build();
			DecodedJWT jwt = verifier.verify(token);
			
			user = new User();
			user.setId(Integer.valueOf(KeyObfuscator.decode(User.class, jwt.getClaim("key").asString()).toString()));
			user.setUserName(jwt.getClaim("userName").asString());
			
		} catch(JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException e) {
			throw new Exception(e);
		}

		return user;
	}

	private Date getExpirationDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, EXPIRATION_DAYS);
		return c.getTime();
	}

}
