package dtos;

public class CustaDto {
	private String id;
	private String motivo;
	private String valor;
	
	public CustaDto() {}
	
	public CustaDto(String id, String motivo, String valor) {
		this.id = id;
		this.motivo = motivo;
		this.valor = valor;
	}
	
	public String getId() {
		return id;
	}
	public String getMotivo() {
		return motivo;
	}
	public String getValor() {
		return valor;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
