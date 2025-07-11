package valueObjects;

import java.io.Serializable;

import exceptions.CpfException;

public class Cpf implements Serializable{

	private static final long serialVersionUID = 4700604768331764474L;
	
	private final String valor;

	private Cpf(String valor) {
		this.valor = valor;
	}

	public static Cpf valueOf(String valor) throws CpfException {
		String digitsOnly = valor.replaceAll("[^\\d]", "");

		if (!digitsOnly.matches("\\d{11}")) {
			throw new CpfException("CPF deve conter 11 dígitos numéricos.");
		}

		if (digitsOnly.chars().distinct().count() == 1) {
			throw new CpfException("CPF inválido: Todos os dígitos são iguais.");
		}

		if (!isValidCpfDigits(digitsOnly)) {
			throw new CpfException("CPF inválido: Dígitos verificadores do CPF são inválidos." + valor);
		}

		return new Cpf(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Cpf))
			return false;
		Cpf cpf = (Cpf) o;
		return valor.equals(cpf.valor);
	}

	@Override
	public int hashCode() {
		return valor.hashCode();
	}

	@Override
	public String toString() {
		return valor;
	}

	private static boolean isValidCpfDigits(String cpf) {
		int soma1 = 0;
		for (int i = 0; i < 9; i++) {
			soma1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}
		
		int digito1 = (soma1 * 10) % 11;
		if (digito1 == 10)
			digito1 = 0;

		int soma2 = 0;
		for (int i = 0; i < 10; i++) {
			soma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		
		int digito2 = (soma2 * 10) % 11;
		if (digito2 == 10)
			digito2 = 0;

		return digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10));
	}

}
