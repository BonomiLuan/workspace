package controller;

public class instrucoesController {

	Arquivo instrucao = new Arquivo("a.txt");
	
	public void instrucoes() {
		
		String comando = instrucao.getPalavra(0, 0);
		
		
		switch (comando.toLowerCase()) {
		
			case "LDC":
				
				break;
		}
		
	}
	
}
