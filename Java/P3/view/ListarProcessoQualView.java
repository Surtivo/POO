package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ProcessoController;
import exceptions.AudienciaException;
import exceptions.ProcessoException;

public class ListarProcessoQualView extends JFrame {

	private static final long serialVersionUID = -3184167728998701207L;
	
	private ProcessoController ProcessoControl;
	private JTextField numeroTxt;
	
	public ListarProcessoQualView(ProcessoController ProcessoControl) {
        super("Digite o Processo");
        
        this.ProcessoControl = ProcessoControl;

        // Configuração da janela
        setSize(300, 125);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        
        numeroTxt = new JTextField();

        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        panel.add(new JLabel("Numero:"));
        panel.add(numeroTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
        	String numero = numeroTxt.getText();
        	ListarProcessoView l = null;
        	try {
				l = new ListarProcessoView(this.ProcessoControl, numero);
			} catch (ProcessoException | AudienciaException e1) {
				System.err.println(e1.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao encontrar processo! " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}   
        	this.setVisible(false);
        	if(l != null)
        		l.setVisible(true);
        });

        panel.add(salvar);

        add(panel);
    }
}