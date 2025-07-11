package classes;

import java.io.Serializable;
import java.util.Date;

import exceptions.AudienciaException;

public class Audiencia implements Serializable{
	
	private static final long serialVersionUID = 7952061843072475740L;
	
	private final Advogado advogado;
	private final Date data;
	private final String recomendacao;
	
	public Audiencia(Advogado advogado, String recomendacao) throws AudienciaException{
		if(advogado == null)
			throw new AudienciaException("Advogado não pode ser nulo!");
		this.advogado = advogado;
		this.data = new Date();
		if(recomendacao == null)
			throw new AudienciaException("Recomendação não pode ser nula");
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
	
	public String listaAudiencia() {
		String aud = null;
		StringBuilder st = new StringBuilder();
		st.append("\nRecomendação: " + this.getRecomendacao());
		st.append(" - Advogado(a): " + this.getAdvogado().getNome());
		st.append(" - Registro do(a) Advogado(a): " + this.getAdvogado().getRegistro());
		aud = "" + st;
		return aud;	
	}
	
}
