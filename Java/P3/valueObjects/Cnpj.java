package valueObjects;

import exceptions.PessoaException;

public class Cnpj {
    private final String valor;

    private Cnpj (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Cnpj valueOf(String valor) throws PessoaException {
    	if (!valor.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}\\-\\d{2}") && !valor.matches("\\d{14}")) {
            throw new PessoaException("Formato de CNPJ inválido: " + valor);
        }
        return new Cnpj(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cnpj)) return false;
        Cnpj cnpj = (Cnpj) o;
        return valor.equals(cnpj.valor);
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

