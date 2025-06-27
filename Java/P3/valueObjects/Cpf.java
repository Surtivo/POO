package valueObjects;

import exceptions.PessoaException;

public class Cpf {
    private final String valor;

    private Cpf (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Cpf valueOf(String valor) throws PessoaException {
    	if (!valor.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") && !valor.matches("\\d{11}")) {
            throw new PessoaException("Formato de CPF inválido: " + valor);
        }
        return new Cpf(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf cpf = (Cpf) o;
        return valor.equals(cpf.valor);
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

