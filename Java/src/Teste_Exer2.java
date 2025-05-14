import Exercicio2.*;

public class Teste_Exer2 {
    public static void main(String [] args){
        Cliente c1 = new Cliente(111111, "Joao", "12349873", "jao@feio");
        Veiculo v1 = new Veiculo("7J1HN", 2021, "AMARELO", c1, new Modelo("F0"));  
        Funcionario f1 = new Funcionario (22222, "Musa", "9875789", "func@revo", 876989);
        
        Item trocaOleo = new Item(ETipoItem.SERVICO, 98668, "Troca de oleo", 98.4);
        Item Pneu = new Item(ETipoItem.PECA, 18669, "Troca de pneu", 51.4);
        Item trocaPneu = new Item(ETipoItem.SERVICO, 98669, "Troca de pneu", 91.4);
        
        OrdemServico os1 = new OrdemServico (99, "Manutencao", c1, f1, v1);
        os1.addItem(Pneu, 1);
        os1.addItem(trocaPneu, 1);
        os1.addItem(trocaOleo, 1);
        
        Pagamento pag1 = new Pagamento(EPagamento.PIX, os1.getTotalOS());
        
        os1.setPagamento(pag1);
        System.out.println(os1.listaOS());
    }  
}