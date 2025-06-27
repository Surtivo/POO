package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Advogado;

public class ListaAdvogadoView extends JFrame {

	private static final long serialVersionUID = -9192432026356077283L;

	public ListaAdvogadoView(List<Advogado> advogados) {
        super("Listagem de Advogados");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Registro"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Advogado a : advogados) {
            Object[] linha = { a.getNome(), a.getRegistro()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}