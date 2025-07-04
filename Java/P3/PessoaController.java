package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import dtos.PessoaFisicaDto;
import dtos.PessoaJuridicaDto;
import exceptions.PessoaException;
import valueObjects.Cnpj;
import valueObjects.Cpf;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaController {
	
	HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	
	public void addPessoaFisica(PessoaFisicaDto pessoa) throws PessoaException{
		
		String nome = pessoa.getNome();
		Email email = Email.valueOf(pessoa.getEmail());
		Telefone telefone = Telefone.valueOf(pessoa.getTelefone());
		Cpf cpf = Cpf.valueOf(pessoa.getCadastroRF());
		
		Pessoa p = new PessoaFisica (nome, email, telefone, cpf);
		pessoas.put(p.getCadastroRF(), p);
	}
	
	public void addPessoaJuridica(PessoaJuridicaDto pessoa, PessoaFisicaDto preposto) throws PessoaException{
		String nome = pessoa.getNome();
		Email email = Email.valueOf(pessoa.getEmail());
		Telefone telefone = Telefone.valueOf(pessoa.getTelefone());
		Cnpj cnpj = Cnpj.valueOf(pessoa.getCadastroRF());
		
		PessoaFisica pessoaPreposto = (PessoaFisica) this.getPessoaController(preposto.getCadastroRF());
		
		Pessoa p = new PessoaJuridica (nome, email, telefone, cnpj, pessoaPreposto);
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
	
	public PessoaFisicaDto getPessoa(String cadastro) throws PessoaException {
		Pessoa p = pessoas.get(cadastro);
		PessoaFisicaDto pd = new PessoaFisicaDto (p.getNome(), p.getCadastroRF(), p.getEmail(), p.getTel());
		if (p == null || pd == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		return pd;
	}
	
	public Pessoa getPessoaController(String cadastro) throws PessoaException {
		Pessoa p = pessoas.get(cadastro);
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		return p;
	}
}
