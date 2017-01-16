package rest.util;

import java.util.Locale;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import builder.RestResponseBuilder;

/**
 * Abstract class that should be inherit by all rest service class. Provides
 * access to {@link HttpHeaders} and the common response methods
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public abstract class AppRest {

	@Context
	protected HttpHeaders headers;

	/**
	 * Returns the default success GET response for a given content.
	 * 
	 * @param data
	 *            Object containing the response content
	 * @return Success GET response
	 */
	protected Response buildGetResponse(Object data) {
		return Response.ok(RestResponseBuilder.getInstance()
					.withStatus(RestResponse.STATUS_SUCCESS)
					.withData(data).
					build())
				.build();
	}
	
	protected Response buildQueryResponse(Object data) {
		return Response.ok(data).build();
	}

	/**
	 * Returns the default success POST response that created a new resource.
	 * The newly created resource is returned
	 * <p>
	 * The message attribute returned is localized based on the given
	 * Acceptable-Languages header
	 * 
	 * @param data
	 *            newly created resource
	 * @return success POST response with the newly created resource
	 */
	protected Response buildSaveResponse(Object data) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		return Response.status(Response.Status.CREATED)
				.entity(RestResponseBuilder.getInstance()
					.withStatus(RestResponse.STATUS_SUCCESS)
					.withData(data)
					.withCode(Response.Status.CREATED.getStatusCode())
					.withMessage("{app.rest.response.save.success}")
					.withLocale(locale)
					.build())
				.build();
	}

	/**
	 * Returns the default success PUT response that updated an existing
	 * resource. The updated resource is returned
	 * <p>
	 * The message attribute returned is localized based on the given
	 * Acceptable-Languages header
	 * 
	 * @param data
	 *            updated resource
	 * @return success PUT response with the updated resource
	 */
	protected Response buildUpdateResponse(Object data) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		return Response.ok(RestResponseBuilder.getInstance()
					.withStatus(RestResponse.STATUS_SUCCESS)
					.withData(data)
					.withCode(Response.Status.OK.getStatusCode())
					.withMessage("{app.rest.response.update.success}")
					.withLocale(locale)
					.build())
				.status(Response.Status.OK)
				.build();
	}

	/**
	 * Returns the default success DELETE response that removes an existing
	 * resource. The removed resource is returned
	 * <p>
	 * The message attribute returned is localized based on the given
	 * Acceptable-Languages header
	 * 
	 * @param data
	 *            removed resource
	 * @return success DELETE response with the removed resource
	 */
	protected Response buildDeleteResponse(Object data) {
		Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(null);
		return Response.ok(RestResponseBuilder.getInstance()
					.withStatus(RestResponse.STATUS_SUCCESS)
					.withData(data)
					.withCode(Response.Status.OK.getStatusCode())
					.withMessage("{app.rest.response.delete.success}")
					.withLocale(locale)
					.build())
				.status(Response.Status.OK)
				.build();
	}
}
