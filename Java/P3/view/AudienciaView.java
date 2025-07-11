package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.AdvogadoController;
import control.ProcessoController;
import dtos.AudienciaDto;
import exceptions.AdvogadoException;
import exceptions.AudienciaException;

public class AudienciaView extends JFrame {

	private static final long serialVersionUID = 7376987780937688649L;
	
	private ProcessoController ProcessControl;
	private AdvogadoController AdvogadoControl;
	private JTextField advogadoTxt;
	private JTextField IDTxt;
	private JTextField recomendacaoTxt;
	
	public AudienciaView(ProcessoController ProcessControl, AdvogadoController AdvogadoControl) {
        super("Adicionar Audiencia");
        
        this.ProcessControl = ProcessControl;
        this.AdvogadoControl = AdvogadoControl;

        setSize(350, 150);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        advogadoTxt = new JTextField();
        IDTxt = new JTextField();
        recomendacaoTxt = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(new JLabel("ID do processo:"));
        panel.add(IDTxt);
        
        panel.add(new JLabel("Registro do Advogado:"));
        panel.add(advogadoTxt);

        panel.add(new JLabel("Motivo:"));
        panel.add(recomendacaoTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> actionSalvar());

        panel.add(salvar);

        add(panel);
    }

	private void actionSalvar() {
		String id = IDTxt.getText();
		String advogado = advogadoTxt.getText();
    	String motivo = recomendacaoTxt.getText();
    	
    	AudienciaDto audiencia = new AudienciaDto(id, advogado, motivo);
    	
    	try {
    		this.ProcessControl.addAudienciaDto(audiencia, this.AdvogadoControl);
			JOptionPane.showMessageDialog(null, "Feito!");
		} catch (AudienciaException | AdvogadoException e1) {
			System.err.println(e1.getMessage());
	        JOptionPane.showMessageDialog(null, "Erro ao cadastrar advogado! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		}        	
    }       	
}

