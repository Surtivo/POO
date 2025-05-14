package Exercicio2;

public class ItemOS {
	private int qtde;
	private double preco;
	private Item item;
	
	public ItemOS(int qtde, double preco, Item item) {
		this.qtde = qtde;
		this.preco = preco;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	public int getQtde() {
		return qtde;
	}
}
