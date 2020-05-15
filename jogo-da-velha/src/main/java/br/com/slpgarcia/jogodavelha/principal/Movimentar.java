package br.com.slpgarcia.jogodavelha.principal;

public class Movimentar {
	
	private int i;
	
	private int j;

	public Movimentar(String movimentarStr) {
		
		String [] tokens = movimentarStr.split(",");
		
		this.i = Integer.parseInt(tokens[0]);
		this.j = Integer.parseInt(tokens[1]);
		
		//TODO validar se a estrutura está correta
		
	}
	


	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	

}
