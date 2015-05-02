package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Movimentacao movimentacao = new Movimentacao();	
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Uma movimentação");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("300"));
		
		entityManager.getTransaction().begin();
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Movimentacao adicionada com sucesso!");
	}
	
}
