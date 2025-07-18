package classes;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import enums.EFaseProcesso;
import exceptions.AudienciaException;
import exceptions.DespesaException;
import exceptions.ProcessoException;
import valueObjects.NumProc;

public class Processo implements Serializable {

	private static final long serialVersionUID = -2940018706540107980L;
	
	private Pessoa cliente;
	private Pessoa parteContraria;
	private Tribunal tribunal;
	private final NumProc numero;
	private final Date dataAbertura;
	private EFaseProcesso fase;

	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	private ArrayList<Despesa> custas = new ArrayList<>();

	public Processo(Pessoa cliente, Pessoa parteContraria, Tribunal tribunal, NumProc numero, EFaseProcesso fase) throws ProcessoException {
		if (cliente == null)
			throw new ProcessoException("Cliente do processo não pode ser nulo!");
		this.cliente = cliente;
		if (parteContraria == null)
			throw new ProcessoException("Parte contraria do processo não pode ser nulo!");
		this.parteContraria = parteContraria;
		if (tribunal == null)
			throw new ProcessoException("Tribunal do processo não pode ser nulo!");
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
	
	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public String getNumero() {
		return numero.toString();
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setFase(EFaseProcesso fase) {
		this.fase = fase;
	}

	public EFaseProcesso getFase() {
		return fase;
	}

	public Audiencia addAudiencia(Advogado advogado, String recomendacao) throws AudienciaException {
		Audiencia a = null;
		a = new Audiencia(advogado, recomendacao);
		audiencias.add(a);
		return a;
	}

	public String getAudiencias1() throws AudienciaException {
		String aud = null;
		StringBuilder st = new StringBuilder();
		for (Audiencia a : audiencias) {
			if(a == null)
				throw new AudienciaException("Audiencia não pode ser nula");
			st.append(a.listaAudiencia());
		}
		aud = "\n------------------------------\nAudiencias do processo " + this.getNumero() + ":" + st;
		return aud;
	}
	
	public ArrayList<Audiencia> getAudiencias() {
		return audiencias;
	}
	

	public void setAudiencias(ArrayList<Audiencia> audiencias) {
		this.audiencias = audiencias;
	}

	public Despesa addCusta(String descricao, double valor) throws DespesaException {
		Despesa c = new Despesa(descricao, valor);
		custas.add(c);
		return c;
	}

	public String getCustas() {
		String aud = null;
		StringBuilder st = new StringBuilder();
		for (Despesa d : custas) {
			st.append(d.ListaDespesa());
		}
		aud = "\n------------------------------\nCustas do processo " + this.getNumero() + ":" + st;
		return aud;
	}
	
	public ArrayList<Despesa> getCustos() {
		return this.custas;
	}

	public double getTotalCustas() {
		double total = 0.0;
		for (Despesa d : custas) {
			total += d.getValor();
		}
		return total;
	}
	
	public String getTotalCustas2() {
		double total = 0.0;
		for (Despesa d : custas) {
			total += d.getValor();
		}
		
		DecimalFormat formatador = new DecimalFormat("#.##"); //Limita a 2 casas decimais;
		String stringFormatada = formatador.format(total);
		return stringFormatada;
	}
	
	@Override
	public String toString() {
		String aud = "Numero do Processo: " + getNumero() + "\nData de abertura: " + getDataAbertura() + " - Fase do processo: " + getFase() + "\nCliente: " + cliente.getNome() + " - Registro: "
				+ cliente.getCadastroRF() + "\nParte Contraria: " + parteContraria.getNome() + " - Registro: "
				+ parteContraria.getCadastroRF() + "\nTribunal: " + tribunal.getSigla() + " - "
				+ tribunal.getDescricao();
		return aud;
	}

}
