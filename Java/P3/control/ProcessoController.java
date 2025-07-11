package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Advogado;
import classes.Audiencia;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import classes.Processo;
import classes.Tribunal;
import dtos.AudienciaDto;
import dtos.CustaDto;
import dtos.ProcessoDto;
import dtos.ProcessoDtoCompleto;
import enums.EFaseProcesso;
import exceptions.AdvogadoException;
import exceptions.AudienciaException;
import exceptions.DespesaException;
import exceptions.NumProcException;
import exceptions.PessoaException;
import exceptions.ProcessoException;
import exceptions.SiglaException;
import util.NumProcUtil;
import valueObjects.NumProc;

public class ProcessoController implements Serializable{
	
	private static final long serialVersionUID = -4447849391367646853L;
	
	HashMap<String, Processo> processos = new HashMap<String, Processo>();
	
	public void addProcesso(ProcessoDto processo, PessoaController PersonControl, TribunalController TribunalControl) throws ProcessoException, NumProcException, PessoaException, SiglaException{
		PessoaFisica p1 = (PessoaFisica) PersonControl.getPessoaController((processo.getRegistroCliente()));
		PessoaJuridica p2 = (PessoaJuridica) PersonControl.getPessoaController((processo.getRegistroParteContraria()));
		Tribunal t = TribunalControl.getTribunalController(processo.getTribunal());
		Processo p = new Processo (p1, p2, t, NumProc.valueOf(processo.getNumeroProc()), EFaseProcesso.valueOf(processo.getFase().toUpperCase()));
		processos.put(p.getNumero(), p);
		MainController.save();
	}

	//Tem que refazer;
	public List<ProcessoDto> ListarProcessos(){
		List<Processo> lista_processos =  new ArrayList<>(processos.values());
		List<ProcessoDto> lista_pessoas_processosDto =  new ArrayList<>();
		
		for(Processo p : lista_processos) {
			if(NumProcUtil.validateNumero(p.getNumero())) {
				ProcessoDto Pdto = new ProcessoDto(p.getCliente().getCadastroRF(), p.getParteContraria().getCadastroRF(), p.getTribunal().getSigla(), p.getNumero(), p.getFase().toString());
				lista_pessoas_processosDto.add(Pdto);
			}
		}
		return lista_pessoas_processosDto;
	}

	
	public void addAudiencia (String IDprocesso, Advogado advogado, String recomendacao) throws AudienciaException {
		Processo p = processos.get(IDprocesso);
		p.addAudiencia(advogado, recomendacao);
	}
	
	public void addAudienciaDto (AudienciaDto audiencia, AdvogadoController AdvogadoControl) throws AudienciaException, AdvogadoException {
		Processo p = processos.get(audiencia.getIDprocesso());
		if(p == null)
			throw new AudienciaException("Processo informado não está cadastrado!");
		Advogado a = AdvogadoControl.getAdvogadoController(audiencia.getAdvogado());
		if(a == null)
			throw new AudienciaException("Advogado informado não está cadastrado!");
		p.addAudiencia(a, audiencia.getRecomendacao());
		MainController.save();
	}

	public void addCusta(String IDprocesso, String descricao, double valor) throws DespesaException {
		Processo p = processos.get(IDprocesso);
		p.addCusta(descricao, valor);
	}
	
	public void addCustaDto(CustaDto custa) throws DespesaException, NumberFormatException {
		Processo p = processos.get(custa.getId());
		if(p == null)
			throw new DespesaException("Processo informado não está cadastrado!");
		double valorDouble = Double.parseDouble(custa.getValor());
		p.addCusta(custa.getMotivo(), valorDouble);
		MainController.save();
	}

	public Processo getProcesso(String numero) throws NumProcException {
		Processo p = processos.get(numero); 
		if(p == null)
			throw new NumProcException("Processo informado não está cadastrado!");
		return p;
	}
	
//	Não é usado!
//	public Processo getProcessoDto(String numero) throws ProcessoException {
//		Processo p = processos.get(numero); 
//		if(p == null)
//			throw new ProcessoException("Processo informado não está cadastrado!");
//		return p;
//	}
	
	public ArrayList<AudienciaDto> getAudienciasDto(String IDprocesso) throws AudienciaException {
		ArrayList<AudienciaDto> adtos = new ArrayList<>();
		Processo p = processos.get(IDprocesso);
		if(p == null)
			throw new AudienciaException("Processo informado não está cadastrado!");
		for(Audiencia a : p.getAudiencias()) {
			AudienciaDto ad = new AudienciaDto(p.getNumero(), a.getAdvogado().getRegistro(), a.getRecomendacao());
			adtos.add(ad);
		}
		
		return adtos;
	}
	
	public ProcessoDtoCompleto getFullProcesso (String IDprocesso)  throws NumProcException{
		Processo p = processos.get(IDprocesso);
		if(p == null)
			throw new NumProcException("Processo informado não está cadastrado!");
		ProcessoDtoCompleto PC = new ProcessoDtoCompleto(
				p.getCliente().getCadastroRF(), p.getCliente().getNome(), p.getParteContraria().getCadastroRF(), 
				p.getParteContraria().getNome(), p.getTribunal().getSigla(), p.getTribunal().getDescricao(), p.getNumero(), 
				p.getDataAbertura().toString(), p.getFase().toString());
		return PC;
	}
	
	public void AtualizarFaseProcesso(String IDprocesso, String fase) throws NumProcException {
		Processo p = this.getProcesso(IDprocesso);
		p.setFase(EFaseProcesso.valueOf(fase.toUpperCase()));		
	}
	
	public void DeleteProcesso(String numero) throws NumProcException {
		//Ainda não sei como deve ser feito;
	}
	
}
