package exceptions;

public class TelefoneException extends Exception{

	private static final long serialVersionUID = -886988453743191012L;

	public TelefoneException (String message) {
		super("TelefoneException: " + message);
	}
}
