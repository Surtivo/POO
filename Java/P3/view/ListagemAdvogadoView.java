package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dtos.AdvogadoDto;

public class ListagemAdvogadoView extends JFrame {

	private static final long serialVersionUID = -9192432026356077283L;

	public ListagemAdvogadoView(List<AdvogadoDto> advogados) {
        super("Listagem de Advogados");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Cadastro", "Registro"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (AdvogadoDto a : advogados) {
            Object[] linha = {a.getNome(), a.getCadastroRF(), a.getRegistro()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        tabela.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}