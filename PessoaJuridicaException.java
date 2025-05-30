package Prova.Exceptions;

public class PessoaJuridicaException extends Exception{

	private static final long serialVersionUID = 3078829842509709885L;
	
	public PessoaJuridicaException (String message) {
		super("PessoaJuridica Exception: " + message);
	}
}
