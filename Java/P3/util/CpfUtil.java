package util;

public class CpfUtil {
	public static boolean validateCpf(String cpf) {
		if (cpf == null || cpf.isBlank() || cpf.isEmpty())
			return false;

		if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") && !cpf.matches("\\d{11}"))
			return false;

		return true;

	}

}
