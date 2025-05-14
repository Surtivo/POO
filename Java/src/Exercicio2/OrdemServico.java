package Exercicio2;

import java.sql.Date;
import java.util.ArrayList;

import Exercicio2.ItemOS;

public class OrdemServico {
	private static int contador = 0;
	private final int numero;
	private Date data;
	private final int kmAtual;
	private String descricao;
	//private ItemOS iens;
	
	private ArrayList<Item> itens = new ArrayList<>();
	
	public OrdemServico(int numero, Date data, int kmAtual, String descricao) {
		this.numero = numero;
		this.data = data;
		this.kmAtual = kmAtual;
		this.descricao = descricao;
	}
	
	private void addItem(Item item, int qtde) {
		itens.add(item);
	}
}
