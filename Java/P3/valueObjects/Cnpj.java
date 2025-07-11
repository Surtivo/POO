package valueObjects;

import java.io.Serializable;

import exceptions.CnpjException;

public class Cnpj implements Serializable{

	private static final long serialVersionUID = -7285806086858363741L;
	
	private final String valor;

	private Cnpj(String valor) {
		this.valor = valor;
	}

	public static Cnpj valueOf(String valor) throws CnpjException {
		String digitsOnly = valor.replaceAll("[^\\d]", "");

		if (!digitsOnly.matches("\\d{14}")) {
			throw new CnpjException("CNPJ deve conter 14 dígitos numéricos.");
		}

		if (digitsOnly.chars().distinct().count() == 1) {
			throw new CnpjException("CNPJ inválido: Todos os dígitos são iguais.");
		}

		if (!isValidCnpjDigits(digitsOnly)) {
			throw new CnpjException("CNPJ inválido: Dígitos verificadores do CNPJ são inválidos.");
		}

		return new Cnpj(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Cnpj))
			return false;
		Cnpj cnpj = (Cnpj) o;
		return valor.equals(cnpj.valor);
	}

	@Override
	public int hashCode() {
		return valor.hashCode();
	}

	@Override
	public String toString() {
		return valor;
	}

	private static boolean isValidCnpjDigits(String cnpj) {
		int[] pesos1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] pesos2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

		int soma1 = 0;
		for (int i = 0; i < 12; i++) {
			soma1 += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
		}
		int digito1 = soma1 % 11;
		digito1 = (digito1 < 2) ? 0 : 11 - digito1;

		int soma2 = 0;
		for (int i = 0; i < 13; i++) {
			soma2 += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
		}
		int digito2 = soma2 % 11;
		digito2 = (digito2 < 2) ? 0 : 11 - digito2;

		return digito1 == Character.getNumericValue(cnpj.charAt(12)) && digito2 == Character.getNumericValue(cnpj.charAt(13));
	}

}
