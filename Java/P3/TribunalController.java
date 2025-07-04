package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Tribunal;
import dtos.TribunalDto;
import exceptions.TribunalException;
import valueObjects.Secao;
import valueObjects.Sigla;

public class TribunalController {
	
	HashMap<String, Tribunal> tribunais = new HashMap<String, Tribunal>();
	//private List<Tribunal> tribunais = new ArrayList<Tribunal>();
	
	public void addTribunal (TribunalDto tribunal) throws TribunalException{
		Tribunal t = new Tribunal (Sigla.valueOf(tribunal.getSigla()), tribunal.getDescricao(), Secao.valueOf(tribunal.getSecao()));
		tribunais.put(t.getSigla(), t);
	}
	
	public String ListarTribunais(){
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : tribunais.keySet()) {
			sb.append("Sigla: " + s + "Nome: " + tribunais.get(s).getDescricao() + "\n");
		}
		
		return ("Listagem dos Tribunais:\n" + sb.toString());
	}
	
	public List<Tribunal> ListarTribunais2(){
		 return new ArrayList<>(tribunais.values());
	}
	
	public List<TribunalDto> ListarTribunais3(){
		ArrayList<Tribunal> tribus = new ArrayList<>(tribunais.values());
		ArrayList<TribunalDto> dtos = new ArrayList<>();
		TribunalDto td = null;
		
		for( Tribunal t : tribus){
			td = new TribunalDto(t.getSigla(), t.getDescricao(), t.getSecao());
			dtos.add(td);
		}
		 return dtos;
	}
	
	public TribunalDto getTribunal(String sigla) throws TribunalException {
		Tribunal t = tribunais.get(sigla);
		TribunalDto td = new TribunalDto (t.getSigla(), t.getDescricao(), t.getSecao());
		if(t == null || td == null)
			throw new TribunalException("Tribunal não encontrado!");
		return td;
	}
	
	public Tribunal getTribunalController(String sigla) throws TribunalException {
		Tribunal t = tribunais.get(sigla);
		if(t == null)
			throw new TribunalException("Tribunal não encontrado!");
		return t;
	}
	
}
