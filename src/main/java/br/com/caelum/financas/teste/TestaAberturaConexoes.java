package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaAberturaConexoes {

	public static void main(String[] args) throws InterruptedException {

		for(int i = 0; i < 30; i++) {
			EntityManager entityManager = new JPAUtil().getEntityManager();
			entityManager.getTransaction().begin();
			
			System.out.println("Criado EntityManager número " + (i+1));
		}
		
		Thread.sleep(30 * 1000);
		
	}

}
