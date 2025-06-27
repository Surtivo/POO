package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.PessoaFisica;
import control.PessoaController;
import exceptions.PessoaException;
import valueObjects.Cnpj;
import valueObjects.Email;
import valueObjects.Telefone;

public class CadastroJuridicoView extends JFrame {
	private static final long serialVersionUID = 3067065872864162544L;
	
	private PessoaController PersonControl;
	private JTextField nomeTxt;
	private JTextField emailTxt;
	private JTextField telefoneTxt;
	private JTextField cnpjTxt;
	private JTextField cpfTxt;
	
	public CadastroJuridicoView(PessoaController PersonControl) {
        super("Cadastro de Pessoa Jurídica");
        
        this.PersonControl = PersonControl;

        // Configuração da janela
        setSize(600, 200);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        
        nomeTxt = new JTextField();
        emailTxt = new JTextField();
        telefoneTxt = new JTextField();
        cnpjTxt = new JTextField();
        cpfTxt = new JTextField();

        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Nome: "));
        panel.add(nomeTxt);

        panel.add(new JLabel("Email:"));
        panel.add(emailTxt);

        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneTxt);
        
        panel.add(new JLabel("CNPJ:"));
        panel.add(cnpjTxt);
        
        panel.add(new JLabel("CPF do Preposto:"));
        panel.add(cpfTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
        	String nome = nomeTxt.getText();
        	String email = emailTxt.getText();
        	String telefone = telefoneTxt.getText();
        	String cnpj = cnpjTxt.getText();
        	String cpf = cpfTxt.getText();
        	
        	try {
        		PessoaFisica preposto = (PessoaFisica)this.PersonControl.getPessoa(cpf);
        		this.PersonControl.addPessoa(nome, Email.valueOf(email), Telefone.valueOf(telefone), Cnpj.valueOf(cnpj), preposto);
				JOptionPane.showMessageDialog(null, "Feito!");
			} catch (PessoaException e1) {
				System.err.println(e1.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}        	
        });

        panel.add(salvar);

        add(panel);
    }
}