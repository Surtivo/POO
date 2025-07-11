package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.PessoaController;
import dtos.PessoaFisicaDto;
import exceptions.CpfException;
import exceptions.EmailException;
import exceptions.NomeException;
import exceptions.PessoaException;
import exceptions.TelefoneException;

public class CadastroFisicoView extends JFrame {
	private static final long serialVersionUID = 3067065872864162544L;

	private PessoaController PersonControl;
	private JTextField nomeTxt;
	private JTextField emailTxt;
	private JTextField telefoneTxt;
	private JTextField cpfTxt;

	public CadastroFisicoView(PessoaController PersonControl) {
		super("Cadastro de Pessoa Física");

		this.PersonControl = PersonControl;

		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		nomeTxt = new JTextField();
		emailTxt = new JTextField();
		telefoneTxt = new JTextField();
		cpfTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));

		panel.add(new JLabel("Nome: "));
		panel.add(nomeTxt);

		panel.add(new JLabel("Email:"));
		panel.add(emailTxt);

		panel.add(new JLabel("Telefone:"));
		panel.add(telefoneTxt);

		panel.add(new JLabel("CPF:"));
		panel.add(cpfTxt);

		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(e -> actionSalvar());

		JButton atualizar = new JButton("Atualizar");
		atualizar.addActionListener(e -> actionAtualizar());

		panel.add(salvar);
		panel.add(atualizar);

		add(panel);
	}

	private void actionSalvar() {
		String nome = nomeTxt.getText();
		String email = emailTxt.getText();
		String telefone = telefoneTxt.getText();
		String cpf = cpfTxt.getText();

		PessoaFisicaDto pessoa = new PessoaFisicaDto(nome, cpf, email, telefone);

		try {
			this.PersonControl.addPessoaFisica(pessoa);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (NomeException | EmailException | TelefoneException | CpfException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAtualizar() {
		String nome = nomeTxt.getText();
		String email = emailTxt.getText();
		String telefone = telefoneTxt.getText();
		String cpf = cpfTxt.getText();

		PessoaFisicaDto pessoa = new PessoaFisicaDto(nome, cpf, email, telefone);

		try {
			this.PersonControl.AtualizarCadastroFisico(pessoa);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (NomeException | EmailException | TelefoneException | PessoaException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

}