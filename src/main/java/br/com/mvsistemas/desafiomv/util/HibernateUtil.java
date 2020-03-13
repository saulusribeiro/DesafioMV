
package br.com.mvsistemas.desafiomv.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricaDeSessoes = criarFabricadeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	public static Connection getConexao() {
		Session sessao = fabricaDeSessoes.openSession();

		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});

		return conexao;
	}

	@SuppressWarnings("deprecation")
	public static SessionFactory criarFabricadeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro1 = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();
			SessionFactory fabrica = configuracao.buildSessionFactory(registro1);
			return fabrica;

		} catch (Throwable ex) {
			/*
			 * Throwable é o pai de todas as excessões então qualquer excessão que ocorrer
			 * será tratadaco
			 */
			System.out.println("Erro ao inicar o Hibernte " + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

}
