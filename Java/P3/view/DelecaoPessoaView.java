package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.PessoaController;
import exceptions.CpfException;

public class DelecaoPessoaView extends JFrame {

	private static final long serialVersionUID = 6817817377582693526L;
	
	private PessoaController PersonControl;
	private JTextField cpfTxt;

	public DelecaoPessoaView(PessoaController PersonControl) {
		super("Deleção de Pessoa Física");

		this.PersonControl = PersonControl;

		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		cpfTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Informe o CPF/CNPJ da pessoa:"));
		panel.add(cpfTxt);

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(e -> actionDeletar());

		panel.add(deletar);

		add(panel);
	}

	private void actionDeletar() {
		String cpf = cpfTxt.getText();

		try {
			this.PersonControl.DeletePessoa(cpf);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (CpfException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao deletar pessoa! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
