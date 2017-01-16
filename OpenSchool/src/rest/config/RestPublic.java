package rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import rest.PublicAccountRest;
import rest.exception.ConstraintViolationExceptionHandler;
import rest.exception.ExceptionHandler;
import rest.exception.NoRecordFoundExceptionHandler;
import rest.json.RestResponseWriter;

@ApplicationPath("public/v1")
public class RestPublic extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		/* services */
		classes.add(PublicAccountRest.class);

		/* filters */
		classes.add(CORSFilter.class);
		
		/* exception mappers */
		classes.add(ConstraintViolationExceptionHandler.class);
		classes.add(ExceptionHandler.class);
		classes.add(NoRecordFoundExceptionHandler.class);

		/* MessageBodyWriter */
		classes.add(RestResponseWriter.class);
		return classes;
	}
}
