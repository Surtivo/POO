package valueObjects;

import java.io.Serializable;

import exceptions.TelefoneException;

public class Telefone implements Serializable{

	private static final long serialVersionUID = -8982721473912170268L;
	
	private final String valor;

	private Telefone(String valor) {
		this.valor = valor;
	}

	public static Telefone valueOf(String valor) throws TelefoneException {
		if (!valor.matches("\\(\\d{2}\\)\\d{9}") && !valor.matches("\\d{11}")) {
			throw new TelefoneException("Formato de TELEFONE inválido: " + valor);
		}
		return new Telefone(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Telefone))
			return false;
		Telefone tel = (Telefone) o;
		return valor.equals(tel.valor);
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
