package dtos;

import valueObjects.Secao;
import valueObjects.Sigla;

public class TribunalDto {
	private String sigla;
	private String descricao;
	private String secao;
	
	public TribunalDto (Sigla sigla, String descricao, Secao secao){
		this.sigla = sigla.toString();
		this.descricao = descricao;
		this.secao = secao.toString();
	}
	
	public TribunalDto (String sigla, String descricao, String secao){
		this.sigla = sigla.toString();
		this.descricao = descricao;
		this.secao = secao.toString();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

}
