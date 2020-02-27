package testing;

public class ServiceInternalException extends RuntimeException{

	/**
	 *  Develop generic Exception handling class for a service , we can also extends Exception
	 *  class instead of RuntimeException 
	 */
	
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String param;
	
	public String getCode() {
		return code;
	}

	public String getParam() {
		return param;
	}

	public ServiceInternalException(String message){
	  super(message);
	}
	
	public ServiceInternalException(String message, Throwable cause){
		  super(message,cause);
	}
	
	public ServiceInternalException(String message, String code){
		  super(message);
		  this.code=code;
	}
	
	public ServiceInternalException(String message, Throwable cause, String code, String param){
		  super(message,cause);
		  this.code=code;
		  this.param=param;
	}
}
