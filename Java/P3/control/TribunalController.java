package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Tribunal;
import exceptions.TribunalException;
import valueObjects.Secao;
import valueObjects.Sigla;

public class TribunalController {
	
	HashMap<String, Tribunal> tribunais = new HashMap<String, Tribunal>();
	//private List<Tribunal> tribunais = new ArrayList<Tribunal>();
	
	public void addTribunal (Sigla sigla, String nome, Secao secao) throws TribunalException{
		Tribunal t = new Tribunal (sigla, nome, secao);
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
	
	public Tribunal getTribunal(String sigla) throws TribunalException {
		Tribunal t = tribunais.get(sigla);
		if(t == null)
			throw new TribunalException("Tribunal não encontrado!");
		return t;
	}
	
}
