package exception;

/**
 * Exception class throw when it's expected that the database query returns at
 * least one result, but no result was returned
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class NoRecordFoundException extends AppException {

	private static final long serialVersionUID = 7847759689516569076L;

	/**
	 * Empty constructor with the default localized message
	 */
	public NoRecordFoundException() {
		super("{app.exception.PoolNoRecordFoundException}");
	}
}
