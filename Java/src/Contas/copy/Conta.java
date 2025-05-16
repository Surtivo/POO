package Contas.copy;

import java.util.ArrayList;

public class Conta {
	private final Agencia agencia;
	private final int numero;
	private final Cliente titular;
	private ArrayList<Transação> transacoes = new ArrayList<Transação>();
	
	public Conta(Agencia agencia, int numero, Cliente titular) {
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
	}
	
	public void depositar(double valor) {
		if(valor <= 0)
			return;
		addTransacao(tipoOperacao.CREDITO, valor);
	}
	
	public double getSaldo() {
		double saldo = 0.0;
		for(Transação t : transacoes) {
			if(t.getTipoOperacao() == tipoOperacao.CREDITO)
				saldo += t.getValor();
			else if(t.getTipoOperacao() == tipoOperacao.DEBITO)
				saldo -= t.getValor();
		}
		return saldo;
	}
	
	public void sacar (double valor) {
		if(valor <= 0)
			return;
		if(valor > getSaldo())
			return;
		addTransacao(tipoOperacao.DEBITO, valor);
	}
	
	public int getNumero() {
		return numero;
	}
	public Cliente getTitular() {
		return titular;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public void addTransacao (tipoOperacao tipoOp, double valor) {
		Transação t = new Transação(tipoOp, valor);
		transacoes.add(t);
	}
	
	public StringBuilder listarExtrato() {		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nAgencia: " + getAgencia().getCodigo() + "\nCod. Conta: " + getNumero() + "\nCliente: " + titular.getCpf() + "\t"+titular.getNome());
				
		sb.append("\n---- Listagem ----");
		for(Transação t : transacoes) {
			sb.append("\n" + t.getData() + "\t" + t.getValor() + "\t" + t.getTipoOperacao());
		}
		sb.append("\nTotal: " + getSaldo());
		
		return sb;
	}



}
	
	
	
	
	