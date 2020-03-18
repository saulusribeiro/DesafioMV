package br.com.mvsistemas.desafiomv.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.mvsistemas.desafiomv.domain.CNESAtivos;
import br.com.mvsistemas.desafiomv.domain.Estado;
import br.com.mvsistemas.desafiomv.domain.TipoEstabelecimento;
import br.com.mvsistemas.desafiomv.util.HibernateUtil;

public class CNESAtivosDAO {
	public List<CNESAtivos> listar(){
		// Criteria é a tecnologia mais atual para consultas em Java
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(CNESAtivos.class);  // serve para consultar qualquer classe
			@SuppressWarnings("unchecked")
			List<CNESAtivos> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;  
		}finally {
			sessao.close();
			
		}
		
	}

	public List<CNESAtivos> listarEstado(Estado estado){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(CNESAtivos.class);
	    	consulta.add(Restrictions.eq("estado",estado));
			@SuppressWarnings("unchecked")
			List<CNESAtivos> resultado = consulta.list();
			return resultado; 
			
	
				
			
		} catch (RuntimeException erro) {
			throw erro;  
		}finally {
			sessao.close();
			
		}
		
	}
	
	public List<CNESAtivos> listarTipoEstab(TipoEstabelecimento tipoestab){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(CNESAtivos.class);
			consulta.add(Restrictions.eq("tipo_estabelecimento",tipoestab));
			@SuppressWarnings("unchecked")
			List<CNESAtivos> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;  
		}finally {
			sessao.close();
			
		}
		
	}

	
}
