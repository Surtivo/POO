package dtos;

public class ProcessoDtoCompleto {

	private String clienteCadastro;
	private String clienteNome;
	private String parteContrariaCadastro;
	private String parteContrariaNome;
	private String tribunalSigla;
	private String tribunalDescricao;
	private String numero;
	private String dataAbertura;
	private String fase;

	public ProcessoDtoCompleto() {
	}

	public ProcessoDtoCompleto(String clienteCadastro, String clienteNome, String parteContrariaCadastro,
			String parteContrariaNome, String tribunalSigla, String tribunalDescricao, String numero,
			String dataAbertura, String fase) {
		this.clienteCadastro = clienteCadastro;
		this.clienteNome = clienteNome;
		this.parteContrariaCadastro = parteContrariaCadastro;
		this.parteContrariaNome = parteContrariaNome;
		this.tribunalSigla = tribunalSigla;
		this.tribunalDescricao = tribunalDescricao;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.fase = fase;
	}

	public String getClienteCadastro() {
		return clienteCadastro;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public String getParteContrariaCadastro() {
		return parteContrariaCadastro;
	}

	public String getParteContrariaNome() {
		return parteContrariaNome;
	}

	public String getTribunalSigla() {
		return tribunalSigla;
	}

	public String getTribunalDescricao() {
		return tribunalDescricao;
	}

	public String getNumero() {
		return numero;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public String getFase() {
		return fase;
	}

	public void setClienteCadastro(String clienteCadastro) {
		this.clienteCadastro = clienteCadastro;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public void setParteContrariaCadastro(String parteContrariaCadastro) {
		this.parteContrariaCadastro = parteContrariaCadastro;
	}

	public void setParteContrariaNome(String parteContrariaNome) {
		this.parteContrariaNome = parteContrariaNome;
	}

	public void setTribunalSigla(String tribunalSigla) {
		this.tribunalSigla = tribunalSigla;
	}

	public void setTribunalDescricao(String tribunalDescricao) {
		this.tribunalDescricao = tribunalDescricao;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

}
