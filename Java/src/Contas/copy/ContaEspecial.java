package Contas.copy;

public class ContaEspecial extends Conta{
	private double limite;

	public ContaEspecial(Agencia agencia, int numero, Cliente titular, double limite) {
		super(agencia, numero, titular);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public void sacar (double valor) {
		if(valor <= 0)
			return;
		if(valor > getSaldo()+ getLimite())
			return;
		addTransacao(tipoOperacao.DEBITO, valor);
	}

}
