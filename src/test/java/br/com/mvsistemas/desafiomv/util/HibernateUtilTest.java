package br.com.mvsistemas.desafiomv.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.mvsistemas.desafiomv.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
		
	}
	

}
