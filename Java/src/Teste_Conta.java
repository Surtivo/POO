import Contas.*;

public class Teste_Conta{
	public static void main(String[] args) {
		Conta c1 = new Conta(1, new Cliente("123456789", "Emanuel Cabral"));
		c1.getTitular();
		c1.Depositar(1000.50);
		c1.Sacar(10.50);
		System.out.println(c1.listarextrato());
	}
}

