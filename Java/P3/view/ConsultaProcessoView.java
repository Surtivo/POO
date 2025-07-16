package view;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.MainController;

public class ConsultaProcessoView {
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;

	public static void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 20;
			c.ipadx = 150;
		}

		button = new JButton("Consultar por CPF/CNPJ do cliente");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> ConsultaCPF());
		pane.add(button, c);
		
		button = new JButton("Consultar por ID do processo");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> ConsultaID());
		pane.add(button, c);

	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Janela de Consulta");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void ConsultaCPF() {
		ListarProcessoCpfView ListarProcessoCpfView = new ListarProcessoCpfView (MainController.getProcessoController());
		ListarProcessoCpfView.setVisible(true);
	}
	
	public static void ConsultaID() {
		ListarProcessoView ListarProcessoView = new ListarProcessoView (MainController.getProcessoController());
		ListarProcessoView.setVisible(true);
	}	
}
