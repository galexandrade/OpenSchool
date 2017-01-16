package builder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import rest.util.RestResponse;
import util.I18n;


/**
 * Class responsible for creation of all REST responses.
 * <p>
 * A success rest response may be build like the following
 * 
 * <pre>
 *  {@code
 *  PoolRestResponseBuilder.getInstance()
 *  	.withStatus("success")
 *  	.withCode(201)
 *  	.withData(data)
 *  	.withMessage("Register inserted successfully")
 *  .build();
 *  }
 * </pre>
 * 
 * To build an error rest response it's necessary to inform an exception as
 * parameter of {@link RestResponseBuilder#withMessage(String)} method. If
 * the exception is an instance of {@link AppException} a new item will be
 * added to errors list for each detail inside the exception details. Otherwise,
 * the exception message will included in errors list. The method may be invoked
 * more then once, the previous values inside errors list will not be lost
 * 
 * <pre>
 * {@code
 * PoolRestResponseBuilder.getInstance()
 * 		.withStatus("error")
 * 		.withCode(400)
 * 		.withException(e)
 * 		.withException(new PoolException())
 * 		.withException(new NumberFormatException())
 * .build();
 * }
 * </pre>
 * 
 * The response can be locale specific. To do so, it's necessary to inform a
 * locale as parameter as the {@link RestResponseBuilder#withLocale(Locale)}
 * method
 * 
 * <pre>
 *  {@code
 *  PoolRestResponseBuilder.getInstance()
 *  	.withStatus("success")
 *  	.withCode(201)
 *  	.withData(data)
 *  	.withMessage("{message.properties.key}")
 *  	.withLocale(locale)
 *  .build();
 *  }
 * </pre>
 * 
 * For localization and internationalization work properly a message key must be
 * informed inside "{}". Exceptions may be localized as well, since
 * {@link Exception#getMessage()} method return a message key inside "{}"
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 * 
 * @see RestResponse
 * @see AppException
 * @see Locale
 * @see I18n
 * 
 */
public class RestResponseBuilder {

	private String status;

	private Object data;

	private Integer code;

	private Map<String, String> errors;

	private String message;

	private Locale locale;

	private RestResponseBuilder() {

	}

	/**
	 * Constructor used only by this class.
	 * 
	 * @param status
	 *            String values representing the response status
	 * @param data
	 *            Object containing the result itself. Any object may be
	 *            provided
	 * @param code
	 *            Integer representing the response status
	 * @param errors
	 *            List containing all error messages
	 * @param message
	 *            String used for a single message or a summary of the errors
	 *            list
	 * @param locale
	 *            Locale used to localize messages
	 */
	private RestResponseBuilder(String status, Object data, Integer code, Map<String,String> errors,
			String message, Locale locale) {
		super();
		this.status = status;
		this.data = data;
		this.code = code;
		this.errors = errors;
		this.message = message;
		this.locale = locale;
	}

	/**
	 * Public method to get a {@link RestResponseBuilder} instance
	 * 
	 * @return new {@link RestResponseBuilder} instance
	 */
	public static RestResponseBuilder getInstance() {
		return new RestResponseBuilder();
	}

	/**
	 * Prepare the response with a status String
	 * 
	 * @param status
	 *            String values representing the response status
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withStatus(String status) {
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Prepare the response with a content
	 * 
	 * @param data
	 *            Object containing the result itself. Any object may be
	 *            provided
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withData(Object data) {
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Prepare the response with a status code
	 * 
	 * @param code
	 *            Integer representing the response status
	 * 
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withCode(Integer code) {
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Prepare the response with an exception message
	 * 
	 * @param error
	 *            Any Exception that inherit or implements {@link Throwable}
	 * 
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withException(Throwable error) {
		if (errors == null) {
			errors = new HashMap<>();
		}
		/*
		if (error instanceof AppException) {
			AppException e = (AppException) error;
			if (e.getDetails() != null && !e.getDetails().isEmpty()) {
				e.getDetails().forEach(
						(v) -> errors.put(v.getField(), v.getMessage()));
			}
		} else {*/
			errors.put("message",error.getMessage());
		//}
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Prepare the response with a message String
	 * 
	 * @param message
	 *            String used for a single message or a summary of the errors
	 *            list
	 * 
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withMessage(String message) {
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Prepare the response with a Locale to provide locale specific messages
	 * 
	 * @param locale
	 *            Locale used to localize messages
	 * @return new {@link RestResponseBuilder} instance
	 */
	public RestResponseBuilder withLocale(Locale locale) {
		return new RestResponseBuilder(status, data, code, errors, message, locale);
	}

	/**
	 * Method responsible to create a new {@link RestResponse} with all the
	 * given values
	 * 
	 * @return new {@link RestResponse} initialized with all given values
	 */
	public RestResponse build() {
		if (locale != null) {
			if (message != null && message.matches(I18n.MESSAGE_KEY_PATTERN)) {
				message = I18n.translateExp(locale, message);
			}
			if (errors != null) {
				errors.entrySet().stream().filter(m -> errors.get(m.getKey()).matches(I18n.MESSAGE_KEY_PATTERN))
					.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
					.forEach( (f,m) -> errors.put(f,I18n.translateExp(locale, m)));
			}
		}
		return new RestResponse(status, code, data, message, errors);
	}
}
