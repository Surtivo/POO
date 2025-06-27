package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.TribunalController;
import dtos.TribunalDto;
import exceptions.TribunalException;
import valueObjects.Secao;
import valueObjects.Sigla;

public class TribunalView extends JFrame {
	
	private static final long serialVersionUID = -4849193140052769806L;
	
	private TribunalController TribunalControl;
	private JTextField siglaTxt;
	private JTextField descricaoTxt;
	private JTextField secaoTxt;
	
	public TribunalView(TribunalController TribunalControl) {
        super("Cadastro de Tribunal");
        
        this.TribunalControl = TribunalControl;

        // Configuração da janela
        setSize(400, 150);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        
        siglaTxt = new JTextField();
        descricaoTxt = new JTextField();
        secaoTxt = new JTextField();

        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(new JLabel("Nome:"));
        panel.add(descricaoTxt);
        
        panel.add(new JLabel("Sigla:"));
        panel.add(siglaTxt);
        
        panel.add(new JLabel("Seção:"));
        panel.add(secaoTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
        	String nome = descricaoTxt.getText();
        	String sigla = siglaTxt.getText();
        	String secao = secaoTxt.getText();
        	
        	TribunalDto t = new TribunalDto (sigla, nome, secao);
        	
        	try {
        		this.TribunalControl.addTribunal(t);
				JOptionPane.showMessageDialog(null, "Feito!");
			} catch (TribunalException e1) {
				System.err.println(e1.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar tribunal! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}       	
        });

        panel.add(salvar);

        add(panel);
    }
}
