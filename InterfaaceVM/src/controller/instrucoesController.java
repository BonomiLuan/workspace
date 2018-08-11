package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class instrucoesController {
	
	public void instrucoesController() {
		Scanner ler = new Scanner(System.in);
		String nomeArquivo =  "nomeArquivo.txt" ;
		try {
			FileReader arquivo = new FileReader(nomeArquivo);
			BufferedReader lerArq = new BufferedReader(arquivo);
			
			String linha = lerArq.readLine();
			
			while(linha != null){
				System.out.printf("%s\n", linha);
				
				linha = lerArq.readLine();
			}
			
		}catch (IOException e){
			System.out.printf("Erro ao abrir o arquivo: %s", e.getMessage());
		}		
	}

	
}
