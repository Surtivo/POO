package util;

public class RegistroUtilnaoutilizado {

	public static boolean validateRegistro(String registro) {
		if(registro == null || registro.isBlank() || registro.isEmpty())
			return false;
		
		if(registro.length() != 6)
			return false;
		
		return true;
		
	}

}
