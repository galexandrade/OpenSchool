package rest.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utility class that should be used to get the {@link ObjectMapper} instance
 * used to convert objects to JSON and JSON to objects
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ObjectMapperUitl {

	/**
	 * Public method that returns the configured {@link ObjectMapper} instance
	 * 
	 * @return Configured {@link ObjectMapper} instance
	 */
	public static final ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}
