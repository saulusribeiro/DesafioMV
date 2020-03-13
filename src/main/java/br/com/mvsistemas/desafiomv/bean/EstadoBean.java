package br.com.mvsistemas.desafiomv.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.omnifaces.util.Messages;

import br.com.mvsistemas.desafiomv.dao.EstadoDAO;
import br.com.mvsistemas.desafiomv.domain.Estado;


public class EstadoBean {
	
	private Estado estado;
	private List<Estado> estados;
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro na listagem da Tabela de Estados");
			erro.printStackTrace();
		}
	}
	

}
