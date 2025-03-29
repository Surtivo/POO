package conta;

public class conta {
	private int numero;
	private String titular;
	private double saldo;
	
	//Métodos;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if(numero <= 0) {	////Condição de guarda;
			System.out.println("Número deve ser maior que zero!");	
			return;
		}
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
