package valueObjects;

import exceptions.AdvogadoException;

public class Registro {
    private final String valor;

    private Registro (String valor) {
        this.valor = valor;
    }

    //Método estático de criação — convenção comum para Value Objects;
    public static Registro valueOf(String valor) throws AdvogadoException {
    	if (!valor.matches("\\d{6}")) {
            throw new AdvogadoException("Formato de REGISTRO inválido: " + valor);
        }
        return new Registro(valor);
    }

    public String getValor() {
        return valor;
    }
    
    
    //Métodos que devem ser sobreescritos para value  objects;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registro)) return false;
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

