package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {
	private EntityManager entityManager;
	
	public MovimentacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Movimentacao busca(Integer id) {
		return this.entityManager.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> lista() {
		return this.entityManager.createQuery("select c from Movimentacao c", Movimentacao.class)
				.getResultList();
	}
	
	public void adiciona(Movimentacao movimentacao) {
		entityManager.persist(movimentacao);
	}
	
	public void remove(Movimentacao movimentacao) {
		entityManager.remove(entityManager.merge(movimentacao));
	}
}	
