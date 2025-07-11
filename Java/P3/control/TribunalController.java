package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Tribunal;
import dtos.TribunalDto;
import exceptions.NomeException;
import exceptions.SecaoException;
import exceptions.SiglaException;
import valueObjects.Secao;
import valueObjects.Sigla;

public class TribunalController implements Serializable{
	
	private static final long serialVersionUID = -8776864152765492070L;
	
	HashMap<String, Tribunal> tribunais = new HashMap<String, Tribunal>();
	//private List<Tribunal> tribunais = new ArrayList<Tribunal>();
	
	public void addTribunal (TribunalDto tribunal) throws NomeException, SiglaException, SecaoException{
		Tribunal t = new Tribunal (Sigla.valueOf(tribunal.getSigla()), tribunal.getDescricao(), Secao.valueOf(tribunal.getSecao()));
		tribunais.put(t.getSigla(), t);
		MainController.save();
	}
	
	public List<TribunalDto> ListarTribunais(){
		ArrayList<Tribunal> tribus = new ArrayList<>(tribunais.values());
		ArrayList<TribunalDto> dtos = new ArrayList<>();
		TribunalDto td = null;
		
		for( Tribunal t : tribus){
			td = new TribunalDto(t.getSigla(), t.getDescricao(), t.getSecao());
			dtos.add(td);
		}
		 return dtos;
	}
	
	public TribunalDto getTribunal(String sigla) throws SiglaException {
		Tribunal t = tribunais.get(sigla);
		TribunalDto td = new TribunalDto (t.getSigla(), t.getDescricao(), t.getSecao());
		if(t == null || td == null)
			throw new SiglaException("Tribunal não encontrado!");
		return td;
	}
	
	public Tribunal getTribunalController(String sigla) throws SiglaException {
		Tribunal t = tribunais.get(sigla);
		if(t == null)
			throw new SiglaException("Tribunal não encontrado!");
		return t;
	}
	
	public void DeletarTribunal(String sigla) throws SiglaException {
		//Não faz sentido deletar um tribunal referenciado em um processo, ele nunca será coletado pelo garbage colector. 
		//E se fosse processo perderia seu histórico.
		//O processo deveria ter um id do tribunal e não um objeto tribunal.
		//Deleção para casa de adição errada.
	}
	
	public void AtualizarTribunal(String sigla) throws SiglaException {
		//Não faz sentido atualizar um tribunal referenciado em um processo, processo perderia seu histórico.
		//O processo deveria ter um id do tribunal e não um objeto tribunal.
		//O processo apenas tem atributos final. Mesmo que apenas a sigla seja final, ele é montada com base no nome e seção;
	}
	
}
