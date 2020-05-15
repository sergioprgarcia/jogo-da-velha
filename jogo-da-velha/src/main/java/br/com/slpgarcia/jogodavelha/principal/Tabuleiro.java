package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.Constants;
import br.com.slpgarcia.jogodavelha.ui.UI;

public class Tabuleiro {

	private char [][] matriz;

	public Tabuleiro() {
		matriz = new char [Constants.TAMANHO_TABULEIRO] [Constants.TAMANHO_TABULEIRO];
		limpar();

	}

	public void limpar() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	} 

	public void imprimir() {
		UI.imprimirNovaLinha();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				UI.imprimirTextoSemNovaLinha(String.valueOf(matriz[i][j]));

				if(j < matriz[i].length - 1 ){
					UI.imprimirTextoSemNovaLinha("  |");
				}
			}

			UI.imprimirNovaLinha();

			if( i < matriz[i].length -1 ) {
				UI.imprimirTexto("-----------");
			}
		}
	}		

	public boolean estaCheio() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == ' ') {
					return false;
				}
			}
		}

		return true;
	}

	public boolean jogar(Jogador jogador, Movimentar movimentar) {
		int i = movimentar.getI();
		int j = movimentar.getJ();

		//TODO valimentar os movimentos do jogador

		matriz[i][j] = jogador.getSimbolo();
		
		
		return checarLinhas(jogador) || checarColunas(jogador) || checarDiagonalDir(jogador) || checarDiagonalEsq(jogador);
	}

	private boolean checarLinhas(Jogador jogador) {
		for(int i = 0; i < Constants.TAMANHO_TABULEIRO; i++) {
			if (checarLinha(i, jogador)) {
				return true;
			}
		}

		return false;
	}

	private boolean checarLinha(int i, Jogador jogador) {
		char simbolo = jogador.getSimbolo();


		for(int j = 0; j < Constants.TAMANHO_TABULEIRO; j++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}

		return true;
	}

	private boolean checarColunas(Jogador jogador) {
		for(int j = 0; j < Constants.TAMANHO_TABULEIRO; j++) {
			if (checarLinha(j, jogador)) {
				return true;
			}
		}

		return false;
	}

	private boolean checarColuna(int j, Jogador jogador) {
		char simbolo = jogador.getSimbolo();


		for(int i = 0; i < Constants.TAMANHO_TABULEIRO; i++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}

		return true;
	}

	private boolean checarDiagonalEsq(Jogador jogador) {
		char simbolo = jogador.getSimbolo();

		for(int i = 0; i < Constants.TAMANHO_TABULEIRO; i++) {
			if(matriz[i][i] != simbolo) {
				return false;
			}
		}
		return true;
	}

	private boolean checarDiagonalDir(Jogador jogador) {
		char simbolo = jogador.getSimbolo();
		int ultimaLinha = Constants.TAMANHO_TABULEIRO -1;

		for(int i = ultimaLinha, j = 0; i >= 0; i--, j++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}
		return true;
	}

}
