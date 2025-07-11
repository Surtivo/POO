package exceptions;

public class NomeException extends Exception{

	private static final long serialVersionUID = -1903084504783613373L;

	public NomeException (String message) {
		super("NomeException: " + message);
	}
}
