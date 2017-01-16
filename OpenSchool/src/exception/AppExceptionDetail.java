package exception;

/**
 * Pojo class containing all fields to represent the exception detail
 * 
 * @author Yuri Cavalcante
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class AppExceptionDetail {

	private Integer code;
	
	private String field;
	
	private String message;

	/**
	 * Empty constructor
	 */
	public AppExceptionDetail() {
		super();
	}

	/**
	 * Constructor with a given message
	 * @param message String representing the error message
	 */
	public AppExceptionDetail(String message) {
		super();
		this.message = message;
	}

	/**
	 * Constructor with all class fields
	 * 
	 * @param code
	 *            Integer representing the error code
	 * @param field
	 *            String with the field that provoked the error. Used only for
	 *            bean validation
	 * @param message
	 *            String representing the error message
	 */
	public AppExceptionDetail(Integer code, String field, String message) {
		super();
		this.code = code;
		this.field = field;
		this.message = message;
	}

	/**
	 * Getter of code
	 * 
	 * @return code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Setter of code
	 * 
	 * @param code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Getter of field
	 * 
	 * @return field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Setter of field
	 * 
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Getter of message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter of message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppExceptionDetail other = (AppExceptionDetail) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppExceptionDetail [code=" + code + ", field=" + field + ", message=" + message + "]";
	}
}