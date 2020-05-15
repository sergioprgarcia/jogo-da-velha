package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.ui.UI;

public class Jogo {
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Jogador[] jogadores = new Jogador[Constants.SIMBOLO_JOGADORES.length];
	
	public void jogar() {
		
		UI.imprirTituloJogo();
		
	}

}
