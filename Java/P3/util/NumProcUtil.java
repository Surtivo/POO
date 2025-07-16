package util;

public class NumProcUtil {

	public static boolean validateNumero(String numero) {
		
		if (!numero.matches("\\d{5}")) {
			return false;
		}
//		if (!isValidCNJ(numero)) {
//			return false;
//		}

		return true;
	}

	public static boolean isValidCNJ(String numProc) {
		if (numProc.length() != 20 || !numProc.matches("\\d{20}"))
			return false;
		
		String numSemDV = numProc.substring(0, 7) + numProc.substring(9);
		String dvStr = numProc.substring(7, 9);

		int dv = Integer.parseInt(dvStr);
		java.math.BigInteger numero = new java.math.BigInteger(numSemDV);

		int mod = numero.mod(java.math.BigInteger.valueOf(97)).intValue();
		int dvCalculado = 98 - mod;

		return dv == dvCalculado;
	}
	
}
