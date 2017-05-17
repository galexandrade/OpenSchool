package rest.exception;

import java.util.Locale;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import builder.RestResponseBuilder;
import exception.AppException;
import rest.util.RestResponse;

/**
 * {@link ExceptionMapper} for {@link PoolException}. Generates the specific
 * business error response
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<AppException> {

	@Context
	private HttpHeaders headers;
	
	/**
	 * Build the business error response based on the given Acceptable-Languages
	 * header. All messages will be localized, if possible
	 * 
	 * @param exception
	 *            the given exception
	 */
	@Override
	public Response toResponse(AppException exception) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		return Response.status(Response.Status.BAD_REQUEST)
			.entity(RestResponseBuilder.getInstance()
				.withStatus(RestResponse.STATUS_ERROR)
				.withCode(Response.Status.BAD_REQUEST.getStatusCode())
				.withMessage(exception.getMessage())
				.withException(exception)
				.withLocale(locale)
				.build())
			.build();
	}

}
