package classes;

import exceptions.TribunalException;
import util.TribunalUtil;

public class Tribunal {
	private final String sigla;
	private final String descricao;
	private final String secao;
	
	public Tribunal(String sigla, String descricao, String secao) throws TribunalException {
		if(!TribunalUtil.validateSigla(sigla))
			throw new TribunalException ("Sigla do tribual inválida!");
		this.sigla = sigla;
		if(!TribunalUtil.validateDescricao(descricao))
			throw new TribunalException ("Descrição do tribual inválida!");
		this.descricao = descricao;
		if(!TribunalUtil.validateSecao(secao))
			throw new TribunalException ("Seção do tribual inválida!");
		this.secao = secao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSecao() {
		return secao;
	}
	
}
