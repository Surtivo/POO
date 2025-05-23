package Prova;
public class testep1 {

	public static void main(String[] args) {
		Pessoa p1 = new PessoaFisica("Joao", "ja@mn", 246842, 198654);
		Pessoa p2 = new PessoaJuridica("AbatAves", "mi@mn", 246842, 456891, (PessoaFisica)p1);
		Pessoa p3 = new Advogado("Maria", "ma@mn", 15795, 785412, 11111);
		Tribunal t1 = new Tribunal("T1", "Tribunal da corte", "Criminal");
		
		Processo pro1 = new Processo(p2, p3, t1, 10, EFaseProcesso.INICIAL);
		pro1.getAudiencia(p3, "Teste123");
		pro1.getAudiencia(p3, "Teste321");
		pro1.getCusta("Auxiliar1", 20.50);
		pro1.getCusta("Auxiliar2", 50.50);
		pro1.getTotalCustas();
		
		
		System.out.println(pro1.toString());
		System.out.println(pro1.getAudiencias());
		System.out.println(pro1.getCustas());
		System.out.println("\t\tTotal: " + pro1.getTotalCustas());

	}

}
