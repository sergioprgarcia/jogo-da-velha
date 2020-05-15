package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.ui.UI;

public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador[] jogadores = new Jogador[Constants.SIMBOLO_JOGADORES.length];
	private int indexJogadorAtual = -1;
	

	public void jogar() {
 
		UI.imprirTituloJogo();

		for(int i = 0; i < jogadores.length; i++) {
			jogadores[i] = criarJogador(i);
		}

		boolean jogoTerminou = false;
		Jogador jogadorAtual = proximoJogador();
		Jogador vencedor = null;

		while(!jogoTerminou) {
			tabuleiro.imprimir();

			boolean achouSequencia = jogadorAtual.jogar();

			if(achouSequencia) {
				jogoTerminou = true;
				vencedor = jogadorAtual;
				
			} else if (tabuleiro.estaCheio()) {
				jogoTerminou = true;
			}
			
			jogadorAtual = proximoJogador();
		}	
		
		if(vencedor == null) {
			UI.imprimirTexto("O jogo termionu empatado");
		} else {
			UI.imprimirTexto("O jogador '" + vencedor.getNome() + "' venceu o jogo!");
		}
		
		tabuleiro.imprimir();
		UI.imprimirTexto("Fim do jogo!");
	}

	private Jogador criarJogador(int index) {
		String nome = UI.entradaDados("Jogador " + (index + 1) + " =>");
		char simbolo = Constants.SIMBOLO_JOGADORES[index];
		Jogador jogador = new Jogador(nome, tabuleiro, simbolo);

		UI.imprimirTexto("O jogador '" + nome + "' vai usar o símbolo '" + simbolo + "'");
		return jogador;
	}
	
	private Jogador proximoJogador() {
	/*	indexJogadorAtual++;
		
		if(indexJogadorAtual >= jogadores.length) {
			indexJogadorAtual = 0;
		}
		return jogadores[indexJogadorAtual];
	}
	*/
		indexJogadorAtual = (indexJogadorAtual + 1) % jogadores.length;
		return jogadores[indexJogadorAtual];
		
	}

}
