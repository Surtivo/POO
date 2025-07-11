package exceptions;

public class RegistroException extends Exception{

	private static final long serialVersionUID = -2880705238021246844L;

	public RegistroException (String message) {
		super("RegistroException: " + message);
	}
}
