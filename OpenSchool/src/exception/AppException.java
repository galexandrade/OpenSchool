package exception;

import java.util.List;

import javax.ejb.ApplicationException;

/**
 * Base exception of all project exceptions.
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ApplicationException(rollback = true)
public class AppException extends Exception {

	private static final long serialVersionUID = 6989060167579823030L;

	private List<AppExceptionDetail> details;

	/**
	 * Empty constructor. By default sets the message attribute as the default
	 * localized message
	 */
	public AppException() {
		super("{app.exception.default.message}");
	}

	/**
	 * Constructor with a given message
	 * 
	 * @param message
	 *            String representing the error message
	 */
	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor with a given message and details
	 * 
	 * @param message
	 *            String representing the error message
	 * @param details
	 *            List containing all exception details
	 */
	public AppException(String message, List<AppExceptionDetail> details) {
		super(message);
		this.details = details;
	}

	/**
	 * Constructor with a given details
	 * 
	 * @param details
	 *            List containing all exception details
	 */
	public AppException(List<AppExceptionDetail> details) {
		super("{app.validation.exception.default.message}");
		this.details = details;
	}

	/**
	 * Getter of details
	 * 
	 * @return details
	 */
	public List<AppExceptionDetail> getDetails() {
		return details;
	}

	/**
	 * Setter of details
	 * 
	 * @param details
	 */
	public void setDetails(List<AppExceptionDetail> details) {
		this.details = details;
	}

}
