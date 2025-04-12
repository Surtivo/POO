package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Conta {
	private int numero;
	private final Cliente titular;
	private ArrayList<Transação> transacoes = new ArrayList<Transação>();
	
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
	
	public Conta(int numero, Cliente titular) {
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

	public void Depositar(double valor){
		Transação entrouTransação = new Transação(tipoOperacao.CREDITO, new Date(), valor);
		transacoes.add (entrouTransação);
	}

	public void Sacar(double valor){
		Transação saiuTransação = new Transação(tipoOperacao.DEBITO, new Date(), valor);
		transacoes.add (saiuTransação);
	}
	
	public StringBuilder listarextrato() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nExtrato da conta " + getNumero() +"\n\n");

		if(transacoes.isEmpty())
			sb.append("Nenhuma transação registrada\n");
		else{
			for(Transação transacao : transacoes){
				sb.append("Data: ").append(transacao.getData())
                  .append(" | Tipo: ").append(transacao.getTipoOperacao())
                  .append(" | Valor: R$ ").append(transacao.getValor()).append("\n\n");
			}
			sb.append("Saldo da Conta: ").append(getSaldo()).append("\n\n");
		}
		return sb;	
	}
}
	
	
	
	
	