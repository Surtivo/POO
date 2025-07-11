//package main;
//
//import classes.PessoaFisica;
//import classes.Processo;
//import control.AdvogadoController;
//import control.PessoaController;
//import control.ProcessoController;
//import control.TribunalController;
//import enums.EFaseProcesso;
//import exceptions.AdvogadoException;
//import exceptions.AudienciaException;
//import exceptions.DespesaException;
//import exceptions.PessoaException;
//import exceptions.ProcessoException;
//import exceptions.TribunalException;
//import valueObjects.Cnpj;
//import valueObjects.Cpf;
//import valueObjects.Email;
//import valueObjects.NumProc;
//import valueObjects.Registro;
//import valueObjects.Secao;
//import valueObjects.Sigla;
//import valueObjects.Telefone;
//
//public class teste2 {
//
//	public static void main(String[] args) {
//		PessoaController PersonControl = new PessoaController();
//		
//		//Pessoa p1 = null; 
//		try {
//			PersonControl.addPessoa("Joao", Email.valueOf("ja@mn"), Telefone.valueOf("(12)987654321"), Cpf.valueOf("12987654321"));
//		} catch (PessoaException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		//Pessoa p2 = null;
//		try {
//			PersonControl.addPessoa("AbatAves", Email.valueOf("mi@mn"), Telefone.valueOf("12123456789"), Cnpj.valueOf("12345678998761"), (PessoaFisica)PersonControl.getPessoa("12987654321"));
//		} catch (PessoaException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		//Pessoa p3 = null;
//		try {
//			PersonControl.addPessoa("Caroline", Email.valueOf("Ca@mn"), Telefone.valueOf("12123456789"), Cpf.valueOf("12345678998"));
//		} catch (PessoaException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		AdvogadoController AdvogadoControl = new AdvogadoController();
//		//Advogado a1 = null;
//		try {
//			AdvogadoControl.addAdvogado((PessoaFisica) PersonControl.getPessoa("12345678998"), Registro.valueOf("111111")); //Deve perder ou ganhar um "1" para quebrar;
//		} catch (AdvogadoException e) {
//			System.err.println(e.getMessage());
//		} catch (PessoaException e1) {
//			System.err.println(e1.getMessage());
//		}
//		
//		//Advogado a2 = null;
//		try {
//			PersonControl.addPessoa("Mario", Email.valueOf("Ma@mn"), Telefone.valueOf("12147852369"), Cpf.valueOf("14785236987"));
//		} catch (PessoaException e) {
//			System.err.println(e.getMessage());
//		}
//		try {
//			AdvogadoControl.addAdvogado ((PessoaFisica) PersonControl.getPessoa("14785236987"), Registro.valueOf("222222")); //Deve perder um "1" para quebrar;
//		} catch (AdvogadoException e) {
//			System.err.println(e.getMessage());
//		} catch (PessoaException e1) {
//			System.err.println(e1.getMessage());
//		}
//		
//		TribunalController TribunalControl = new TribunalController();
//		try {
//			TribunalControl.addTribunal(Sigla.valueOf("TRT1"), "Tribunal Regional do Trabalho", Secao.valueOf("1"));
//		} catch (TribunalException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		ProcessoController ProcControl = new ProcessoController();
//		try {
//			ProcControl.addProcesso(PersonControl.getPessoa("12987654321"), PersonControl.getPessoa("12345678998761"), TribunalControl.getTribunal("TRT1"), NumProc.valueOf("10"), EFaseProcesso.INICIAL); 
//		} catch (ProcessoException e) {
//			System.err.println(e.getMessage());
//		} catch (PessoaException e1) {
//			System.err.println(e1.getMessage());
//		} catch (TribunalException e1) {
//			System.err.println(e1.getMessage());
//		}
//		
//		
//		try {
//			if(ProcControl.getProcesso("10") != null) {
//				
//				try {
//					ProcControl.getProcesso("10").addAudiencia(AdvogadoControl.getAdvogado("111111"), "Teste123");
//				} catch (AudienciaException e) {
//					System.err.println(e.getMessage());
//				} catch (AdvogadoException e1) {
//					System.err.println(e1.getMessage());
//				}
//				
//				Processo pro1 = ProcControl.getProcesso("10");
//				
//				try {
//					pro1.addAudiencia(AdvogadoControl.getAdvogado("111111"), "Teste321");
//				} catch (AudienciaException e) {
//					System.err.println(e.getMessage());
//				} catch (AdvogadoException e1) {
//					System.err.println(e1.getMessage());
//				}
//				
//				try {
//					pro1.addCusta("Auxiliar1", 20.50);
//				} catch (DespesaException e) {
//					System.err.println(e.getMessage());
//				}
//				
//				try {
//					pro1.addCusta("Auxiliar2", 50.51);
//				} catch (DespesaException e) {
//					System.err.println(e.getMessage());
//				}
//				
//				System.out.println("------------------------------\n" + "-- Listagem do processo: " + pro1.getNumero() + " --\n------------------------------\n");
//				System.out.println(pro1.toString());
//				try {
//					System.out.println(pro1.getAudiencias());
//				} catch (AudienciaException e) {
//					System.err.println(e.getMessage());
//				}
//				System.out.println(pro1.getCustas());
//				System.out.println("\t\t       Total: " + pro1.getTotalCustas2() + "\n");
//				System.out.println("------------------------------\n" + "------ Fim da Listagem  ------\n------------------------------\n");
//			}
//		} catch (ProcessoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//}
