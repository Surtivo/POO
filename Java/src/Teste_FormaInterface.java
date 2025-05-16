import FormaInterface.*;

public class Teste_FormaInterface {

	public static void main(String[] args) {
		Quadro q1 = new Quadro();
		
		Forma f1 = new Quadrado(new Coordenada(100, 200), 50);
		Forma f2 = new Quadrado(new Coordenada(100, 200), 500);
		
		Texto t1 = new Texto(new Coordenada(200, 100), "VOCE E JAY, CARA");
		
		if(f1 instanceof Quadrado) {
			((Quadrado) f1).setLado(100);			
		}
		
		q1.addElemento(t1);
		q1.addElemento(f1);
		q1.addElemento(f2);
		
		q1.refresh();
	}

}
