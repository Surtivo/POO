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
import exceptions.NumProcException;
import exceptions.ProcessoException;

public class ListarProcessoView extends JFrame {

	private static final long serialVersionUID = -3184167728998701207L;
	
	private ProcessoController ProcessoControl;
	private JTextField numeroTxt;
	
	public ListarProcessoView(ProcessoController ProcessoControl) {
        super("Digite o Processo");
        
        this.ProcessoControl = ProcessoControl;

        setSize(250, 150);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        numeroTxt = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Número do processo:"));
        panel.add(numeroTxt);
        
        JButton buscar = new JButton("Buscar");
        buscar.addActionListener(e -> actionSalvar());

        panel.add(buscar);

        add(panel);
    }
	
	private void actionSalvar() {
    	String numero = numeroTxt.getText();
    	ListarProcessoTextView l = null;
    	try {
			l = new ListarProcessoTextView(this.ProcessoControl, numero);
		} catch (ProcessoException | AudienciaException | NumProcException e1) {
			System.err.println(e1.getMessage());
	        JOptionPane.showMessageDialog(null, "Erro ao encontrar processo! " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}   
    	if(l != null)
    		l.setVisible(true);		
	}
}