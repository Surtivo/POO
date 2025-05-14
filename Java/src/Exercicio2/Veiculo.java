package Exercicio2;

public class Veiculo {
	private final String placa;
	private int ano;
	private String cor;
	private Modelo modelo;
	private Cliente proprietario;
	
	public Veiculo(String placa, int ano, String cor, Cliente proprietario, Modelo modelo) {
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		this.proprietario = proprietario;
		this.modelo = modelo;
	}
	
	public String getModelo() {
		//Modelo modelo = new Modelo("F0");
		//this.modelo = modelo;
		return modelo.getModelo();
	}
	
	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public String getCor() {
		return cor;
	}

	public Cliente getProprietario() {
		return proprietario;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}	
}
