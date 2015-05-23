package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIdConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(entityManager);
		
		Conta encontrado = dao.busca(4);
		
		System.out.println(encontrado.getTitular());
		
		entityManager.close();
	}
}
