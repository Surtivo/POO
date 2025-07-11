package dtos;

public class AudienciaDto {

	private String IDprocesso;
	private String advogado;
	private String recomendacao;

	public AudienciaDto() {}

	public AudienciaDto(String id, String advogado, String recomendacao) {
		this.IDprocesso = id;
		this.advogado = advogado;
		this.recomendacao = recomendacao;
	}

	public String getIDprocesso() {
		return IDprocesso;
	}

	public void setIDprocesso(String id) {
		this.IDprocesso = id;
	}

	public String getAdvogado() {
		return advogado;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setAdvogado(String advogado) {
		this.advogado = advogado;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

}
