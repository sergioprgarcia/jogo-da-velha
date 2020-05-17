
package br.com.slpgarcia.jogodavelha.placar;

import java.io.IOException;

import br.com.slpgarcia.jogodavelha.principal.Jogador;

public interface GerenciadorPlacar {
	
	public Integer getPlacar(Jogador jogador);
	
	public void salvarPlacar(Jogador jogador) throws IOException;

}
