package Exercicio2;

import java.util.ArrayList;

public class Categoria {
	private final String nome;
	private ArrayList<Item> itens = new ArrayList<>();

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	 public StringBuilder listaItens() {
		 StringBuilder sb = new StringBuilder();
	     for (Item i : itens) {
	    	 sb.append("\n" + i.getCodigo() + "\t" + i.getPreco() + "\t" + i.getDescricao());
	        }
	     return sb;
	 }
	
	
	
}
