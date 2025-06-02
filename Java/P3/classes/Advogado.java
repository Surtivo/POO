package classes;
import exceptions.AdvogadoException;
import interfaces.IPessoa;
import util.RegistroUtil;

public class Advogado implements IPessoa{
	private final String registro;
	private final PessoaFisica pessoaFisica;

	public Advogado (PessoaFisica pessoaFisica, String registro) throws AdvogadoException {
		if(!RegistroUtil.validateRegistro(registro))
			throw new AdvogadoException ("Registro inválido ou nulo!");
		if (pessoaFisica == null)
			throw new AdvogadoException("Pessoa não pode ser nula!");
		this.registro = registro;
		this.pessoaFisica = pessoaFisica;
	}

	public String getRegistro() {
		return registro;
	}
	
	public String getNome() {
		return pessoaFisica.getNome();
	}
	
	public String getEmail() {
		return pessoaFisica.getEmail();
	}
	
	public String getTel() {
		return pessoaFisica.getTel();
	}
	
	public String getCadastroRF() {
		return pessoaFisica.getCadastroRF();
	}
	
}
