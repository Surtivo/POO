package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.PessoaController;
import control.ProcessoController;
import control.TribunalController;
import dtos.PessoaFisicaDto;
import dtos.ProcessoDto;
import dtos.TribunalDto;
import enums.EFaseProcesso;
import exceptions.PessoaException;
import exceptions.ProcessoException;
import exceptions.TribunalException;
import valueObjects.NumProc;

public class ProcessoView extends JFrame {
	
	private static final long serialVersionUID = 5368862380558005532L;
	
	private PessoaController PersonControl;
	private TribunalController TribunalControl;
	private ProcessoController ProcessoControl;
	private JTextField p1Txt;
	private JTextField p2Txt;
	private JTextField tribTxt;
	private JTextField numTxt;
	private JTextField faseTxt;
	
	public ProcessoView(PessoaController PersonControl, TribunalController TribunalControl, ProcessoController ProcessoControl) {
        super("Cadastro de Processo");
        
        this.PersonControl = PersonControl;
        this.TribunalControl = TribunalControl;
        this.ProcessoControl = ProcessoControl;

        // Configuração da janela
        setSize(600, 200);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        
        p1Txt = new JTextField();
        p2Txt = new JTextField();
        tribTxt = new JTextField();
        numTxt = new JTextField();
        faseTxt = new JTextField();

        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("CPF/CNPJ do Cliente:"));
        panel.add(p1Txt);

        panel.add(new JLabel("CPF/CNPJ da Parte Contrária:"));
        panel.add(p2Txt);
        
        panel.add(new JLabel("Sigla do Tribunal:"));
        panel.add(tribTxt);
        
        panel.add(new JLabel("Numero do Processo:"));
        panel.add(numTxt);
        
        panel.add(new JLabel("Fase do Processo:"));
        panel.add(faseTxt);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
        	
        	ProcessoDto processo = preencher();
        	
        	try {
        		this.ProcessoControl.addProcesso(processo); 
				JOptionPane.showMessageDialog(null, "Feito!");
			}catch (PessoaException e1) {
				System.err.println(e1.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao encontra cliente ou parte contrária! " + e1.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}catch (TribunalException e2) {
				System.err.println(e2.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro ao  encontrar tribunal! " + e2.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}catch (ProcessoException e3) {
				System.err.println(e3.getMessage());
		        JOptionPane.showMessageDialog(null, "Erro no número do processo! " + e3.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		    }catch (IllegalArgumentException e4) {
			    System.err.println(e4.getMessage());
			    JOptionPane.showMessageDialog(null, "Erro na fase " + e4.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
			}        	
        });

        panel.add(salvar);

        add(panel);
    }
	
	private ProcessoDto preencher() {
    	String p1 = p1Txt.getText();
    	String p2 = p2Txt.getText();
    	String trib = tribTxt.getText();
    	String num = numTxt.getText();
    	String fase = faseTxt.getText();
		ProcessoDto processo = new ProcessoDto(p1, p2, trib, num, fase);
		return processo;
	}
}
