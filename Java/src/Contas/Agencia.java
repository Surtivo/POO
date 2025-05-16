package Contas;

import java.util.ArrayList;

public class Agencia {
	private int codigo;
	private ArrayList<Transação> transacoes = new ArrayList<Transação>();
	private ArrayList<Conta> contas = new ArrayList<Conta>();

	public int getCodigo() {
		return codigo;
	}

	public void addConta(int numero, Cliente titular){
		Conta novaConta = new Conta(numero, titular);
		contas.add (novaConta);
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

}
