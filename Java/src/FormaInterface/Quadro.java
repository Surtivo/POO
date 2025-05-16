package FormaInterface;

import java.util.ArrayList;

public class Quadro {
	
	private ECor corFundo = ECor.WHITE;
	
	private ArrayList<IDesenhavel> elementos = new ArrayList<>();		
	
	public Quadro() {}
	
	public Quadro(ECor corFundo) {
		setCorFundo(corFundo);
	}
	
	public void addElemento (IDesenhavel e) {
		elementos.add(e);
	}

	public ECor getCorFundo() {
		return corFundo;
	}

	public void setCorFundo(ECor corFundo) {
		this.corFundo = corFundo;
	}
	
	public void refresh () {
		System.out.println("QUADRO: " + getCorFundo());
		for (IDesenhavel e : elementos) {
			e.desenhar();
		}
	}
	
}
