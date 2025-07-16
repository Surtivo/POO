package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dtos.ProcessoDto;

public class ListagemProcessosView extends JFrame {

	private static final long serialVersionUID = 224238595361231789L;

	public ListagemProcessosView(List<ProcessoDto> processos) {
        super("Listagem de Processos");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Número", "Fase", "Tribunal", "Cliente", "Parte Contraria"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (ProcessoDto p : processos) {
            Object[] linha = { p.getNumeroProc(), p.getFase(), p.getTribunal(), p.getRegistroCliente(), p.getRegistroParteContraria()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        tabela.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}
