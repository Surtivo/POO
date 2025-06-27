package classes;

import exceptions.PessoaException;
import valueObjects.Cnpj;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaJuridica extends Pessoa{
	private final Cnpj cnpj;
	private PessoaFisica preposto;

	public PessoaFisica getPreposto() {
		return preposto;
	}

	public void setPreposto(PessoaFisica preposto) {
		this.preposto = preposto;
	}

	public PessoaJuridica(String nome, Email email, Telefone tel, Cnpj cnpj, PessoaFisica preposto) throws PessoaException{
		super(nome, email, tel);
		//if(!NomeUtil.validateNome(nome))
			//throw new PessoaException ("Nome  inválido ou nulo!");
		//if(!EmailUtil.validateEmail(email))
			//throw new PessoaException ("Email inválido ou nulo!");
		//if(!TelUtil.validateTel(tel))
			//throw new PessoaException ("Telefone inválido ou nulo!");
		//if(!CnpjUtil.validateCnpj(cnpj))
			//throw new PessoaException ("CNPJ inválido ou nulo!");
		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public String getCadastroRF() {
		return cnpj.toString();
	}

}
