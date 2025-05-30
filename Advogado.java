package Prova;

import Prova.Exceptions.PessoaFisicaException;

public class Advogado implementes IPessoa{
	private final String registro;
	private final PessoaFisica pessoaFisica;

	public Advogado(PessoaFisica pessoaFisica, String registro) throws PessoaFisicaException {
		if (registro == null)
			throw new PessoaFisicaException ("Registro não pode ser menor que zero!");
		if (pessoaFisica == null)
			throw new PessoaFisicaException("Pessoa não pode ser nula");
		this.registro = registro;
		this.pessoaFisica = pessoaFisica;
	}

	public String getRegistro() {
		return registro;
	}
	String getNome() {
		
	}
	String getEmail();
	String getTel();
	String getCadastroRF();
	
}
