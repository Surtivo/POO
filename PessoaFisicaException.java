package Prova.Exceptions;

public class PessoaFisicaException extends Exception{

	private static final long serialVersionUID = 7580288369802247712L;
	
	public PessoaFisicaException (String message) {
		super("PessoaFisica Exception: " + message);
	}
}
