package util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class responsible for internationalization. The properties file must
 * be named as "messages" followed by the locale. Example:
 * messages_pt_BR.properties.
 * <p>
 * In case a not supported locale has be passed the default locale will be used instead
 * <p>
 * A translation of a simple expression may be obtained by the following:
 * 
 * <pre>
 * {@code
 * 	String translated = I18n.translate("my.message.key");
 * }
 * </pre>
 * 
 * To translate to a specific supported Locale use the following:
 * 
 * <pre>
 * {@code
 * 	String translated = I18n.translate(new Locale("pt", "BR"), "my.message.key");
 * }
 * </pre>
 * 
 * Arguments may be passed like that:
 * 
 * <pre>
 * {@code
 * 	String translated = I18n.translate(new Locale("en", "US"), "my.message.key", "arg1", "arg2");
 * }
 * </pre>
 * 
 * Or that:
 * 
 * <pre>
 * {@code
 * 	String translated = I18n.translate("{my.message.key}{arg1}{arg2}");
 * }
 * </pre>
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see Locale
 * @see ResourceBundle
 */
public class I18n {

	public static final Locale[] SUPPORTED_LOCALES = { new Locale("en", "US"), new Locale("pt", "BR") };
	public static final Locale DEFAULT_LOCALE = SUPPORTED_LOCALES[0];
	public static final String MESSAGE_KEY_PATTERN = "\\{.*\\}";
	private static final String BUNDLE_NAME = "messages";
	private static final Map<Locale, ResourceBundle> BUNDLE_CACHE = new HashMap<>();

	/**
	 * Translate a message given the locale, key and arguments
	 * 
	 * @param locale
	 *            the locale
	 * @param key
	 *            the messages.properties file key
	 * @param args
	 *            arguments
	 * @return translated String
	 */
	public static String translate(Locale locale, String key, Object... args) {
		String message = null;
		ResourceBundle messages = getBundle(
				Arrays.stream(SUPPORTED_LOCALES).filter(l -> l.equals(locale)).findFirst().orElse(DEFAULT_LOCALE));
		try {
			if (args != null && args.length > 0) {
				message = MessageFormat.format(messages.getString(key), args);
			} else {
				message = messages.getString(key);
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
			message = "{" + key + "}";
		}
		return message;
	}

	/**
	 * Translate a message given the locale and key
	 * 
	 * @param locale
	 *            the locale
	 * @param key
	 *            the messages.properties file key
	 * @return translated String
	 */
	public static String translate(Locale locale, String key) {
		Object[] args = null;
		return I18n.translate(locale, key, args);
	}

	/**
	 * Translate a message given the key. Uses the default locale
	 * 
	 * @param key
	 *            the messages.properties file key
	 * @return translated String
	 */
	public static String translate(String key) {
		return I18n.translate(DEFAULT_LOCALE, key);
	}

	/**
	 * Translate an expression in this format: "{key}{args}"
	 * 
	 * @param locale
	 *            the locale
	 * @param exp
	 *            the expression
	 * @return translated String
	 */
	public static String translateExp(Locale locale, String exp) {
		boolean first = true;
		String key = exp;
		List<String> args = new ArrayList<>();
		Matcher matcher = Pattern.compile(I18n.MESSAGE_KEY_PATTERN).matcher(exp);
		while (matcher.find()) {
			if(first){
				key = matcher.group().replaceAll("[\\{\\}]", "");
				first = false;
			}else{
				args.add(matcher.group().replaceAll("[\\{\\}]", ""));
			}
		}
		return I18n.translate(locale,key,args.toArray(new Object[]{}));
	}

	/**
	 * Returns the {@link ResourceBundle} file of a given locale. The file is
	 * cached for better performance
	 * 
	 * @param locale
	 *            the locale
	 * @return {@link ResourceBundle} file
	 */
	public static ResourceBundle getBundle(Locale locale) {
		ResourceBundle messages = BUNDLE_CACHE.get(locale);
		if (messages == null) {
			messages = ResourceBundle.getBundle(BUNDLE_NAME, locale);
			I18n.updateBundleCache(locale, messages);
		}
		return messages;
	}

	/**
	 * Private synchronized method to update the {@link ResourceBundle} cache
	 * 
	 * @param locale
	 *            the locale
	 * @param bundle
	 *            the bundle to be updated
	 */
	private static synchronized void updateBundleCache(Locale locale, ResourceBundle bundle) {
		if (BUNDLE_CACHE.get(locale) == null) {
			BUNDLE_CACHE.put(locale, bundle);
		}
	}
}
