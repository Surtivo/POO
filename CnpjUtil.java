package util;

public class CnpjUtil {
	public static boolean validateCnpj(String cnpj) {
		if(cnpj == null || cnpj.isBlank() || cnpj.isEmpty())
			return false;
		
		if(cnpj.length() != 13)
			return false;
		
		return true;
		
	}

}
