package classes;

import exceptions.TribunalException;
import util.TribunalUtil;
import valueObjects.Secao;
import valueObjects.Sigla;

public class Tribunal {
	private final Sigla sigla;
	private final String descricao;
	private final Secao secao;
	
	public Tribunal(Sigla sigla, String descricao, Secao secao) throws TribunalException {
		//if(!TribunalUtil.validateSigla(sigla))
			//throw new TribunalException ("Sigla do tribunal inválida!");
		this.sigla = sigla;
		if(!TribunalUtil.validateDescricao(descricao))
			throw new TribunalException ("Descrição do tribunal inválida!");
		this.descricao = descricao;
		//if(!TribunalUtil.validateSecao(secao))
			//throw new TribunalException ("Seção do tribunal inválida!");
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
