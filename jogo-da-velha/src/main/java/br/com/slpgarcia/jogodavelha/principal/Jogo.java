package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.ui.UI;

public class Jogo {
	
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador[] jogadores = new Jogador[Constants.SIMBOLO_JOGADORES.length];
	
	public void jogar() {
		
		UI.imprirTituloJogo();
		
		tabuleiro.imprimir();
		
	}

}
