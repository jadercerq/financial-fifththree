/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financial.mini.indice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jader
 */
public class StatisticDAO {
    
    public List<String[]> obterDadosDiarioArquivo() throws FileNotFoundException, IOException {
        
        List<String[]> dados = new ArrayList<>();
        
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\jader\\Documents\\NetBeansProjects\\banco_mini_indice\\banco.txt")).useDelimiter("\\n");
        while (scanner.hasNext()) {
            String linha = scanner.next();
            int jump = 3;
            int fim = 0;
            int indice = 0;
            String[] padrao = new String[12];
            for (int i = 0; i < linha.length(); i++) {
                padrao[indice++] = linha.substring(i, fim + jump);
                i = i + (jump - 1);
                fim += jump;
            }
            dados.add(padrao);
        }
        
        return dados;
    }
}
