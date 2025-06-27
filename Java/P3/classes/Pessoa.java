package classes;

import exceptions.PessoaException;
import interfaces.IPessoa;
import util.NomeUtil;
import valueObjects.Email;
import valueObjects.Telefone;

public abstract class Pessoa implements IPessoa{
	private String nome;
	private Email email;
	private Telefone tel;
	
	//public abstract String getCadastroRF();

	public Pessoa(String nome, Email email, Telefone tel) throws PessoaException{		
		this.setNome(nome);
		this.email = email;
		this.tel = tel;
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws PessoaException {
		if(!NomeUtil.validateNome(nome))
			throw new PessoaException("Nome inválido ou nulo!");
		this.nome = nome;
	}

	@Override
	public String getEmail() {
		return email.toString();
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	@Override
	public String getTel() {
		return tel.toString();
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}
}
