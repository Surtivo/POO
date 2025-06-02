package classes;

import exceptions.PessoaJuridicaException;
import util.CnpjUtil;
import util.EmailUtil;
import util.NomeUtil;
import util.TelUtil;

public class PessoaJuridica extends Pessoa{
	private final String cnpj;
	private PessoaFisica preposto;

	public PessoaFisica getPreposto() {
		return preposto;
	}

	public void setPreposto(PessoaFisica preposto) {
		this.preposto = preposto;
	}

	public PessoaJuridica(String nome, String email, String tel, String cnpj, PessoaFisica preposto) throws PessoaJuridicaException{
		super(nome, email, tel);
		if(!NomeUtil.validateNome(nome))
			throw new PessoaJuridicaException ("Nome  inválido ou nulo!");
		if(!EmailUtil.validateEmail(email))
			throw new PessoaJuridicaException ("Email inválido ou nulo!");
		if(!TelUtil.validateTel(tel))
			throw new PessoaJuridicaException ("Telefone inválido ou nulo!");
		if(!CnpjUtil.validateCnpj(cnpj))
			throw new PessoaJuridicaException ("CNPJ inválido ou nulo!");
		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public String getCadastroRF() {
		return cnpj;
	}

}
