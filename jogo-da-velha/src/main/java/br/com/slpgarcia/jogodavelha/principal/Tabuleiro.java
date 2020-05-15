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
		
		matriz[i][j] = jogador.getSimbolo();
		
		//TODO Checar se o jogador ganhou;
		return false;
		
	}
}
