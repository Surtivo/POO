package exceptions;

public class NumProcException extends Exception{

	private static final long serialVersionUID = -2134222302880845720L;

	public NumProcException (String message) {
		super("NumProcException: " + message);
	}
}