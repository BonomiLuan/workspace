package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class separaArquivo {

	public String getPalavra(String linha, int index) {

		String[] palavra = linha.split(" "); // separa por "espa�o" e aloca cada palavra em cada posi��o do vetor
		
		return palavra[index];
	}
	
}
