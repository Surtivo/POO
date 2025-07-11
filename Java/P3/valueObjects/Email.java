package valueObjects;

import java.io.Serializable;

import exceptions.EmailException;

public class Email implements Serializable{
	
	private static final long serialVersionUID = -6940272804996753549L;
	
	private final String valor;

	private Email(String valor) {
		this.valor = valor;
	}

	public static Email valueOf(String valor) throws EmailException {
		if (valor == null || valor.isBlank()) {
			throw new EmailException("E-mail não pode ser nulo ou vazio.");
		}

		String regex = "^[A-Za-z0-9_.]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		if (!valor.matches(regex)) {
			throw new EmailException("Formato de e-mail inválido: " + valor);
		}

		return new Email(valor.toLowerCase());
	}

	public String getValor() {
		return valor;
	}

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
