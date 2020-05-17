package br.com.slpgarcia.jogodavelha.placar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.slpgarcia.jogodavelha.principal.Jogador;

public class GerenciadorArquivosPontuacao implements GerenciadorPlacar {

	private static final Path ARQUIVO_PLACAR = Path.of("placar.txt");
	private Map<String, Integer> placarMap = new HashMap<>();
	
	public GerenciadorArquivosPontuacao() throws IOException {
		
		setUp();
		
	}
	
	private void setUp() throws IOException {
		if(!Files.exists(ARQUIVO_PLACAR)) {
			Files.createFile(ARQUIVO_PLACAR);
		}
		
		try(BufferedReader reader = Files.newBufferedReader(ARQUIVO_PLACAR)) {
			String linha;
			while((linha = reader.readLine()) != null) {
				String[] tokens = linha.split("\\|");
				
				placarMap.put(tokens[0], Integer.parseInt(tokens[1]));
				
			}
		}
		
	}

	@Override
	public Integer getPlacar(Jogador jogador) {
		return placarMap.get(jogador.getNome().toUpperCase());
	}

	@Override
	public void salvarPlacar(Jogador jogador) throws IOException {
		Integer placar = getPlacar(jogador);
		
		if(placar == null) {
			placar = 0;
		}
		
		placarMap.put(jogador.getNome().toUpperCase(), placar + 1);
		
		try(BufferedWriter writer = Files.newBufferedWriter(ARQUIVO_PLACAR)){
			Set<Map.Entry<String, Integer>> entradas = placarMap.entrySet();
			
			for (Map.Entry<String, Integer> entrada : entradas) {
				String nome = entrada.getKey().toUpperCase();
				Integer pontos = entrada.getValue();
				writer.write(nome + "|" + pontos);
				writer.newLine();
			}
		}
	}

}