package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.ui.UI;

public class Jogador {
	
	private String nome;
	private Tabuleiro tabuleiro;
	private char simbolo;

	public Jogador(String nome, Tabuleiro tabuleiro, char simbolo) {
		this.nome = nome;
		this.tabuleiro = tabuleiro;
		this.simbolo = simbolo;
	}

	private Movimentar movimentoEntrada() {
		String movimentarStr = UI.entradaDados("Jogador '" + nome + "' =>");
		return new Movimentar(movimentarStr);
	
	}
	
	public boolean jogar() {
	Movimentar movimentar = movimentoEntrada();
	return tabuleiro.jogar(this, movimentar);
		
	}

	public String getNome() {
		return nome;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public char getSimbolo() {
		return simbolo;
	}
	
	
	

}
