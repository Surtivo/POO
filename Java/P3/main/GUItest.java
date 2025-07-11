//package main;
//
//import view.MenuView;
//
//public class GUItest {
//
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//            	MenuView.createAndShowGUI();
//            }
//        });
//    }
//}


package main;

import java.awt.EventQueue;

import control.MainController;
import view.MenuView;

public class GUItest {


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					MainController.load();
					MenuView.createAndShowGUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



/*
Falta:

- Criar deleção e update e suas respectivas views;
- PessoaFisica não consegue processar PessoaFisica e o mesmo para Juridica;
- Mostrar CPF/CNPJ, processo com formato certo;
- Tirar lixo do código (praticamente feito, falta checar oq tá sendo e não sendo usado);

*/
