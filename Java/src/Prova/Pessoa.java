package Prova;

public abstract class Pessoa {
	private String nome;
	private String email;
	private long tel;
	
	public abstract long getCadastroRF();

	public Pessoa(String nome, String email, long tel) {
		this.nome = nome;
		this.email = email;
		this.tel = tel;
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

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}
}
