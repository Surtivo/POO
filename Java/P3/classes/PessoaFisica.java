package classes;

import exceptions.PessoaException;
import valueObjects.Cpf;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaFisica extends Pessoa{
		private final Cpf cpf;

		public PessoaFisica(String nome, Email email, Telefone tel, Cpf cpf) throws PessoaException {
			super(nome, email, tel);
			//(!NomeUtil.validateNome(nome))
				//throw new PessoaFisicaException ("Nome inválido ou nulo!");
			//if(!EmailUtil.validateEmail(email))
				//throw new PessoaException ("Email inválido ou nulo!");
			//if(!TelUtil.validateTel(tel))
				//throw new PessoaException ("Telefone inválido ou nulo!");
			//if(!CpfUtil.validateCpf(cpf))
				//throw new PessoaException ("CPF inválido ou nulo!");
			this.cpf = cpf;
		}
		
		@Override
		public String getCadastroRF() {
			return cpf.toString();
		}
}
