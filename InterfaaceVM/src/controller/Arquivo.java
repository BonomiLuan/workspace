package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arquivo {
	
	private List<String> minhaLista;
	
	public Arquivo(String fileName) {
		populaLista(fileName);
	}
	
	private void populaLista(String nomeArquivo){
		minhaLista = new ArrayList<>();
		try(Stream<String> stream = Files.lines(Paths.get(nomeArquivo))) {
			minhaLista = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getLinha(int index) {
		return minhaLista.get(index);
	}
	
	public String getPalavra(int index, int indexPalavra) {
		
		String linha = getLinha(index);
		
		String[] palavra = linha.split(" "); // separa por "espaço" e aloca cada palavra em cada posição do vetor
		
		return palavra[indexPalavra];
	}
	
}
