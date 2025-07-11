package control;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable{

	private static final long serialVersionUID = 7352525125172534345L;

	private static MainController instance;
	
	private TribunalController tribunalController;
	private PessoaController personController;
	private AdvogadoController advogadoController;
	private ProcessoController processoController;
	
	private MainController() {
		
		tribunalController = new TribunalController();
		personController = new PessoaController();
		advogadoController = new AdvogadoController();
		processoController = new ProcessoController();		
	}	
	
	public static MainController getInstance() {
		return instance;
	}
	
	public static TribunalController getTribunalController() {
		return instance.tribunalController;
	}
	
	public static PessoaController getPessoaController() {
		return instance.personController;
	}
	
	public static AdvogadoController getAdvogadoController() {
		return instance.advogadoController;
	}
	
	public static ProcessoController getProcessoController() {
		return instance.processoController;
	}
	
	public static void load() {

		instance = Serializer.readFile();

		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}
}