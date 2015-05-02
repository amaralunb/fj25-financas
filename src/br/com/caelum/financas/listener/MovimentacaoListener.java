package br.com.caelum.financas.listener;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoListener {
	
	Movimentacao movimentacao;
	
	@PrePersist
	@PreUpdate
	public void preAltera(Movimentacao movimentacao) {
		System.out.println("Atualizando a data da movimentacao");
		movimentacao.setData(Calendar.getInstance());
	}
	
}
