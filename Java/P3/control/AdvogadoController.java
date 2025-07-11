package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Advogado;
import classes.PessoaFisica;
import dtos.AdvogadoDto;
import exceptions.AdvogadoException;
import exceptions.PessoaException;
import exceptions.RegistroException;
import valueObjects.Registro;

public class AdvogadoController implements Serializable {
	
	private static final long serialVersionUID = 7454453483541220525L;
	
	HashMap<String, Advogado> advogados = new HashMap<String, Advogado>();
	
	public void addAdvogado(AdvogadoDto advogado, PessoaController personControl) throws AdvogadoException, PessoaException, RegistroException{
		PessoaFisica pessoa = (PessoaFisica) personControl.getPessoaController(advogado.getCadastroRF());
		Advogado a = new Advogado (pessoa, Registro.valueOf(advogado.getRegistro()));
		advogados.put(a.getRegistro(), a);
		MainController.save();
	}

	public List<AdvogadoDto> ListarAdvogados() {
		ArrayList<Advogado> advogs = new ArrayList<>(advogados.values());
		ArrayList<AdvogadoDto> dtos = new ArrayList<>();
		AdvogadoDto ad = null;

		for (Advogado a : advogs) {
			ad = new AdvogadoDto(a.getNome(), a.getCadastroRF(), a.getRegistro());
			dtos.add(ad);
		}
		return dtos;
	}
	
	//Não é usado!
	public List<Advogado> ListarAdvogados2(){
		 return new ArrayList<>(advogados.values());
	}
	
	public AdvogadoDto getAdvogado(String registro) throws AdvogadoException {
		Advogado a = advogados.get(registro);
		AdvogadoDto ad = new AdvogadoDto(a.getNome(), a.getCadastroRF(), a.getRegistro());
		if (a == null || ad == null)
			throw new AdvogadoException("Advogado informado não está cadastrado!");
		return ad;
	}
	
	public Advogado getAdvogadoController(String registro) throws AdvogadoException {
		Advogado a = advogados.get(registro);		
		if (a == null)
			throw new AdvogadoException("Advogado informado não está cadastrado!");
		return a;
	}
	
	//Não tem pq atualizar advogados, seus registro não muda e seu cpf tbm não. Sua mudança se dá pela pessoa fisica;
	public void DeleteAdvogado(String Registro) throws RegistroException {
		
	}
	
}
