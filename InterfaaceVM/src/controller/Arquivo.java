package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Arquivo {
	
	private List<String> minhaLista;
	
	public Arquivo() {
	}
	
	public String getLinha(int index) {
		return minhaLista.get(index);
	}
	
	public String getPalavra(int indexLinha, int indexPalavra) {
        String linha = String.valueOf(getLinha(indexLinha));
        String[] palavra = linha.split(" ");

        try{
            return palavra[indexPalavra];
        } catch (ArrayIndexOutOfBoundsException e) {
            // Caso nao exista o index, retorna String vazia
            return "";
        }
    }
	
	public void lerArquivo(JTable instructionsTable){
		JFileChooser fileChooser = new JFileChooser();
		minhaLista = new ArrayList<>();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Stream<String> stream = Files.lines(Paths.get(selectedFile.getAbsolutePath()))) {
            	minhaLista = (ArrayList<String>) stream.collect(Collectors.toList());
            	populateTables(instructionsTable);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	private void populaPilhaPrint(DefaultTableModel tabelaPilha, Pilha pilha) {
        for(int i=0 ; i <= pilha.getTopo() ; i++) {
            System.out.println("Valor da pilha > " + pilha.getValor(i));
            Object[] palavra = new Object[] {i, pilha.getValor(i)};
            palavra = adicionaElemento(palavra, palavra);
            tabelaPilha.addRow(palavra);
        }
    }
	
	private void populateTables(JTable instructionsTable) {
        DefaultTableModel model = (DefaultTableModel) instructionsTable.getModel();
        clearAllRows(model);
        for(int i=0 ; i < minhaLista.size() ; i++) {
            Object[] palavra = new Object[] {i};

            String comando = getPalavra(i, 0);
            String param1 = getPalavra(i, 1);
            String param2 = getPalavra(i, 2);
            if(comando.equals("ALLOC") || comando.equals("DALLOC"))
            {
                String[] params = getPalavra(i, 1).split(",");
                param1 = params[0];
                param2 = params[1];
            }

            palavra = adicionaElemento(palavra, comando);
            palavra = adicionaElemento(palavra, param1);
            palavra = adicionaElemento(palavra, param2);
            model.addRow(palavra);
        }
    }
	
	private void clearAllRows(DefaultTableModel model) {
        model.getRowCount();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
	
	private Object[] adicionaElemento(Object[] obj, Object newObj) {
        ArrayList<Object> temp = new ArrayList<>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();
    }
}
