package br.com.mvsistemas.desafiomv.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.mvsistemas.desafiomv.domain.CNESAtivos;
import br.com.mvsistemas.desafiomv.domain.TipoEstabelecimento;
import br.com.mvsistemas.desafiomv.util.HibernateUtil;

public class TipoEstabelecimentoDAO {
	
	public List<TipoEstabelecimento> listar(){
		// Criteria é a tecnologia mais atual para consultas em Java
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(TipoEstabelecimento.class);
	     	@SuppressWarnings("unchecked")
			List<TipoEstabelecimento> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;  
		}finally {
			sessao.close();
			
		}
		
	}


}
