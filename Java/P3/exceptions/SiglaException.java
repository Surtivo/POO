package exceptions;

public class SiglaException extends Exception{

	private static final long serialVersionUID = -7456621470802835711L;

	public SiglaException (String message) {
		super("SiglaException: " + message);
	}
}