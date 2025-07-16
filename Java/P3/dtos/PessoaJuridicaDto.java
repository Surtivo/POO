package dtos;

public class PessoaJuridicaDto {
	
	private String nome;
	private String email;
	private String telefone;
	private String cadastroRF;
	private PessoaFisicaDto preposto;
	
	public PessoaJuridicaDto () {}

	public PessoaJuridicaDto (String nome, String cadastro, String email, String telefone, PessoaFisicaDto preposto){
		this.nome = nome;
		this.cadastroRF = cadastro;
		this.email = email;
		this.telefone = telefone;
		this.preposto = preposto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPrepostoCadastro() {
		if(preposto == null)
			return null;
		return preposto.getCadastroRF();
	}
	
	public String getPrepostoNome() {
		if(preposto == null)
			return null;
		return preposto.getNome();
	}

	public void setPreposto(PessoaFisicaDto preposto) {
		this.preposto = preposto;
	}
	
	public String getCadastroRF() {
		return cadastroRF;
	}

	public void setCadastroRF (String cadastroRF) {
		this.cadastroRF = cadastroRF;;
	}
}

