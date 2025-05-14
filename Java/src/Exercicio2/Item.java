package Exercicio2;

public class Item {
	private ETipoItem tipoItem;
	private long codigo;
	private final String descricao;
	private double preco;
	
	public Item(ETipoItem tipoItem, long codigo, String descricao, double preco) {
		this.tipoItem = tipoItem;
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}
}
