package valueObjects;

import exceptions.PessoaException;

public class Email {
	private final String valor;

	private Email(String valor) {
		this.valor = valor;
	}

	// Método estático de criação — convenção comum para Value Objects;
	public static Email valueOf(String valor) throws PessoaException {
		if (valor == null || !valor.toLowerCase().contains("@")) {
			throw new PessoaException("Formato de EMAIL inválido: " + valor);
		}
		return new Email(valor);
	}

	public String getValor() {
		return valor;
	}

	// Métodos que devem ser sobreescritos para value objects;
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Email))
			return false;
		Email mail = (Email) o;
		return valor.equals(mail.valor);
	}

	@Override
	public int hashCode() {
		return valor.hashCode();
	}

	@Override
	public String toString() {
		return valor;
	}
}
