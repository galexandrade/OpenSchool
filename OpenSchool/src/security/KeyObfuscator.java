package security;

import org.hashids.Hashids;

/**
 * Utility class used to hide the primary key of every entity.
 * <p>
 * The fake key will be generated using the entity class name and the
 * {@link KeyObfuscator#DEFAULT_SALT} value. The fake key can be converted later
 * to the original entity key. Composed primary keys mays be used as well
 * <p>
 * The length of the fake key is defined by {@link #MIN_LENGTH}
 * <p>
 * Example:
 * <pre>
 * {@code
 * //generates the fake key
 * String fakeKey = KeyObfuscator.encode(Resource.class,resource.getId());
 * //decodes the fake key to its original value
 * int id = KeyObfuscator.decodeInt(Resource.class,fakeKey);
 * }
 * </pre>
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public final class KeyObfuscator {

	private static final String DEFAULT_SALT = "Jsad7%!'Ad8@921GplOKJ<<.jd";
	private static final int MIN_LENGTH = 8;
	
	/**
	 * Encodes the given keys into a String value
	 * 
	 * @param clazz
	 *            Entity class used to encode
	 * @param keys
	 *            Keys to be encoded
	 * @return String with the keys encoded
	 */
	public static final String encode(Class<?> clazz, long ... keys){
		String salt = KeyObfuscator.getDynamicSalt(clazz);
		return new Hashids(salt, MIN_LENGTH).encode(keys);
	}
	
	/**
	 * Decodes the fake key into an array of long keys
	 * 
	 * @param clazz
	 *            Entity class used to decode
	 * @param hash
	 *            Encoded keys
	 * @return array of the decoded keys
	 */
	public static final long[] decode(Class<?> clazz, String hash){
		String salt = KeyObfuscator.getDynamicSalt(clazz);
		return new Hashids(salt, MIN_LENGTH).decode(hash);
	}
	
	/**
	 * Decodes the fake key into a single int key
	 * 
	 * @param clazz
	 *            Entity class used to decode
	 * @param hash
	 *            Encoded keys
	 * @return int value of the decoded keys
	 */
	public static final int decodeInt(Class<?> clazz, String hash){
		long[] keys = KeyObfuscator.decode(clazz,hash);
		return keys != null && keys.length > 0 ? (int) keys[0] : 0;
	}
	
	/**
	 * Utility method used to concat the class name with the default salt. When
	 * encoded, the fake key will be different, even if 2 entities has the same
	 * key value
	 * 
	 * @param clazz Entity class used to encode/decode
	 * @return new salt generated based on the entity class name
	 */
	private static final String getDynamicSalt(Class<?> clazz){
		return clazz.getTypeName() + DEFAULT_SALT;
	}
}
