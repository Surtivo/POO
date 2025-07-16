package dtos;

public class DespesaDto {
	private String idProcesso;
	private String motivo;
	private String valor;
	
	public DespesaDto() {}
	
	public DespesaDto(String id, String motivo, String valor) {
		this.idProcesso = id;
		this.motivo = motivo;
		this.valor = valor;
	}
	
	public String getId() {
		return idProcesso;
	}
	public String getMotivo() {
		return motivo;
	}
	public String getValor() {
		return valor;
	}
	public void setId(String id) {
		this.idProcesso = id;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
