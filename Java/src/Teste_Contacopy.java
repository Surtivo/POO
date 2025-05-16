import Contas.copy.*;

public class Teste_Contacopy{
	public static void main(String[] args) {
		Cliente c1 = new Cliente("123456789", "Emanuel Cabral");
		Agencia a1 = new Agencia();
		Conta co1 = a1.abrirConta(c1);
		
		co1.depositar(2900);
		
		System.out.println(co1.listarExtrato());
		
		System.out.println("Saldo Agencia: " + a1.getCodigo() + "\t " + a1.getSaldoAgencia());
		
	}
}