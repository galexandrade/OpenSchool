package rest.exception;

import java.util.Locale;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import builder.RestResponseBuilder;
import exception.NoRecordFoundException;
import rest.util.RestResponse;


/**
 * {@link ExceptionMapper} for {@link NoRecordFoundException}. Generates the
 * not found response (404)
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Provider
public class NoRecordFoundExceptionHandler implements ExceptionMapper<NoRecordFoundException> {

	@Context
	private HttpHeaders headers;
	
	/**
	 * Build the business error response when the request returns no data. All
	 * messages will be localized based on the given Acceptable-Languages
	 * header, if possible
	 * 
	 * @param exception
	 *            the exception
	 */
	@Override
	public Response toResponse(NoRecordFoundException exception) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		return Response.status(Response.Status.NOT_FOUND)
			.entity(RestResponseBuilder.getInstance()
				.withStatus(RestResponse.STATUS_ERROR)
				.withCode(Response.Status.NOT_FOUND.getStatusCode())
				.withMessage(exception.getMessage())
				.withException(exception)
				.withLocale(locale)
				.build())
			.build();
	}

}
