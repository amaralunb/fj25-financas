package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager(); 
		
		Conta conta = new Conta();
		
		conta.setTitular("Luis Amaral");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
