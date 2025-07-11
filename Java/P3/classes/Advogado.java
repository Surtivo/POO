package classes;
import java.io.Serializable;

import exceptions.AdvogadoException;
import interfaces.IPessoa;
import valueObjects.Registro;

public class Advogado implements IPessoa, Serializable{
	
	private static final long serialVersionUID = 8494065544771685558L;
	
	private final Registro registro;
	private final PessoaFisica pessoaFisica;

	public Advogado (PessoaFisica pessoaFisica, Registro registro) throws AdvogadoException {
		if (pessoaFisica == null)
			throw new AdvogadoException("Pessoa não pode ser nula!");
		this.registro = registro;
		this.pessoaFisica = pessoaFisica;
	}

	public String getRegistro() {
		return registro.toString();
	}
	
	@Override
	public String getNome() {
		return pessoaFisica.getNome();
	}
	
	@Override
	public String getEmail() {
		return pessoaFisica.getEmail();
	}
	
	@Override
	public String getTel() {
		return pessoaFisica.getTel();
	}
	
	@Override
	public String getCadastroRF() {
		return pessoaFisica.getCadastroRF();
	}
	
}
