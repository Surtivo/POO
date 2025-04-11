/*package conta;

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
	
	
}*/

package conta;

import java.util.ArrayList;

public class conta {
	private int numero;
	private final Cliente titular;
	
	private ArrayList<Transação> transacoes = new ArrayList();
	
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
	
	public void getTitular() {
		System.out.println("CPF: " + titular.getCpf() + "\tNome: " + titular.getNome());
	}
	
	public conta(int numero, Cliente titular) {
		super();
		this.numero = numero;
		this.titular = titular;
	}
	
	public double getSaldo() {
		double saldo = 0.0;
		
		for (Transação transacao : transacoes) {
			if (transacao.getTipoOperacao() == tipoOperacao.CREDITO)
				saldo += transacao.getValor();
			else if (transacao.getTipoOperacao() == tipoOperacao.DEBITO)
				saldo -= transacao.getValor();
		}
		return saldo;
	}
	
	public StringBuilder listarextrato() {
		StringBuilder sb = new StringBuilder();
		
		sb.append
	}
	
}
	
	
	
	
	