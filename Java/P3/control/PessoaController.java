package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Advogado;
import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import dtos.PessoaFisicaDto;
import dtos.PessoaJuridicaDto;
import exceptions.AdvogadoException;
import exceptions.AudienciaException;
import exceptions.CnpjException;
import exceptions.CpfException;
import exceptions.EmailException;
import exceptions.NomeException;
import exceptions.PessoaException;
import exceptions.RegistroException;
import exceptions.TelefoneException;
import util.CnpjUtil;
import util.CpfUtil;
import valueObjects.Cnpj;
import valueObjects.Cpf;
import valueObjects.Email;
import valueObjects.Telefone;

public class PessoaController implements Serializable {

	private static final long serialVersionUID = -844766153504022206L;
	
	HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	
	public void addPessoaFisica(PessoaFisicaDto pessoa) throws NomeException, EmailException, TelefoneException, CpfException{
		
		if(pessoas.containsKey(pessoa.getCadastroRF()))
			throw new CpfException("Já existe uma pessoa com esse cadastro!");
		
		String nome = pessoa.getNome();
		Email email = Email.valueOf(pessoa.getEmail());
		Telefone telefone = Telefone.valueOf(pessoa.getTelefone());
		Cpf cpf = Cpf.valueOf(pessoa.getCadastroRF());
		
		Pessoa p = new PessoaFisica (nome, email, telefone, cpf);
		pessoas.put(p.getCadastroRF(), p);
		MainController.save();
	}
	
	public void addPessoaJuridica(PessoaJuridicaDto pessoa, PessoaFisicaDto preposto) throws NomeException, EmailException, TelefoneException, CnpjException, PessoaException{
		
		if(pessoas.containsKey(pessoa.getCadastroRF()))
			throw new CnpjException("Já existe uma pessoa com esse cadastro!");
		
		String nome = pessoa.getNome();
		Email email = Email.valueOf(pessoa.getEmail());
		Telefone telefone = Telefone.valueOf(pessoa.getTelefone());
		Cnpj cnpj = Cnpj.valueOf(pessoa.getCadastroRF());
		
		PessoaFisica pessoaPreposto = (PessoaFisica) this.getPessoaController(preposto.getCadastroRF());
		
		Pessoa p = new PessoaJuridica (nome, email, telefone, cnpj, pessoaPreposto);
		pessoas.put(p.getCadastroRF(), p);
		MainController.save();
	}
	
	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas =  new ArrayList<Pessoa>(this.pessoas.values());
		return pessoas;
	}
		
	public List<PessoaFisicaDto> listarPessoasFisicas(){
		
		List<Pessoa> lista_pessoas =  new ArrayList<>(pessoas.values());
		List<PessoaFisicaDto> lista_pessoas_fisicas_dto =  new ArrayList<>();
		
		for(Pessoa p : lista_pessoas) {	
			if(CpfUtil.validateCpf(p.getCadastroRF())) {
				PessoaFisicaDto pDto = new PessoaFisicaDto(p.getNome(), p.getCadastroRF(), p.getEmail(), p.getTel());
				lista_pessoas_fisicas_dto.add(pDto);
			}
		}
		
		return lista_pessoas_fisicas_dto;
	}
	
	public List<PessoaJuridicaDto> listarPessoasJuridicas() {
		
//		Pessoa p = pessoas.get(pessoaJur.getCadastroRF());
		
		List<Pessoa> lista_pessoas=  new ArrayList<>(pessoas.values());
		List<PessoaJuridicaDto> lista_pessoas_juridicas_dto =  new ArrayList<>();
		
		for(Pessoa p : lista_pessoas) {
			if(CnpjUtil.validateCnpj(p.getCadastroRF())) {
				PessoaJuridica pj = (PessoaJuridica) p;
				PessoaFisica p1 = pj.getPreposto();
				PessoaFisicaDto PFdto = null;
				PessoaJuridicaDto PJdto = null;
				
				if(p1 == null)
					PJdto = new PessoaJuridicaDto(pj.getNome(), pj.getCadastroRF(), pj.getEmail(), pj.getTel(), null);
				
				else {
					PFdto = new PessoaFisicaDto(p1.getNome(), p1.getCadastroRF(), p1.getEmail(), p1.getTel());	
					PJdto = new PessoaJuridicaDto(pj.getNome(), pj.getCadastroRF(), pj.getEmail(), pj.getTel(), PFdto);
				}
				
				lista_pessoas_juridicas_dto.add(PJdto);
			}
		}
		
		return lista_pessoas_juridicas_dto;
	}
	
	public PessoaFisicaDto getPessoa(String cadastro) throws PessoaException {
		Pessoa p = pessoas.get(cadastro);
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		PessoaFisicaDto pd = new PessoaFisicaDto (p.getNome(), p.getCadastroRF(), p.getEmail(), p.getTel());
		return pd;
	}
	
	public Pessoa getPessoaController(String cadastro) throws PessoaException {
		Pessoa p = pessoas.get(cadastro);
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		return p;
	}
	
	public void AtualizarCadastroFisico(PessoaFisicaDto pessoa) throws PessoaException, EmailException, TelefoneException, NomeException {
		Pessoa p = pessoas.get(pessoa.getCadastroRF());
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		
		String nome = pessoa.getNome();
		Email email = Email.valueOf(pessoa.getEmail());
		Telefone telefone = Telefone.valueOf(pessoa.getTelefone());
		
		p.setEmail(email);
		p.setNome(nome);
		p.setTel(telefone);	
		MainController.save();		
	}
	
	public void AtualizarCadastroJuridico(PessoaJuridicaDto pessoaJur, PessoaFisicaDto preposto) throws PessoaException, EmailException, TelefoneException, NomeException {
		Pessoa p = pessoas.get(pessoaJur.getCadastroRF());
		if (p == null)
			throw new PessoaException("Pessoa informada não está cadastrada!");
		
		PessoaFisica pessoaPreposto = (PessoaFisica) this.getPessoaController(preposto.getCadastroRF());
		
		String nome = pessoaJur.getNome();
		Email email = Email.valueOf(pessoaJur.getEmail());
		Telefone telefone = Telefone.valueOf(pessoaJur.getTelefone());
		
		p.setEmail(email);
		p.setNome(nome);
		p.setTel(telefone);	
		PessoaJuridica pJur = (PessoaJuridica) p;
		pJur.setPreposto(pessoaPreposto);
		MainController.save();
	}
	
	//Não sei ainda como fazer;
	//Tem que verificar se ela não é um advogado!
	public void DeletePessoa(String cadastro, AdvogadoController AdvogadoControl, ProcessoController ProcessoControl) throws CpfException, RegistroException, AdvogadoException, AudienciaException {
		ArrayList<Advogado> advogs = AdvogadoControl.getAdvogados();
		List<Pessoa> peoples = this.getPessoas();
		
		for(Advogado a : advogs) {
			if (cadastro.equals(a.getCadastroRF())) {
				AdvogadoControl.DeleteAdvogado(a.getRegistro(), ProcessoControl);
			}
		}

		for(Pessoa p : peoples) {
			if(CnpjUtil.validateCnpj(p.getCadastroRF())) {
				PessoaJuridica pj = (PessoaJuridica) p;
				if(cadastro.equals(pj.getPreposto().getCadastroRF())){
					pj.setPreposto(null);
				}
			}
		}
		pessoas.remove(cadastro);
		MainController.save();
	}
}
