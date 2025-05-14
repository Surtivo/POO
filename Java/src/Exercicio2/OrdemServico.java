package Exercicio2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrdemServico {
	private static int contador = 0;
	private final int numero;
	private final Date data;
	private final int kmAtual;
	private String descricao;
	private final Cliente cliente;
	private Funcionario consultor;
	private final Veiculo veiculo;
	private Pagamento pagamento;
	
	
	private ArrayList<ItemOS> itens = new ArrayList<>();
	
	
	public OrdemServico(int kmAtual, String descricao, Cliente cliente, Funcionario consultor, Veiculo veiculo) {
		this.numero = ++contador;
		this.data = new Date();
		this.kmAtual = kmAtual;
		this.descricao = descricao;
		this.cliente = cliente;
		this.consultor = consultor;
		this.veiculo = veiculo;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void addItem(Item item, int qtde) {
		itens.add(new ItemOS (qtde, item));
	}
	
	public double getTotalServico() {
		double sumServicos = 0;
		for(ItemOS item : itens) {
			if(item.getTipo() == ETipoItem.SERVICO) {
				sumServicos += item.getPreco();
			}
		}
		return sumServicos;
	}
	
	public double getTotalPecas() {
		double sumPecas = 0;
		for(ItemOS item : itens) {
			if(item.getTipo() == ETipoItem.PECA) {
				sumPecas += item.getPreco();
			}
		}
		return sumPecas;
	}
	
	public double getTotalOS() {
		return getTotalPecas() + getTotalServico();
	}
	
	public StringBuilder listaOS() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nCodigo da consulta: " + numero + "\tData/hora da abertura: " + data);
		sb.append("\nCliente: " + cliente.getCpf() + " - " + cliente.getNome() + " - " + cliente.getTel());
		sb.append("\nConsultor: " + consultor.getMatricula() + " - " + consultor.getNome());
		sb.append("\nVeiculo: " + veiculo.getModelo() + " - " + veiculo.getPlaca() + " - " + veiculo.getAno() + " - " + kmAtual);
		
		sb.append("\nDescricao da consulta: " + descricao);
		

		sb.append("\n\n---- Listagem de itens ----");
		for (ItemOS i : itens) {
			sb.append("\n" + i.getTipo() + "\t" + i.getCodigo() + "\t" + i.getDescricao() + "\t" + i.getQtde() + "\t" + i.getPreco());
		}

		sb.append("\n\n---- Somatórios ---- ");
		sb.append("\nValor em pecas: " + getTotalPecas()); 
		sb.append("\nValor em servicos: " + getTotalServico()); 
		
		DecimalFormat formatador = new DecimalFormat("#.##"); // Limita a 2 casas decimais
		String stringFormatada = formatador.format(getTotalOS());
		
		sb.append("\nValor total: " + stringFormatada); 
		
		if(cliente.isPlatinum() == true) {
			sb.append("\nValor total com desconto: " + (getTotalOS() - getTotalServico())); 
		}
		
		sb.append("\nForma de pagamento: " + pagamento.getTipoPagamento());
		sb.append("\nVencimento: " + pagamento.getVencimento());

		return sb;
		
	}
}
