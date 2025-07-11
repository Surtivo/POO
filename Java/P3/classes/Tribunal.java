package classes;

import java.io.Serializable;

import exceptions.NomeException;
import util.TribunalUtil;
import valueObjects.Secao;
import valueObjects.Sigla;

public class Tribunal implements Serializable{

	private static final long serialVersionUID = -819319085493436352L;
	
	private final Sigla sigla;
	private final String descricao;
	private final Secao secao;
	
	public Tribunal(Sigla sigla, String descricao, Secao secao) throws NomeException {
		this.sigla = sigla;
		if(!TribunalUtil.validateDescricao(descricao))
			throw new NomeException ("Descrição do tribunal inválida!");
		this.descricao = descricao;
		this.secao = secao;
	}

	public String getSigla() {
		return sigla.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSecao() {
		return secao.toString();
	}
	
}
