package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Tribunal;

public class ListaTribunalView extends JFrame {

	private static final long serialVersionUID = -3238342338095959012L;

	public ListaTribunalView(List<Tribunal> tribunais) {
        super("Listagem de Tribunais");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Sigla", "Seção"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Tribunal t : tribunais) {
            Object[] linha = { t.getDescricao(), t.getSigla(), t.getSecao()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}
