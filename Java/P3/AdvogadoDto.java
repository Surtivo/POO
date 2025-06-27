package dtos;

public class AdvogadoDto {
	
	private String registro;
	private String cadastroRF;
	
	public AdvogadoDto () {}

	public AdvogadoDto (String cadastro, String registro){
		this.registro = registro;
		this.cadastroRF = cadastro;
		
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

	public void setCadastroRF (String cadastroRF) {
		this.cadastroRF = cadastroRF;;
	}
}
