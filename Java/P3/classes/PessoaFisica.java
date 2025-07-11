package classes;

import exceptions.NomeException;
import valueObjects.Cpf;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaFisica extends Pessoa {
	
	private static final long serialVersionUID = 6257196176725467169L;

	private final Cpf cpf;

	public PessoaFisica(String nome, Email email, Telefone tel, Cpf cpf) throws NomeException {
		super(nome, email, tel);
		this.cpf = cpf;
	}

	@Override
	public String getCadastroRF() {
		return cpf.toString();
	}
}
