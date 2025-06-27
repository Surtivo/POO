package main;

import control.AdvogadoController;
import control.PessoaController;
import control.ProcessoController;
import control.TribunalController;

public class MainController {

	public static void main(String[] args) {
		//Inicilizar Controladores;
		TribunalController TribunalControl = new TribunalController();
		PessoaController PersonControl = new PessoaController();
		AdvogadoController AdvogadoControl = new AdvogadoController();
		ProcessoController ProcessoControl = new ProcessoController();
		
		//Inicializar Views (são que vão chamar os controladores efetivamente);
		
		
		//Colocar Frames visíveis;

	}

}
