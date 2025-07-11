package util;

public class TribunalUtil {

	public static boolean validateDescricao(String descricao) {
		if (descricao == null || descricao.isBlank() || descricao.isEmpty())
			return false;

		return true;
	}
}
