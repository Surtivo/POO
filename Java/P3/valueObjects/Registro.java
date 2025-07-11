package valueObjects;

import java.io.Serializable;

import exceptions.RegistroException;

public class Registro implements Serializable{

	private static final long serialVersionUID = -7402113185709196354L;
	
	private final String valor;

	private Registro(String valor) {
		this.valor = valor;
	}

	public static Registro valueOf(String valor) throws RegistroException {
		if (!valor.matches("\\d{6}")) {
			throw new RegistroException("Formato de REGISTRO inválido: " + valor);
		}
		return new Registro(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Registro))
			return false;
		Registro reg = (Registro) o;
		return valor.equals(reg.valor);
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
