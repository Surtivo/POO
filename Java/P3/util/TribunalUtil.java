package util;

public class TribunalUtil {
	
	//Não usa;
	public static boolean validateSigla(String sigla) {
		if(sigla == null || sigla.isBlank() || sigla.isEmpty())
			return false;
			
		return true;
	}

	public static boolean validateDescricao(String descricao) {
		if (descricao == null || descricao.isBlank() || descricao.isEmpty())
			return false;

		return true;
	}

	//Não usa;
	public static boolean validateSecao(String secao) {
		if (secao == null || secao.isBlank() || secao.isEmpty())
			return false;

		return true;
	}

}
