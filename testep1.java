package main;

import classes.Advogado;
import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import classes.Processo;
import classes.Tribunal;
import enums.EFaseProcesso;
import exceptions.AdvogadoException;
import exceptions.AudienciaException;
import exceptions.DespesaException;
import exceptions.PessoaFisicaException;
import exceptions.PessoaJuridicaException;
import exceptions.ProcessoException;
import exceptions.TribunalException;

public class testep1 {

	public static void main(String[] args) {
		Pessoa p1 = null; 
		try {
			p1 = new PessoaFisica("Joao", "ja@mn", "987654321", "12987654321");
		} catch (PessoaFisicaException e) {
			System.err.println(e.getMessage());
		}
		
		Pessoa p2 = null;
		try {
			p2 = new PessoaJuridica("AbatAves", "mi@mn", "123456789", "1234567899876", (PessoaFisica)p1);
		} catch (PessoaJuridicaException e) {
			System.err.println(e.getMessage());
		}
		
		Pessoa p3 = null;
		try {
			p3 = new PessoaFisica("Caroline", "Ca@mn", "123456789", "12345678998");
		} catch (PessoaFisicaException e) {
			System.err.println(e.getMessage());
		}
		
		Advogado a1 = null;
		try {
			a1 = new Advogado((PessoaFisica)p3, "111111"); //Deve perder um "1" para quebrar;
		} catch (AdvogadoException e) {
			System.err.println(e.getMessage());
		}
		
		Advogado a2 = null;
		try {
			a2 = new Advogado(new PessoaFisica("Mario", "Ma@mn", "147852369", "14785236987"), "111111"); //Deve perder um "1" para quebrar;
		} catch (AdvogadoException e) {
			System.err.println(e.getMessage());
		}
		catch (PessoaFisicaException e) {
			System.err.println(e.getMessage());
		}
		
		Tribunal t1 = null;
		try {
			t1 = new Tribunal("T1", "Tribunal da corte", "Criminal");
		} catch (TribunalException e) {
			System.err.println(e.getMessage());
		}
		
		Processo pro1 = null;
		try {
			pro1 = new Processo(p1, p2, t1, 10, EFaseProcesso.INICIAL);
		} catch (ProcessoException e) {
			System.err.println(e.getMessage());
		}
		
		if(pro1 != null) {
			
			try {
				pro1.addAudiencia(a1, "Teste123");
			} catch (AudienciaException e) {
				System.err.println(e.getMessage());
			}
			
			try {
				pro1.addAudiencia(a1, "Teste321");
			} catch (AudienciaException e) {
				System.err.println(e.getMessage());
			}	
			
			try {
				pro1.addCusta("Auxiliar1", 20.50);
			} catch (DespesaException e) {
				System.err.println(e.getMessage());
			}
			
			try {
				pro1.addCusta("Auxiliar2", 50.51);
			} catch (DespesaException e) {
				System.err.println(e.getMessage());
			}
			
			System.out.println("------------------------------\n" + "-- Listagem do processo: " + pro1.getNumero() + " --\n------------------------------\n");
			System.out.println(pro1.toString());
			try {
				System.out.println(pro1.getAudiencias());
			} catch (AudienciaException e) {
				System.err.println(e.getMessage());
			}
			System.out.println(pro1.getCustas());
			System.out.println("\t\t       Total: " + pro1.getTotalCustas2() + "\n");
			System.out.println("------------------------------\n" + "------ Fim da Listagem  ------\n------------------------------\n");
		}

	}

}
