package Exercicio2;

public class ItemOS {
	private int qtde;
	private double preco;
	private Item item;
	
	public ItemOS(int qtde, Item item) {
		this.qtde = qtde;
		this.preco = item.getPreco();
		this.item = item;
	}
	
	public ETipoItem getTipo() {
		return item.getTipoItem();
	}
	
	public long getCodigo() {
		return item.getCodigo();
	}
	
	public String getDescricao() {
		return item.getDescricao();
	}
	
	public double getPreco() {
		return preco;
	}

	public int getQtde() {
		return qtde;
	}

	public Item getItem() {
		return item;
	}
}
