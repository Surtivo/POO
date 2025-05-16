package Contas.copy;

import java.util.ArrayList;

public class Agencia {
	private static int count = 100;
	private int codigo;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public Agencia() {
		this.codigo = ++count;
	}
	
	public Conta abrirConta(Cliente titular) {
		Conta conta = new Conta (this, count-100, titular);
		contas.add(conta);
		return conta;
	}
	
	public ContaEspecial abrirConta (Cliente titular, double limite) {
		ContaEspecial conta = new ContaEspecial (this, count-100, titular, limite);
		contas.add(conta);
		return conta;
	}
	
	public double getSaldoAgencia() {
		double saldo = 0.0;
		for(Conta c : contas) {
			saldo += c.getSaldo();
		}
		return saldo;
	}
	
	public int getCodigo() {
		return codigo;
	}

}
