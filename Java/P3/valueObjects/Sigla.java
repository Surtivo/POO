package valueObjects;

import exceptions.TribunalException;

public class Sigla {
    private final String valor;

    private Sigla (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Sigla valueOf(String valor) throws TribunalException {
    	if (!valor.matches("[A-Z0-9]{4}")) {													//Considerando siglas de três letras e um número;
            throw new TribunalException("Formato de SIGLA inválido: " + valor);
        }
        return new Sigla(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sigla)) return false;
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

