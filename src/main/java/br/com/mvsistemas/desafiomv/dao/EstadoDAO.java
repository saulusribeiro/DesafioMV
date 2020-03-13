package br.com.mvsistemas.desafiomv.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.mvsistemas.desafiomv.domain.CNESAtivos;
import br.com.mvsistemas.desafiomv.domain.Estado;
import br.com.mvsistemas.desafiomv.util.HibernateUtil;

public class EstadoDAO {
	
	public List<Estado> listar(){
		// Criteria é a tecnologia mais atual para consultas em Java
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Estado.class);
			consulta.addOrder(Order.asc("descricao"));
			@SuppressWarnings("unchecked")
			List<Estado> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;  
		}finally {
			sessao.close();
			
		}
		
	}


}
