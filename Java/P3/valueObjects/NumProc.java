package valueObjects;

import java.io.Serializable;

import exceptions.NumProcException;

public class NumProc implements Serializable{

	private static final long serialVersionUID = -4802711608002232242L;
	
	private final String valor;

	private NumProc(String valor) {
		this.valor = valor;
	}

	public static NumProc valueOf(String valor) throws NumProcException {
		if (!valor.matches("\\d{20}")) {
			throw new NumProcException("Número do processo deve conter 20 dígitos numéricos.");
		}
		if (!isValidCNJ(valor)) {
			throw new NumProcException("Dígito verificador inválido no número do processo.");
		}
		return new NumProc(valor);
	}

	public String getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof NumProc))
			return false;
		NumProc aux = (NumProc) o;
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
