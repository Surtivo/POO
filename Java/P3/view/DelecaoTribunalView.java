package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.TribunalController;
import exceptions.SiglaException;

public class DelecaoTribunalView extends JFrame {

	private static final long serialVersionUID = -6002852120509459308L;
	
	private TribunalController TribunalControl;
	private JTextField siglaTxt;

	public DelecaoTribunalView(TribunalController TribunalControl) {
		super("Deleção de Tribunal");

		this.TribunalControl = TribunalControl;

		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		siglaTxt = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Informe a sigla do tribunal:"));
		panel.add(siglaTxt);

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(e -> actionDeletar());

		panel.add(deletar);

		add(panel);
	}

	private void actionDeletar() {
		String sigla = siglaTxt.getText();

		try {
			this.TribunalControl.DeletarTribunal(sigla);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (SiglaException e1) {
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao deletar tribunal! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
