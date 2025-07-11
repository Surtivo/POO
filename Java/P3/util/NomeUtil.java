package util;

public class NomeUtil {
	public static boolean validateNome(String nome) {
		if (nome == null || nome.isBlank() || nome.isEmpty())
			return false;

		return true;
	}

}
