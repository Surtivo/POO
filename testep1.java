import Prova.Advogado;
import Prova.EFaseProcesso;
import Prova.Pessoa;
import Prova.PessoaFisica;
import Prova.PessoaJuridica;
import Prova.Processo;
import Prova.Tribunal;
import Prova.Exceptions.PessoaFisicaException;
import Prova.Exceptions.PessoaJuridicaException;

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
		Advogado p3 = null;
		try {
			p3 = new Advogado("Maria", "ma@mn", "123456789", "12345678998", "11111");
		} catch (PessoaFisicaException e) {
			System.err.println(e.getMessage());
		}
		Tribunal t1 = new Tribunal("T1", "Tribunal da corte", "Criminal");
		
		Processo pro1 = new Processo(p1, p2, t1, 10, EFaseProcesso.INICIAL);
		pro1.addAudiencia(p3, "Teste123");
		pro1.addAudiencia(p3, "Teste321");
		pro1.addCusta("Auxiliar1", 20.50);
		pro1.addCusta("Auxiliar2", 50.51);
		pro1.getTotalCustas();
		
		System.out.println("------------------------------\n" + "-- Listagem do processo: " + pro1.getNumero() + " --\n------------------------------\n");
		System.out.println(pro1.toString());
		System.out.println(pro1.getAudiencias());
		System.out.println(pro1.getCustas());
		System.out.println("\t\tTotal: " + pro1.getTotalCustas() + "\n");
		System.out.println("------------------------------\n" + "------ Fim da Listagem  ------\n------------------------------\n");

	}

}
