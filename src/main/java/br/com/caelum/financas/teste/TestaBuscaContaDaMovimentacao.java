package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		
		Movimentacao encontrado = movimentacaoDao.busca(4);
		System.out.println("Titular associado à movimentação: \n " + encontrado.getConta().getTitular());
	}
}
