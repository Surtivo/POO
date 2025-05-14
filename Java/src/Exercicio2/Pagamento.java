package Exercicio2;

import java.util.Date;

public class Pagamento {
	private EPagamento pagamento;
	private Date data;
	private final double valor;
	
	public Pagamento(EPagamento pagamento, Date data, double valor) {
		this.pagamento = pagamento;
		this.data = data;
		this.valor = valor;
	}
}
