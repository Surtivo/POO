package Prova;

public class PessoaJuridica extends Pessoa{
	private final long cnpj;
	private PessoaFisica preposto;

	public PessoaFisica getPreposto() {
		return preposto;
	}

	public void setPreposto(PessoaFisica preposto) {
		this.preposto = preposto;
	}

	public PessoaJuridica(String nome, String email, long tel, long cnpj, PessoaFisica preposto) {
		super(nome, email, tel);
		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public long getCadastroRF() {
		return cnpj;
	}

}
