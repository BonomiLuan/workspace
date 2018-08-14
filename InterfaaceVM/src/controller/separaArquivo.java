package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class separaArquivo {

	public String getPalavra(String linha, int index) {

		String[] palavra = linha.split(" "); // separa por "espaço" e aloca cada palavra em cada posição do vetor
		
		return palavra[index];
	}
	
}
