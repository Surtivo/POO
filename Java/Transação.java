package conta;

import java.util.Date;

public class Transação {
	private final tipoOperacao operacao;
	private final Date data;
	private final double valor;
	
	public Transação(tipoOperacao operacao, Date data, double valor) {
		this.operacao = operacao;
		this.data = data;
		this.valor = valor;
	}

	public tipoOperacao getTipoOperacao() {
		return operacao;
	}

	public Date getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
	
}
