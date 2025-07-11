package view;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.MainController;

public class DelecaoView {
	
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

		button = new JButton("Deletar Pessoa");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> DeletarPessoa());
		pane.add(button, c);
		
		button = new JButton("Deletar Advogado");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> DeletarAdvogado());
		pane.add(button, c);
		
		button = new JButton("Deletar Tribunal");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> DeletarTribunal());
		pane.add(button, c);
		
		button = new JButton("Deletar Processo");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> DeletarProcesso());
		pane.add(button, c);

	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Janela de Deleção");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void DeletarPessoa() {
		DelecaoPessoaView DelecaoPessoaView = new DelecaoPessoaView (MainController.getPessoaController());
		DelecaoPessoaView.setVisible(true);
	}
	
	public static void DeletarAdvogado() {
		DelecaoAdvogadoView DelecaoAdvogadoView = new DelecaoAdvogadoView (MainController.getAdvogadoController());
		DelecaoAdvogadoView.setVisible(true);
	}
	
	public static void DeletarTribunal() {
		DelecaoTribunalView DelecaoTribunalView = new DelecaoTribunalView (MainController.getTribunalController());
		DelecaoTribunalView.setVisible(true);
	}
	
	public static void DeletarProcesso() {
		DelecaoProcessoView DelecaoProcessoView = new DelecaoProcessoView (MainController.getProcessoController());
		DelecaoProcessoView.setVisible(true);
	}
	
}
