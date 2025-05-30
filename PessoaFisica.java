package Prova;

import Prova.Exceptions.PessoaFisicaException;
import util.CpfUtil;
import util.EmailUtil;
import util.NomeUtil;
import util.TelUtil;

public class PessoaFisica extends Pessoa{
		private final String cpf;

		public PessoaFisica(String nome, String email, String tel, String cpf) throws PessoaFisicaException {
			super(nome, email, tel);
			if(!NomeUtil.validateNome(nome))
				throw new PessoaFisicaException ("Nome  inválido ou nulo!");
			if(!EmailUtil.validateEmail(email))
				throw new PessoaFisicaException ("Email inválido ou nulo!");
			if(!TelUtil.validateTel(tel))
				throw new PessoaFisicaException ("Telefone inválido ou nulo!");
			if(!CpfUtil.validateCpf(cpf))
				throw new PessoaFisicaException ("CPF inválido ou nulo!");
			this.cpf = cpf;
		}
		
		@Override
		public String getCadastroRF() {
			return cpf;
		}
}
