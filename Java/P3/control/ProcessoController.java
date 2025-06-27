package control;

import java.util.HashMap;

import classes.Advogado;
import classes.Pessoa;
import classes.Processo;
import classes.Tribunal;
import enums.EFaseProcesso;
import exceptions.AudienciaException;
import exceptions.DespesaException;
import exceptions.ProcessoException;
import valueObjects.NumProc;

public class ProcessoController {
	
	HashMap<String, Processo> processos = new HashMap<String, Processo>();
	
	public void addProcesso(Pessoa cliente, Pessoa parteContraria, Tribunal tribunal, NumProc numero, EFaseProcesso fase) throws ProcessoException{
		Processo p = new Processo (cliente, parteContraria, tribunal, numero, fase);
		processos.put(p.getNumero(), p);
	}

	public String ListarProcessos(){
		StringBuilder sb = new StringBuilder();
		
		for(String s : processos.keySet()) {
			sb.append("Número do Processo: " + s + " - Data: " + processos.get(s).getDataAbertura()+ "- Fase: " +  processos.get(s).getFase() + "\n");
		}
		
		return ("Listagem dos Processos:\n" + sb.toString());
	}
	
	public void addAudiencia (String IDprocesso, Advogado advogado, String recomendacao) throws AudienciaException {
		Processo p = processos.get(IDprocesso);
		p.addAudiencia(advogado, recomendacao);
	}

	public void addCusta(String IDprocesso, String descricao, double valor) throws DespesaException {
		Processo p = processos.get(IDprocesso);
		p.addCusta(descricao, valor);
	}

	public Processo getProcesso(String numero) throws ProcessoException {
		Processo p = processos.get(numero); 
		if(p == null)
			throw new ProcessoException("Processo informado não está cadastrado!");
		return p;
	}
}
