package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dtos.PessoaJuridicaDto;

public class ListagemPessoaJuridicaView extends JFrame {

	private static final long serialVersionUID = 3400511787213482944L;

	public ListagemPessoaJuridicaView(List<PessoaJuridicaDto> pessoas) {		
        super("Listagem de Pessoas Juridicas");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 250);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Registro", "Telefone", "Email", "Registro Preposto", "Nome Preposto"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (PessoaJuridicaDto p : pessoas) {
            Object[] linha = { p.getNome(), p.getCadastroRF(), p.getTelefone(), p.getEmail(), p.getPrepostoCadastro(), p.getPrepostoNome()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        tabela.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }
}
