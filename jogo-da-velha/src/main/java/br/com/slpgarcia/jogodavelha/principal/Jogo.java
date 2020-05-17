package br.com.slpgarcia.jogodavelha.principal;

import java.io.IOException;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.exceptions.MovimentacaoInvalidaException;
import br.com.slpgarcia.jogodavelha.placar.GerenciadorArquivosPontuacao;
import br.com.slpgarcia.jogodavelha.placar.GerenciadorPlacar;
import br.com.slpgarcia.jogodavelha.ui.UI;



public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador[] jogadores = new Jogador[Constants.SIMBOLO_JOGADORES.length];
	private int indexJogadorAtual = -1;
	private GerenciadorPlacar gerenciadorPlacar;


	public void jogar() throws IOException {
		gerenciadorPlacar = criarGerenciadorPlacar();
		
		UI.imprirTituloJogo();

		for(int i = 0; i < jogadores.length; i++) {
			jogadores[i] = criarJogador(i);
		}

		boolean jogoTerminou = false;
		Jogador jogadorAtual = proximoJogador();
		Jogador vencedor = null;

		while(!jogoTerminou) {
			tabuleiro.imprimir();
			boolean achouSequencia;

			try {
				achouSequencia = jogadorAtual.jogar();
			} catch (MovimentacaoInvalidaException e) {
				UI.imprimirTexto("ERRO: " + e.getMessage());
				continue;
			}
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
			gerenciadorPlacar.salvarPlacar(vencedor);
		}

		tabuleiro.imprimir();
		UI.imprimirTexto("Fim do jogo!");
	}

	private Jogador criarJogador(int index) {
		String nome = UI.entradaDados("Jogador " + (index + 1) + " =>");
		char simbolo = Constants.SIMBOLO_JOGADORES[index];
		Jogador jogador = new Jogador(nome, tabuleiro, simbolo);
		
		Integer placar = gerenciadorPlacar.getPlacar(jogador);
		if(placar != null) {
			UI.imprimirTexto("O jogador '" + jogador.getNome() + "' já possui " + placar + "vitórias(s)!");
		} 

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

	private GerenciadorPlacar criarGerenciadorPlacar() throws IOException {
		return new GerenciadorArquivosPontuacao();
	}
	
	
}
