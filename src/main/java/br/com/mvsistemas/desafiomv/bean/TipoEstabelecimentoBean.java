package br.com.mvsistemas.desafiomv.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.omnifaces.util.Messages;

import br.com.mvsistemas.desafiomv.dao.TipoEstabelecimentoDAO;
import br.com.mvsistemas.desafiomv.domain.TipoEstabelecimento;

public class TipoEstabelecimentoBean {

	private TipoEstabelecimento tipoestabelecimento;
	private List<TipoEstabelecimento> tipoestabelecimentos;
	public TipoEstabelecimento getTipoestabelecimento() {
		return tipoestabelecimento;
	}
	public void setTipoestabelecimento(TipoEstabelecimento tipoestabelecimento) {
		this.tipoestabelecimento = tipoestabelecimento;
	}
	public List<TipoEstabelecimento> getTipoestabelecimentos() {
		return tipoestabelecimentos;
	}
	public void setTipoestabelecimentos(List<TipoEstabelecimento> tipoestabelecimentos) {
		this.tipoestabelecimentos = tipoestabelecimentos;
	}

	@PostConstruct
	public void listar() {
		try {
			TipoEstabelecimentoDAO tipoestabelecimentoDAO = new TipoEstabelecimentoDAO();
			tipoestabelecimentos = tipoestabelecimentoDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro na listagem da Tabela de Estados");
			erro.printStackTrace();
		}
	}
	
}
