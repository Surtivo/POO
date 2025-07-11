package dtos;

public class AdvogadoDto {

	private String nome;
	private String registro;
	private String cadastroRF;

	public AdvogadoDto() {}

	public AdvogadoDto(String nome, String cadastro, String registro) {
		this.nome = nome;
		this.registro = registro;
		this.cadastroRF = cadastro;
	}

	public AdvogadoDto(String cadastro, String registro) {
		this.registro = registro;
		this.cadastroRF = cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getCadastroRF() {
		return cadastroRF;
	}

	public void setCadastroRF(String cadastroRF) {
		this.cadastroRF = cadastroRF;
		;
	}
}
