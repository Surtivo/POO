package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dtos.PessoaFisicaDto;

public class ListagemPessoaFisicaView extends JFrame {

	private static final long serialVersionUID = 3400511787213482944L;

	public ListagemPessoaFisicaView(List<PessoaFisicaDto> pessoas) {
        super("Listagem de Pessoas Fisicas");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Registro", "Telefone", "Email"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (PessoaFisicaDto p : pessoas) {
            Object[] linha = { p.getNome(), p.getCadastroRF(), p.getTelefone(), p.getEmail() };
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        tabela.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}
