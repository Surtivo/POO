package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Advogado;
import classes.PessoaFisica;
import exceptions.AdvogadoException;
import valueObjects.Registro;

public class AdvogadoController {
	
	HashMap<String, Advogado> advogados = new HashMap<String, Advogado>();
	
	public void addAdvogado(PessoaFisica pessoa, Registro registro) throws AdvogadoException{
		Advogado a = new Advogado (pessoa, registro);
		advogados.put(a.getRegistro(), a);
	}

	public String ListarAdvogados(){
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : advogados.keySet()) {
			sb.append("Registro: " + s + " Nome: " + advogados.get(s).getNome() + "\n");
		}
		
		return ("Listagem dos Advogados:\n" + sb.toString());
	}
	
	public List<Advogado> ListarAdvogados2(){
		 return new ArrayList<>(advogados.values());
	}
	
	public Advogado getAdvogado(String registro) throws AdvogadoException {
		Advogado a = advogados.get(registro);
		if (a == null)
			throw new AdvogadoException("Advogado informado não está cadastrado!");
		return a;
	}
}
