package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ProcessoController;
import dtos.DespesaDto;
import exceptions.DespesaException;

public class CustaView extends JFrame {

	private static final long serialVersionUID = -3005137190947847332L;
	
	private ProcessoController ProcessControl;
	private JTextField IDTxt;
	private JTextField motivoTxt;
	private JTextField valorTxt;
	
	public CustaView(ProcessoController ProcessControl) {
        super("Adicionar Custo");
        
        this.ProcessControl = ProcessControl;

        setSize(350, 150);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        IDTxt = new JTextField();
        valorTxt = new JTextField();
        motivoTxt = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(new JLabel("ID do processo:"));
        panel.add(IDTxt);

        panel.add(new JLabel("Motivo:"));
        panel.add(motivoTxt);
        
        panel.add(new JLabel("Valor:"));
        panel.add(valorTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> actionSalvar());

        panel.add(salvar);

        add(panel);
    }

	private void actionSalvar() {
		String id = IDTxt.getText();
    	String motivo = motivoTxt.getText();
    	String valor = valorTxt.getText();
    	
    	DespesaDto custa = new DespesaDto(id, motivo, valor);
    	
    	try {
    		this.ProcessControl.addCustaDto(custa);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (DespesaException | NumberFormatException e1) {
			System.err.println(e1.getMessage());
	        JOptionPane.showMessageDialog(null, "Erro ao cadastrar advogado! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}        	
    }       	
}
