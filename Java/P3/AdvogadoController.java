package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Advogado;
import classes.PessoaFisica;
import dtos.AdvogadoDto;
import exceptions.AdvogadoException;
import exceptions.PessoaException;
import valueObjects.Registro;

public class AdvogadoController {
	
	HashMap<String, Advogado> advogados = new HashMap<String, Advogado>();
	
	public void addAdvogado(AdvogadoDto advogado, PessoaController personControl) throws AdvogadoException, PessoaException{
		PessoaFisica pessoa = (PessoaFisica) personControl.getPessoaController(advogado.getCadastroRF());
		Advogado a = new Advogado (pessoa, Registro.valueOf(advogado.getRegistro()));
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
	
	public AdvogadoDto getAdvogado(String registro) throws AdvogadoException {
		Advogado a = advogados.get(registro);
		AdvogadoDto ad = new AdvogadoDto(a.getCadastroRF(), a.getRegistro());
		if (a == null || ad == null)
			throw new AdvogadoException("Advogado informado não está cadastrado!");
		return ad;
	}
	
}
