package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta();
		
		conta.setBanco("Santander");
		conta.setNumero("9999909");
		conta.setAgencia("999");
		conta.setTitular("Maria da Silva");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz - Maio/15");
		movimentacao.setValor(new BigDecimal("125"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
	
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Movimentacao adicionada com sucesso!");
	}
}
