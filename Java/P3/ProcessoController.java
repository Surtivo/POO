package control;

import java.util.HashMap;

import classes.Advogado;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import classes.Processo;
import classes.Tribunal;
import dtos.PessoaFisicaDto;
import dtos.ProcessoDto;
import dtos.TribunalDto;
import enums.EFaseProcesso;
import exceptions.AudienciaException;
import exceptions.DespesaException;
import exceptions.PessoaException;
import exceptions.ProcessoException;
import exceptions.TribunalException;
import valueObjects.NumProc;

public class ProcessoController {
	
	HashMap<String, Processo> processos = new HashMap<String, Processo>();
	
	public void addProcesso(PessoaFisicaDto cliente, PessoaFisicaDto parteContraria, TribunalDto tribunal, String numero, EFaseProcesso fase, PessoaController PersonControl, TribunalController TribunalControl) throws ProcessoException, PessoaException, TribunalException{
		PessoaFisica p1 = (PessoaFisica) PersonControl.getPessoaController((cliente.getCadastroRF()));
		PessoaJuridica p2 = (PessoaJuridica) PersonControl.getPessoaController((parteContraria.getCadastroRF()));
		Tribunal t = TribunalControl.getTribunalController(tribunal.getSigla());
		Processo p = new Processo (p1, p2, t, NumProc.valueOf(numero), fase);
		processos.put(p.getNumero(), p);
	}
	
	public void addProcesso(ProcessoDto processo) throws ProcessoException{
		PessoaFisica p1 = (PessoaFisica) PersonControl.getPessoaController((cliente.getCadastroRF()));
		PessoaJuridica p2 = (PessoaJuridica) PersonControl.getPessoaController((parteContraria.getCadastroRF()));
		Tribunal t = TribunalControl.getTribunalController(tribunal.getSigla());
		Processo p = new Processo (p1, p2, t, NumProc.valueOf(numero), fase);
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
