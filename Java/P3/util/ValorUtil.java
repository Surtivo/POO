package util;

public class ValorUtil {

	public static boolean validateValor(double valor) {
		if (valor < 0)
			return false;

		return true;
	}

}
