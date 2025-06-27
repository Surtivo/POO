package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Pessoa;

public class ListagemPessoaView extends JFrame {

	private static final long serialVersionUID = 3400511787213482944L;

	public ListagemPessoaView(List<Pessoa> pessoas) {
        super("Listagem de Pessoas");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Registro"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Pessoa p : pessoas) {
            Object[] linha = { p.getNome(), p.getCadastroRF() };
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}
