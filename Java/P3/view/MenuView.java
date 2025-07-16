package view;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.MainController;

public class MenuView {
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
			c.ipadx = 50;
		}
	
		button = new JButton("Cadastrar Pessoa Física");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		button.setActionCommand("BTN1");
		button.addActionListener(e -> CadastrarPF());
		pane.add(button, c);
	
		button = new JButton("Cadastrar Pessoa Jurídica");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		button.setActionCommand("BTN2");
		button.addActionListener(e -> CadastrarPJ());
		pane.add(button, c);
		
		button = new JButton("Listar Pessoa Fisicas");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		button.setActionCommand("BTN10");
		button.addActionListener(e -> ListarPessoasFisicas());
		pane.add(button, c);
		
		button = new JButton("Listar Pessoa Juridicas");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		button.setActionCommand("BTN9");
		button.addActionListener(e -> ListarPessoasJuridicas());
		pane.add(button, c);
		
		button = new JButton("Cadastrar Advogado");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		button.setActionCommand("BTN3");
		button.addActionListener(e -> CadastrarAdvogado());
		pane.add(button, c);
	
		button = new JButton("Listar Advogados");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		button.setActionCommand("BTN4");
		button.addActionListener(e -> ListarAdvogados());
		pane.add(button, c);
		
		button = new JButton("Cadastrar Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		button.setActionCommand("BTN5");
		button.addActionListener(e -> CadastrarProcesso());
		pane.add(button, c);
		
		button = new JButton("Consultar Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		button.setActionCommand("BTN6");
		button.addActionListener(e -> ConsultaProcessoView.createAndShowGUI());
		pane.add(button, c);
		
		button = new JButton("Cadastrar Tribunal");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		button.setActionCommand("BTN7");
		button.addActionListener(e -> CadastrarTribunal());
		pane.add(button, c);
		
		button = new JButton("Listar Tribunais");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		button.setActionCommand("BTN8");
		button.addActionListener(e -> ListarTribunais());
		pane.add(button, c);		
		
		button = new JButton("Adicionar Audiencia a um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		button.setActionCommand("BTN11");
		button.addActionListener(e -> AdicionarAudiencia());
		pane.add(button, c);
		
		button = new JButton("Adicionar Custo a um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		button.setActionCommand("BTN12");
		button.addActionListener(e -> AdicionarCustos());
		pane.add(button, c);
		
		button = new JButton("Listar Processos");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 6;
		button.setActionCommand("BTN13");
		button.addActionListener(e -> ListarProcessos());
		pane.add(button, c);
		
		button = new JButton("Deleção");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		button.setActionCommand("BTN14");
		button.addActionListener(e -> DelecaoView.createAndShowGUI());
		pane.add(button, c);		
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MenuView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void CadastrarPF() {
    	CadastroFisicoView CadPessoaFisicaView = new CadastroFisicoView (MainController.getPessoaController());
		CadPessoaFisicaView.setVisible(true);
    }
    
    public static void CadastrarPJ(){
    	CadastroJuridicoView CadPessoaJurView = new CadastroJuridicoView (MainController.getPessoaController());
    	CadPessoaJurView.setVisible(true);
	}
    
    public static void ListarPessoasFisicas(){
    	ListagemPessoaFisicaView lista = new ListagemPessoaFisicaView(MainController.getPessoaController().listarPessoasFisicas());
	    lista.setVisible(true);
	}
    
    public static void ListarPessoasJuridicas(){
    	ListagemPessoaJuridicaView lista = new ListagemPessoaJuridicaView(MainController.getPessoaController().listarPessoasJuridicas());
		lista.setVisible(true);
		}
    
    public static void CadastrarAdvogado() {
    	AdvogadoView AdvogadoView = new AdvogadoView (MainController.getPessoaController(), MainController.getAdvogadoController());
		AdvogadoView.setVisible(true);
    }
    
    public static void ListarAdvogados(){
    	ListagemAdvogadoView lista = new ListagemAdvogadoView(MainController.getAdvogadoController().ListarAdvogados());;
	    lista.setVisible(true);
	}
    
    public static void CadastrarProcesso() {
    	ProcessoView ProcessoView = new ProcessoView (MainController.getPessoaController(), MainController.getTribunalController(), MainController.getProcessoController());
		ProcessoView.setVisible(true);
    }
    
    public static void ListarProcessos() {
    	ListagemProcessosView ListagemProcessosView = new ListagemProcessosView(MainController.getProcessoController().ListarProcessos());
	    ListagemProcessosView.setVisible(true);
    }
    
    public static void CadastrarTribunal(){
    	ProcessoView ProcessoView = new ProcessoView (MainController.getPessoaController(), MainController.getTribunalController(), MainController.getProcessoController());
    	ProcessoView.setVisible(true);
	}
    
    public static void ListarTribunais(){
    	ListaTribunalView lista = new ListaTribunalView(MainController.getTribunalController().ListarTribunais());;
	    lista.setVisible(true);
	}
    
    public static void AdicionarAudiencia(){
    	AudienciaView lista = new AudienciaView(MainController.getProcessoController(), MainController.getAdvogadoController());
	    lista.setVisible(true);
	}
    
    public static void AdicionarCustos(){
    	CustaView CustaView = new CustaView(MainController.getProcessoController());
	    CustaView.setVisible(true);
	}
}
