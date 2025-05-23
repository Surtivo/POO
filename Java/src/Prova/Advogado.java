package Prova;

public class Advogado extends PessoaFisica{
	private final long registro;

	public Advogado(String nome, String email, long tel, long cpf, long registro) {
		super(nome, email, tel, cpf);
		this.registro = registro;
	}

	public long getRegistro() {
		return registro;
	}
	
}
