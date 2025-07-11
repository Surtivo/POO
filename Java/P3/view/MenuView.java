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
		button.addActionListener(e -> {
		    if ("BTN1".equals(e.getActionCommand())) {
		        CadastroFisicoView CadPessoaFisicaView = new CadastroFisicoView (MainController.getPessoaController());
		        CadPessoaFisicaView.setVisible(true);
		    }
		});
		pane.add(button, c);
	
		button = new JButton("Cadastrar Pessoa Jurídica");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		button.setActionCommand("BTN2");
		button.addActionListener(e -> {
		    if ("BTN2".equals(e.getActionCommand())) {
		        CadastroJuridicoView CadPessoaJurView = new CadastroJuridicoView (MainController.getPessoaController());
		        CadPessoaJurView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar Pessoa Fisicas");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		button.setActionCommand("BTN10");
		button.addActionListener(e -> {
		    if ("BTN10".equals(e.getActionCommand())) {
		        ListagemPessoaFisicaView lista = new ListagemPessoaFisicaView(MainController.getPessoaController().listarPessoasFisicas());
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar Pessoa Juridicas");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		button.setActionCommand("BTN9");
		button.addActionListener(e -> {
		    if ("BTN9".equals(e.getActionCommand())) {
		        ListagemPessoaJuridicaView lista = new ListagemPessoaJuridicaView(MainController.getPessoaController().listarPessoasJuridicas());
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Cadastrar Advogado");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		button.setActionCommand("BTN3");
		button.addActionListener(e -> {
		    if ("BTN3".equals(e.getActionCommand())) {
		        AdvogadoView AdvogadoView = new AdvogadoView (MainController.getPessoaController(), MainController.getAdvogadoController());
		        AdvogadoView.setVisible(true);
		    }
		});
		pane.add(button, c);
	
		button = new JButton("Listar Advogados");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		button.setActionCommand("BTN4");
		button.addActionListener(e -> {
		    if ("BTN4".equals(e.getActionCommand())) {
		        ListagemAdvogadoView lista = new ListagemAdvogadoView(MainController.getAdvogadoController().ListarAdvogados());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Cadastrar Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		button.setActionCommand("BTN5");
		button.addActionListener(e -> {
		    if ("BTN5".equals(e.getActionCommand())) {
		        ProcessoView ProcessoView = new ProcessoView (MainController.getPessoaController(), MainController.getTribunalController(), MainController.getProcessoController());
		        ProcessoView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		button.setActionCommand("BTN6");
		button.addActionListener(e -> {
		    if ("BTN6".equals(e.getActionCommand())) {
		        ListarProcessoView lista = new ListarProcessoView(MainController.getProcessoController());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Cadastrar Tribunal");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		button.setActionCommand("BTN7");
		button.addActionListener(e -> {
		    if ("BTN7".equals(e.getActionCommand())) {
		        TribunalView TribunalView = new TribunalView (MainController.getTribunalController());
		        TribunalView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar Tribunais");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		button.setActionCommand("BTN8");
		button.addActionListener(e -> {
		    if ("BTN8".equals(e.getActionCommand())) {
		        ListaTribunalView lista = new ListaTribunalView(MainController.getTribunalController().ListarTribunais());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);		
		
		button = new JButton("Adicionar Audiencia a um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		button.setActionCommand("BTN11");
		button.addActionListener(e -> {
		    if ("BTN11".equals(e.getActionCommand())) {
		    	AudienciaView lista = new AudienciaView(MainController.getProcessoController(), MainController.getAdvogadoController());
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Adicionar Custo a um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		button.setActionCommand("BTN12");
		button.addActionListener(e -> {
		    if ("BTN12".equals(e.getActionCommand())) {
		    	CustaView CustaView = new CustaView(MainController.getProcessoController());
		    	CustaView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar Processos");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 6;
		button.setActionCommand("BTN13");
		button.addActionListener(e -> {
		    if ("BTN13".equals(e.getActionCommand())) {
		    	ListagemProcessosView ListagemProcessosView = new ListagemProcessosView(MainController.getProcessoController().ListarProcessos());
		    	ListagemProcessosView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Deleção");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		button.setActionCommand("BTN14");
		button.addActionListener(e -> DelecaoView.createAndShowGUI());
		pane.add(button, c);

	
//		button = new JButton("Listar Processos");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//		c.insets = new Insets(10,0,0,0);  //top padding
//		c.gridx = 0;
//		c.gridy = 6;       //fourth row
//		pane.add(button, c);
	    
//		button = new JButton("Listar ???");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//		c.insets = new Insets(10,0,0,0);  //top padding
//		c.gridx = 1;
//		c.gridy = 6;       //fourth row
//		button.setActionCommand("BTN12");
//		button.addActionListener(e -> {
//		    if ("BTN11".equals(e.getActionCommand())) {
////		        System.out.println("Clicou no botão 'Pessoa 2'.");
////		        ListagemPessoaFisicaView lista = new ListagemPessoaFisicaView(PersonControl.listarPessoasFisicas());
////		        lista.setVisible(true);
//		    }
//		});
//		pane.add(button, c);
		
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MenuView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
}
