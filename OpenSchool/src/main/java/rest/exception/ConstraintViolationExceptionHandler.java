package rest.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import builder.RestResponseBuilder;
import exception.AppException;
import exception.AppExceptionDetail;
import rest.util.RestResponse;

/**
 * {@link ExceptionMapper} for {@link ConstraintViolationException}. Generates
 * the specific validation error response
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	@Context
	private HttpHeaders headers;
	
	/**
	 * Build the validation error response based on the given
	 * Acceptable-Languages header and the individual validation errors. All
	 * messages will be localized, if possible
	 * 
	 * @param exception
	 *            the given exception
	 */
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		List<AppExceptionDetail> erros = new ArrayList<>();
		for (ConstraintViolation<?> v : exception.getConstraintViolations()) {
			String field = null;
			Iterator<Node> it = v.getPropertyPath().iterator();
			while(it.hasNext()){
				field = it.next().getName();
			}
			erros.add(new AppExceptionDetail(Response.Status.BAD_REQUEST.getStatusCode(),field,v.getMessage()));
		}
		
		AppException poolException = new AppException(erros);
		
		return Response.status(Response.Status.BAD_REQUEST)
			.entity(RestResponseBuilder.getInstance()
				.withStatus(RestResponse.STATUS_ERROR)
				.withCode(Response.Status.BAD_REQUEST.getStatusCode())
				.withException(poolException)
				.withMessage(poolException.getMessage())
				.withLocale(locale)
				.build())
			.build();
	}

}
