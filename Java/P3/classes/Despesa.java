package classes;

import java.util.Date;

public class Despesa {
	private final Date data;
	private final String descricao;
	private final double valor;
	
	public Despesa(String descricao, double valor) {
		this.data = new Date();
		this.descricao = descricao;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}
	
	public String ListaDespesa() {
		String aud = null;
		StringBuilder st = new StringBuilder();
		st.append("\nDescricao: " + this.getDescricao() + " - Valor: R$:" + this.getValor());
		aud = "" + st;
		return aud;	
	}

}
