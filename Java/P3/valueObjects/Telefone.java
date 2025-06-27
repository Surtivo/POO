package valueObjects;

import exceptions.PessoaException;

public class Telefone {
    private final String valor;

    private Telefone (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Telefone valueOf(String valor) throws PessoaException {
    	if (!valor.matches("\\(\\d{2}\\)\\d{9}") && !valor.matches("\\d{11}")) {
            throw new PessoaException("Formato de TELEFONE inválido: " + valor);
        }
        return new Telefone(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
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

