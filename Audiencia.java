package Prova;

import java.util.Date;

public class Audiencia {
	private final Advogado advogado;
	private final Date data;
	private final String recomendacao;
	
	public Audiencia(Advogado advogado, String recomendacao) {
		this.advogado = advogado;
		this.data = new Date();
		this.recomendacao = recomendacao;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public Date getData() {
		return data;
	}

	public String getRecomendacao() {
		return recomendacao;
	}
	
}
