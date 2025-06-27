package util;

public class CpfUtilnaoutilizado {
	public static boolean validateCpf(String cpf) {
		if(cpf == null || cpf.isBlank() || cpf.isEmpty())
			return false;
		
		if(cpf.length() != 11)
			return false;
		
		return true;
		
	}

}
