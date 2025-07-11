package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ProcessoController;
import exceptions.NumProcException;

public class DelecaoProcessoView extends JFrame {

	private static final long serialVersionUID = -716019612545585245L;
	
	private ProcessoController ProcessoControl;
	private JTextField numeroTxt;

	public DelecaoProcessoView(ProcessoController ProcessoControl) {
		super("Deleção de Processo");

		this.ProcessoControl = ProcessoControl;

		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		numeroTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Informe a o numero do processo:"));
		panel.add(numeroTxt);

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(e -> actionDeletar());

		panel.add(deletar);

		add(panel);
	}

	private void actionDeletar() {
		String numero = numeroTxt.getText();

		try {
			this.ProcessoControl.DeleteProcesso(numero);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (NumProcException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao deletar tribunal! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
