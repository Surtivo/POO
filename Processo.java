package Prova;

import java.util.ArrayList;
import java.util.Date;

public class Processo {
	private Pessoa cliente;
	private Pessoa parteContraria;
	private Tribunal tribunal;
	private final int numero;
	private final Date dataAbertura;
	private EFaseProcesso fase;
	
	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	private ArrayList<Despesa> custas = new ArrayList<>();
	
	
	public Processo(Pessoa cliente, Pessoa parteContraria, Tribunal tribunal, int numero, EFaseProcesso fase) {
		this.cliente = cliente;
		this.parteContraria = parteContraria;
		this.tribunal = tribunal;
		this.numero = numero;
		this.dataAbertura = new Date();
		this.fase = fase;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}

	public Pessoa getParteContraria() {
		return parteContraria;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public int getNumero() {
		return numero;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public EFaseProcesso getFase() {
		return fase;
	}

	public Audiencia getAudiencia(Pessoa parteContraria, String recomendacao) {
		Audiencia a = new Audiencia((Advogado)parteContraria, recomendacao);
		audiencias.add(a); 
		return  a;
	}
	
	public String getAudiencias() {
		String aud = null;
		StringBuilder st = new StringBuilder();
		for(Audiencia a : audiencias) {
			st.append("\nNome: " + a.getRecomendacao());
		}
		aud = "\nAudiencias do processo " + this.getNumero() + ":" + st;
		return aud;	
	}
	
	public String getCustas() {
		String aud = null;
		StringBuilder st = new StringBuilder();
		for(Despesa d : custas) {
			st.append("\nDescricao: " + d.getDescricao() + " - " + d.getValor());
		}
		aud = "\nCustas do processo " + this.getNumero() + ":" + st;
		return aud;	
	}
	
	@Override
	public String toString() {
		String aud = "\nNumero do Processo: " + getNumero() + "\nCliente: " + cliente.getNome() + " - " + cliente.getCadastroRF()
		+"\nContra: " + parteContraria.getNome() + " - " + parteContraria.getCadastroRF() + "\nTribunal: " + tribunal.getSigla() + " - " + tribunal.getDescricao();
		return aud;	
	}
	
	public Despesa getCusta(String descricao, double valor) {
		Despesa c = new Despesa(descricao, valor);
		custas.add(c); 
		return  c;
	} 
	
	public double getTotalCustas() {
		double total = 0.0;
		for(Despesa d : custas) {
			total += d.getValor();
		}
		return total;
	}

}
