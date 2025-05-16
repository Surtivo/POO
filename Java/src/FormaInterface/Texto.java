package FormaInterface;

public class Texto implements IDesenhavel{
	
	private Coordenada posicao;
	private String texto;
	private String fonte;
	
	public Texto(Coordenada posicao, String texto) {
		this.setPosicao(posicao);
		this.setTexto(texto);
	}
		
	public Coordenada getPosicao() {
		return posicao;
	}

	public String getTexto() {
		return texto;
	}

	public String getFonte() {
		return fonte;
	}

	public void setPosicao(Coordenada posicao) {
		this.posicao = posicao;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public void desenhar() {
		System.out.println("Texto: " + getTexto());
	}
}
