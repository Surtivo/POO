package exceptions;

public class PessoaException extends Exception {

	private static final long serialVersionUID = 224591845597834083L;
	
	public PessoaException (String message) {
		super("PessoaException: " + message);
	}
}
