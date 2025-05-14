package Exercicio2;

public class Pessoa {
    private final long cpf;
    private String nome;
    private String tel;
    private String email;
    
    public Pessoa (long cpf, String nome, String tel, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.tel = tel;
        this.email = email;
    }

	public long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
