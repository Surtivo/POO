package valueObjects;

import exceptions.ProcessoException;

public class NumProc {
    private final String valor;

    private NumProc (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static NumProc valueOf(String valor) throws ProcessoException {
    	if (!valor.matches("\\d{2}")) {
            throw new ProcessoException("Formato de NÚMERO inválido: " + valor);
        }
        return new NumProc(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumProc)) return false;
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
}

