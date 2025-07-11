package classes;

import java.io.Serializable;
import java.util.Date;

import exceptions.DespesaException;
import util.DescricaoUtil;
import util.ValorUtil;

public class Despesa implements Serializable{

	private static final long serialVersionUID = -7517189697902629185L;
	
	private final Date data;
	private final String descricao;
	private final double valor;
	
	public Despesa(String descricao, double valor) throws DespesaException{
		this.data = new Date();
		this.descricao = descricao;
		if(!DescricaoUtil.validateMotivo(descricao))
			throw new DespesaException("Motivo da despesa inválido!");
		if(!ValorUtil.validateValor(valor))
			throw new DespesaException("Valor da despesa inválido!");
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
		st.append("\nDescrição: " + this.getDescricao() + " - Valor: R$:" + this.getValor());
		aud = "" + st;
		return aud;	
	}

}
