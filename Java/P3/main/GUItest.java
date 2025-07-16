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
- Verificar se nada pode ser quebrado com parâmetros null;
- Tirar lixo do código (praticamente feito, falta checar oq tá sendo e não sendo usado);

*/