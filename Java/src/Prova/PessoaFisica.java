package Prova;

public class PessoaFisica extends Pessoa{
		private final long cpf;

		public PessoaFisica(String nome, String email, long tel, long cpf) {
			super(nome, email, tel);
			this.cpf = cpf;
		}
		
		@Override
		public long getCadastroRF() {
			return cpf;
		}
}
