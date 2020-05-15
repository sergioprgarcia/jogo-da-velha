package br.com.slpgarcia.jogodavelha.ui;

import br.com.slpgarcia.jogodavelha.config.Console;

public class UI {

	public static void imprimirTexto(String text) {
		System.out.println(text);
	}
	
	public static void imprimirTextoSemNovaLinha(String text) {
		System.out.print(text);
	}
	
	public static void imprimirNovaLinha() {
		System.out.println();
	}
	
	public static void imprirTituloJogo() {
		imprimirTexto("==================");
		imprimirTexto("|  JOGO DA VELHA |");
		imprimirTexto("==================");
		imprimirNovaLinha();
	}
	
	public static String entradaDados(String text) {
		imprimirTextoSemNovaLinha(text + " ");
		return Console.readString();
	}
	
}
