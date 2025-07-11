package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.AdvogadoController;
import exceptions.RegistroException;

public class DelecaoAdvogadoView extends JFrame {

	private static final long serialVersionUID = 8465316631206369684L;
	
	private AdvogadoController AdvogadoControl;
	private JTextField registroTxt;

	public DelecaoAdvogadoView(AdvogadoController AdvogadoControl) {
		super("Deleção de Advogado");

		this.AdvogadoControl = AdvogadoControl;

		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		registroTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Informe o registro do advogado:"));
		panel.add(registroTxt);

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(e -> actionDeletar());

		panel.add(deletar);

		add(panel);
	}

	private void actionDeletar() {
		String registro = registroTxt.getText();

		try {
			this.AdvogadoControl.DeleteAdvogado(registro);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (RegistroException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao deletar advogado! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
