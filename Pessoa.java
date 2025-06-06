package classes;

import exceptions.PessoaException;
import interfaces.IPessoa;
import util.NomeUtil;

public abstract class Pessoa implements IPessoa{
	private String nome;
	private String email;
	private String tel;
	
	//public abstract String getCadastroRF();

	public Pessoa(String nome, String email, String tel) throws PessoaException{		
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
