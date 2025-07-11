package valueObjects;

import java.io.Serializable;

import exceptions.SecaoException;

public class Secao implements Serializable{

	private static final long serialVersionUID = 9031021728421972406L;
	
	private final String valor;

	private Secao(String valor) {
		this.valor = valor;
	}

	public static Secao valueOf(String valor) throws SecaoException {
		if (!valor.matches("\\d{1}")) {
			throw new SecaoException("Formato de SEÇÃO inválido: " + valor);
		}
		return new Secao(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Secao))
			return false;
		Secao aux = (Secao) o;
		return valor.equals(aux.valor);
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
