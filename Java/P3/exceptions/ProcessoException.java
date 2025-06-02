package exceptions;

public class ProcessoException extends Exception{

	private static final long serialVersionUID = -2488729813668916460L;

		public ProcessoException (String message) {
			super("Processo Exception: " + message);
		}
}

