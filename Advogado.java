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
		if (pessoaFisica == null)	//Deve criar uma?
			throw new AdvogadoException("Pessoa não pode ser nula!");
		this.registro = registro;
		this.pessoaFisica = pessoaFisica;
	}

	public String getRegistro() {
		return registro;
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
