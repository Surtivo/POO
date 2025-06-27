package view;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.AdvogadoController;
import control.PessoaController;
import control.ProcessoController;
import control.TribunalController;

public class MenuView {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        PessoaController PersonControl = new PessoaController();
        AdvogadoController AdvogadoControl = new AdvogadoController();
        TribunalController TribunalControl = new TribunalController();
        ProcessoController ProcessoControl = new ProcessoController();
        
        JButton button;
	    pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
		//natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;     // aumenta altura interna
		c.ipadx = 50;     // aumenta largura interna
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
		        System.out.println("Clicou no botão 'Pessoa 1'.");
		        CadastroFisicoView CadPessoaFisicaView = new CadastroFisicoView (PersonControl);
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
		        System.out.println("Clicou no botão 'Pessoa 2'.");
		        CadastroJuridicoView CadPessoaJurView = new CadastroJuridicoView (PersonControl);
		        CadPessoaJurView.setVisible(true);
		    }
		});
		pane.add(button, c);
	
		button = new JButton("Cadastrar Advogado");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		button.setActionCommand("BTN3");
		button.addActionListener(e -> {
		    if ("BTN3".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Advogado 1'.");
		        AdvogadoView AdvogadoView = new AdvogadoView (PersonControl, AdvogadoControl);
		        AdvogadoView.setVisible(true);
		    }
		});
		pane.add(button, c);
	
		button = new JButton("Listar Advogados");
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 10;      //make this component tall
		c.weightx = 0.5;
	//	c.gridwidth = 3;
		c.gridx = 1;
		c.gridy = 1;
		button.setActionCommand("BTN4");
		button.addActionListener(e -> {
		    if ("BTN4".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Advogado 2'.");
		        System.out.println(AdvogadoControl.ListarAdvogados());
		        ListaAdvogadoView lista = new ListaAdvogadoView(AdvogadoControl.ListarAdvogados2());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Cadastrar Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		button.setActionCommand("BTN5");
		button.addActionListener(e -> {
		    if ("BTN5".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Processo 1'.");
		        ProcessoView ProcessoView = new ProcessoView (PersonControl, TribunalControl, ProcessoControl);
		        ProcessoView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar um Processo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		button.setActionCommand("BTN6");
		button.addActionListener(e -> {
		    if ("BTN6".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Processo 2'.");
		        System.out.println(ProcessoControl.ListarProcessos());
		        ListarProcessoQualView lista = new ListarProcessoQualView(ProcessoControl);;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Cadastrar Tribunal");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		button.setActionCommand("BTN7");
		button.addActionListener(e -> {
		    if ("BTN7".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Tribunal 1'.");
		        TribunalView TribunalView = new TribunalView (TribunalControl);
		        TribunalView.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("Listar Tribunais");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		button.setActionCommand("BTN8");
		button.addActionListener(e -> {
		    if ("BTN8".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Tribunal 2'.");
		        System.out.println(TribunalControl.ListarTribunais());
		        ListaTribunalView lista = new ListaTribunalView(TribunalControl.ListarTribunais2());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
		
		button = new JButton("BOTAUMMMMMM");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(button, c);
	
		button = new JButton("Listar Processos");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridy = 5;       //fourth row
		pane.add(button, c);
	    
		button = new JButton("Listar Pessoas");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;
		c.gridy = 5;       //fourth row
		button.setActionCommand("BTN3");
		button.addActionListener(e -> {
		    if ("BTN3".equals(e.getActionCommand())) {
		        System.out.println("Clicou no botão 'Pessoa 2'.");
		        System.out.println(PersonControl.ListarPessoas());
		        ListagemPessoaView lista = new ListagemPessoaView(PersonControl.ListarPessoas2());;
		        lista.setVisible(true);
		    }
		});
		pane.add(button, c);
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
