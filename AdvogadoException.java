package exceptions;

public class AdvogadoException extends Exception{
	
	private static final long serialVersionUID = 1019133073797169096L;

	public AdvogadoException (String message) {
		super("Advogado Exception: " + message);
	}
}
