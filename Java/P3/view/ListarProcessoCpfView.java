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

public class ListarProcessoCpfView extends JFrame {

	private static final long serialVersionUID = -7773191865909082789L;
	
	private ProcessoController ProcessoControl;
	private JTextField numeroTxt;
	
	public ListarProcessoCpfView(ProcessoController ProcessoControl) {
        super("Digite o Processo");
        
        this.ProcessoControl = ProcessoControl;

        setSize(250, 150);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        numeroTxt = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Número do CPF/CNPJ:"));
        panel.add(numeroTxt);
        
        JButton buscar = new JButton("Buscar");
        buscar.addActionListener(e -> actionBuscar());

        panel.add(buscar);

        add(panel);
    }
	
	private void actionBuscar() {
    	String numero = numeroTxt.getText();
    	ListarProcessoCpfTextView l = null;
    	try {
			l = new ListarProcessoCpfTextView(this.ProcessoControl, numero);
		} catch (ProcessoException | AudienciaException | NumProcException e1) {
			System.err.println(e1.getMessage());
	        JOptionPane.showMessageDialog(null, "Erro ao encontrar processo! " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}   
    	if(l != null)
    		l.setVisible(true);		
	}
}