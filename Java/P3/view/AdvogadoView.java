package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.AdvogadoController;
import control.PessoaController;
import dtos.AdvogadoDto;
import exceptions.AdvogadoException;
import exceptions.PessoaException;
import exceptions.RegistroException;

public class AdvogadoView extends JFrame {
	private static final long serialVersionUID = 3067065872864162544L;

	private PessoaController PersonControl;
	private AdvogadoController AdvogadoControl;
	private JTextField cpfTxt;
	private JTextField registroTxt;

	public AdvogadoView(PessoaController PersonControl, AdvogadoController AdvogadoControl) {
		super("Cadastro de Advogado");

		this.PersonControl = PersonControl;
		this.AdvogadoControl = AdvogadoControl;

		setSize(300, 125);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		registroTxt = new JTextField();
		cpfTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Registro:"));
		panel.add(registroTxt);

		panel.add(new JLabel("CPF:"));
		panel.add(cpfTxt);

		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(e -> actionSalvar());

		panel.add(salvar);

		add(panel);
	}

	private void actionSalvar() {
		String registro = registroTxt.getText();
		String cpf = cpfTxt.getText();

		AdvogadoDto advogado = new AdvogadoDto(cpf, registro);

		try {
			this.AdvogadoControl.addAdvogado(advogado, this.PersonControl);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (PessoaException | AdvogadoException | RegistroException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar advogado! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
}