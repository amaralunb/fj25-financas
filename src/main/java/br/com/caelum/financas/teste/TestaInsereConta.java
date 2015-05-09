package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager(); 
		
		ContaDao dao = new ContaDao(entityManager);
		
		Conta conta = new Conta();
		
		conta.setTitular("Luis Gabriel");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("54321-6");
		conta.setAgencia("0111");
		
		entityManager.getTransaction().begin();

		dao.adiciona(conta);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
