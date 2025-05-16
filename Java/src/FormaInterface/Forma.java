package FormaInterface;

public abstract class Forma implements IDesenhavel {
	private Coordenada posicao;
	private ECor corFundo = ECor.WHITE;
	private ECor corBorda = ECor.BLACK;
	
	public Forma(Coordenada posicao) {
		super();
		this.posicao = posicao;
	}
	
	public Forma(Coordenada posicao, ECor corFundo, ECor corBorda) {
		super();
		this.posicao = posicao;
		this.corFundo = corFundo;
		this.corBorda = corBorda;
	}

	public Coordenada getPosicao() {
		return posicao;
	}
	
	public ECor getCorFundo() {
		return corFundo;
	}
	
	public ECor getCorBorda() {
		return corBorda;
	}
	
	public void setPosicao(Coordenada posicao) {
		this.posicao = posicao;
	}
	
	public void setCorFundo(ECor corFundo) {
		this.corFundo = corFundo;
	}
	
	public void setCorBorda(ECor corBorda) {
		this.corBorda = corBorda;
	}
	
}
