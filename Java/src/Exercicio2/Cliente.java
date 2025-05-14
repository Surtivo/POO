package Exercicio2;

public class Cliente extends Pessoa {
	private boolean platinum;
	
    public Cliente(int cpf, String nome, String tel, String email, Veiculo veiculo) {
		super(cpf, nome, tel, email);
		this.platinum = false;
	}
}
	
