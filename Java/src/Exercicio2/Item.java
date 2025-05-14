package Exercicio2;

public class Item {
	private final ETipoItem tipoItem;
	private final long codigo;
	private final String descricao;
	private double preco;
	
	public Item(ETipoItem tipoItem, long codigo, String descricao, double preco) {
		this.tipoItem = tipoItem;
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public ETipoItem getTipoItem() {
		return tipoItem;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}
}
