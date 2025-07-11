package classes;

import exceptions.NomeException;
import valueObjects.Cnpj;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = -1482028978257088890L;
	
	private final Cnpj cnpj;
	private PessoaFisica preposto;

	public PessoaFisica getPreposto() {
		return preposto;
	}

	public void setPreposto(PessoaFisica preposto) {
		this.preposto = preposto;
	}

	public PessoaJuridica(String nome, Email email, Telefone tel, Cnpj cnpj, PessoaFisica preposto) throws NomeException{
		super(nome, email, tel);
		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public String getCadastroRF() {
		return cnpj.toString();
	}

}
