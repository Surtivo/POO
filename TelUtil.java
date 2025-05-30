package util;

public class TelUtil {
	public static boolean validateTel(String tel) {
		if(tel == null || tel.isBlank() || tel.isEmpty())
			return false;
		
		if(tel.length() != 9)
			return false;
			
		return true;
	}

}
