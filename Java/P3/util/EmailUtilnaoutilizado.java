package util;

public class EmailUtilnaoutilizado {
	public static boolean validateEmail(String email) {
		if(email == null || email.isBlank() || email.isEmpty())
			return false;
		
		if(email.length() > 31)
			return false;
			
		return true;
	}

}
