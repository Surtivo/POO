package valueObjects;

import java.io.Serializable;

import exceptions.SiglaException;

public class Sigla implements Serializable{

	private static final long serialVersionUID = -1314423710856511945L;
	
	private final String valor;

	private Sigla(String valor) {
		this.valor = valor;
	}

	public static Sigla valueOf(String valor) throws SiglaException {
		if (!valor.matches("[A-Z0-9]{4}")) { //Considerando siglas de três letras e um número;
			throw new SiglaException("Formato de SIGLA inválido: " + valor);
		}
		return new Sigla(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Sigla))
			return false;
		Sigla aux = (Sigla) o;
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
