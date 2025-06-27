package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.AdvogadoController;
import control.PessoaController;
import dtos.AdvogadoDto;
import exceptions.AdvogadoException;
import exceptions.PessoaException;

public class AdvogadoView extends JFrame {
	private static final long serialVersionUID = 3067065872864162544L;
	
	private PessoaController PersonControl;
	private AdvogadoController AdvogadoControl;
	private JTextField cpfTxt;
	private JTextField registroTxt;
	
	public AdvogadoView(PessoaController PersonControl, AdvogadoController AdvogadoControl) {
        super("Cadastro de Advogado");
        
        this.PersonControl = PersonControl;
        this.AdvogadoControl = AdvogadoControl;

        // Configuração da janela
        setSize(300, 125);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        
        registroTxt = new JTextField();
        cpfTxt = new JTextField();

        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Registro:"));
        panel.add(registroTxt);
        
        panel.add(new JLabel("CPF:"));
        panel.add(cpfTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
        	String registro = registroTxt.getText();
        	String cpf = cpfTxt.getText();
        	
        	AdvogadoDto advogado = new AdvogadoDto(cpf, registro);
        	
        	try {
        		this.AdvogadoControl.addAdvogado(advogado, this.PersonControl);
				JOptionPane.showMessageDialog(null, "Feito!");
			} catch (PessoaException e1) {
				System.err.println(e1.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar advogado! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}catch (AdvogadoException e2) {
				System.err.println(e2.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar advogado! " + e2.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}        	
        });

        panel.add(salvar);

        add(panel);
    }
}