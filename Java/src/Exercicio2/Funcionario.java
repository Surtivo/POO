package Exercicio2;

public class Funcionario extends Pessoa{
	private final int matricula;
    private boolean disponibilidade;
    
    public Funcionario(int cpf, String nome, String tel, String email, int matricula) {
		super(cpf, nome, tel, email);
		this.matricula = matricula;
		this.disponibilidade = true;
	}
    
    public boolean isDisponivel() {
    	return disponibilidade;
    }

	public int getMatricula() {
		return matricula;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
