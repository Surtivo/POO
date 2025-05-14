package Exercicio2;

public class Cliente extends Pessoa {
	private boolean platinum = false;
	
    public Cliente(long cpf, String nome, String tel, String email) {
		super(cpf, nome, tel, email);
		//this.platinum = false;
	}
    
    public boolean isPlatinum() {
    	return platinum;
    }
    
    public void setPlatinumTrue() {
    	this.platinum = true; 	    	
    }
}
	
