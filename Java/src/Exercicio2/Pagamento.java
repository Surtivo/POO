package Exercicio2;

import java.time.LocalDate;
import java.util.Date;

public class Pagamento {
	private EPagamento pagamento;
	private Date data;
	private LocalDate dataVencimento;
	private final double valor;
	
	public Pagamento(EPagamento pagamento, double valor) {
		this.pagamento = pagamento;
		this.data = new Date();
		this.dataVencimento = LocalDate.of(2025, 6, 30);
		this.valor = valor;
	}
	
	public EPagamento getTipoPagamento() {
		return pagamento;
	}
	
	public LocalDate getVencimento() {
		return dataVencimento;
	}
}
