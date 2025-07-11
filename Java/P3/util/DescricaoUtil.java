package util;

public class DescricaoUtil {
	public static boolean validateMotivo(String motivo) {
		if (motivo == null || motivo.isBlank() || motivo.isEmpty())
			return false;

		return true;
	}

}
