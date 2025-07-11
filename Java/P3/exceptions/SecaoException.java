package exceptions;

public class SecaoException extends Exception{

	private static final long serialVersionUID = 4185463155532114055L;

	public SecaoException (String message) {
		super("SecaoException: " + message);
	}
}
