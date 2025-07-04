package dtos;

public class ProcessoDto {
	String registroCliente;
	String registroParteContraria;
	String tribunal;
	String numeroProc;
	String fase;
	
	public ProcessoDto () {}

	public ProcessoDto (String cliente, String parteContraria, String tribunal, String numero, String fase){
		this.registroCliente = cliente;
		this.registroParteContraria = parteContraria;
		this.tribunal = tribunal;
		this.numeroProc = numero;
		this.fase = fase;
	}

	public String getRegistroCliente() {
		return registroCliente;
	}

	public void setRegistroCliente(String registroCliente) {
		this.registroCliente = registroCliente;
	}

	public String getRegistroParteContraria() {
		return registroParteContraria;
	}

	public void setRegistroParteContraria(String registroParteContraria) {
		this.registroParteContraria = registroParteContraria;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public String getNumeroProc() {
		return numeroProc;
	}

	public void setNumeroProc(String numeroProc) {
		this.numeroProc = numeroProc;
	}	
}
