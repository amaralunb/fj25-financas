package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		ContaDao contaDao = new ContaDao(entityManager);
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		
		Conta conta = new Conta();
		
		conta.setBanco("Banco do Brasil");
		conta.setNumero("00123-9");
		conta.setAgencia("259");
		conta.setTitular("Guilherme Borges");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setDescricao("Depósito Bancário");
		movimentacao.setValor(new BigDecimal("2500"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
	
		entityManager.getTransaction().begin();
		
		contaDao.adiciona(conta);
		movimentacaoDao.adiciona(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Movimentacao adicionada com sucesso!");
	}
}
