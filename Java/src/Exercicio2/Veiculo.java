package Exercicio2;

public class Veiculo {
	private final String placa;
	private int ano;
	private String cor;
	private Modelo modelo;
	private Cliente proprietario;
	
	public Veiculo(String placa, int ano, String cor, Cliente proprietario) {
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		this.proprietario = proprietario;
	}
	
	private String getModelo() {
		return modelo.toString();
	}	
}
