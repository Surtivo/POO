package Exercicio2;

public class Funcionario extends Pessoa{
	private final int matricula;
    private boolean disponibilidade;
    
    public Funcionario(int cpf, String nome, String tel, String email, int matricula) {
		super(cpf, nome, tel, email);
		this.matricula = matricula;
		this.disponibilidade = true;
	}

}
