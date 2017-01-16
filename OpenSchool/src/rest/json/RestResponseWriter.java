package rest.json;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import rest.util.ObjectMapperUitl;
import rest.util.RestResponse;


/**
 * Class responsible for build the JSON object given {@link RestResponse}.
 * By default, null attributes will not be mapped to the JSON object
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class RestResponseWriter implements MessageBodyWriter<RestResponse> {
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type == RestResponse.class;
	}

	@Override
	public long getSize(RestResponse t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(RestResponse response, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		ObjectMapperUitl.getObjectMapper().writeValue(entityStream,response);
		entityStream.flush();
	}

}
