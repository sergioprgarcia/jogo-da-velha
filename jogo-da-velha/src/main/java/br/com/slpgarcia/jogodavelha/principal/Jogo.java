package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.ui.UI;

public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador[] jogadores = new Jogador[Constants.SIMBOLO_JOGADORES.length];

	public void jogar() {
 
		UI.imprirTituloJogo();

		for(int i = 0; i < jogadores.length; i++) {
			jogadores[i] = criarJogador(i);
		}

	}

	private Jogador criarJogador(int index) {
		String nome = UI.entradaDados("Jogador " + (index + 1) + " =>");
		char simbolo = Constants.SIMBOLO_JOGADORES[index];
		Jogador jogador = new Jogador(nome, tabuleiro, simbolo);

		UI.imprimirTexto("O jogador '" + nome + "' vai usar o símbolo '" + simbolo + "'");
		return jogador;
	}


}
