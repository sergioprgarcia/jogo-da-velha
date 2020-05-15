package br.com.slpgarcia.jogodavelha.principal;

import br.com.slpgarcia.jogodavelha.exceptions.MovimentacaoInvalidaException;

public class Movimentar {
	
	private int i;
	
	private int j;

	public Movimentar(String movimentarStr) throws MovimentacaoInvalidaException {
		try {
			String [] tokens = movimentarStr.split(",");
			this.i = Integer.parseInt(tokens[0]);
			this.j = Integer.parseInt(tokens[1]);
		}

		catch (Exception e){
			throw new MovimentacaoInvalidaException("A jogada é invalida");
		}

	}
	
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	

}
