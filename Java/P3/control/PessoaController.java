package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import exceptions.PessoaException;
import valueObjects.Cnpj;
import valueObjects.Cpf;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaController {
	
	HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	
	public void addPessoa(String nome, Email email, Telefone tel, Cpf cpf) throws PessoaException{
		Pessoa p = new PessoaFisica (nome, email, tel, cpf);
		pessoas.put(p.getCadastroRF(), p);
	}
	
	public void addPessoa(String nome, Email email, Telefone tel, Cnpj cnpj, PessoaFisica preposto) throws PessoaException{
		Pessoa p = new PessoaJuridica (nome, email, tel, cnpj, preposto);
		pessoas.put(p.getCadastroRF(), p);
	}

	public String ListarPessoas(){
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : pessoas.keySet()) {
			sb.append("Cadastro: " + s + " - Nome: " + pessoas.get(s).getNome() + "\n");
		}
		
		return ("Listagem das Pessoas:\n" + sb.toString());
	}
	
	public List<Pessoa> ListarPessoas2(){
		 return new ArrayList<>(pessoas.values());
	}
	
	public Pessoa getPessoa(String cadastro) throws PessoaException {
		Pessoa p = pessoas.get(cadastro);
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		return p;
	}
}
