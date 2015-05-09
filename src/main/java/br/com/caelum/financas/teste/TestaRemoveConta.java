package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(entityManager);
		
		entityManager.getTransaction().begin();
		
		Conta conta = dao.busca(1);
		dao.remove(conta);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Conta removida com sucesso!");
	}
}
