package FormaInterface;

public class Quadrado extends Forma{
	private int lado;
	
	public Quadrado(Coordenada posicao, int lado) {
		super(posicao);
		setLado(lado);
	}
	
	public Quadrado(Coordenada posicao, ECor corFundo, ECor corBorda,int lado) {
		super(posicao, corFundo, corBorda);
		setLado(lado);
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}
	
	@Override
	public void desenhar() {
		System.out.println("QUADRADO: " + getCorBorda() + " - " + getCorFundo() + " - " + getLado());
	}

}
