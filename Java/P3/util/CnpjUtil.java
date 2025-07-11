package util;

public class CnpjUtil {
	public static boolean validateCnpj(String cnpj) {

		if (cnpj == null || cnpj.isBlank() || cnpj.isEmpty())
			return false;

		if (!cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}\\-\\d{2}") && !cnpj.matches("\\d{14}"))
			return false;

		return true;

	}

}
