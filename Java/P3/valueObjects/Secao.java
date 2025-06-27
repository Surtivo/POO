package valueObjects;

import exceptions.TribunalException;

public class Secao {
    private final String valor;

    private Secao (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Secao valueOf(String valor) throws TribunalException {
    	if (!valor.matches("\\d{1}")) {
            throw new TribunalException("Formato de SEÇÃO inválido: " + valor);
        }
        return new Secao(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Secao)) return false;
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

