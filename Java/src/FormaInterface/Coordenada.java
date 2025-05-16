package FormaInterface;

public class Coordenada {
	private int x = 0;
	private int y = 0;
	
	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void setCoordenada (int x, int y) {
		setX (x);
		setY (y);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
}
