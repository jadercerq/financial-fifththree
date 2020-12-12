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
    
//    public List<String[]> obterDadosDiario() {
//        
//        
//        String[] d011220 = {"AVV","VAV","AAI","VAA","VVA","AAV","AAA","VAV","VVV","VVV","AVA","AAA"};
//        String[] d021220 = {"VAV","VAV","AVV","VAA","AAV","AVV","AAI","VVI","VVV","VVA","VAV","AVA"};
//        String[] d031220 = {"AVV","AAA","VVA","VAV","AAV","VAA","VAA","VVV","VAV","VAA","VAA","VAA"};
//        String[] d041220 = {"AAA","AVV","VAV","VVA","AVA","VVA","VAA","AVA","AAA","VVV","AAA","AAV"};
//        String[] d071220 = {"VAA","VAA","IAI","AAV","AVA","AAA","VAA","VAA","VVV","AAV","VIA","VVA"};
//        String[] d081220 = {"AVA","AAV","AVV","AAA","VVA","VAV","AAA","VVV","AVA","VVA","AAA","VIA"};
//        String[] d091220 = {"AVA","AVV","VVV","AVA","VAA","VAA","VAA","VAA","VVA","AVV","VVV","VAA"};
//        String[] d101220 = {"AAV","AAA","VAV","AAA","AVA","VAV","VVA","AVV","AVV","VVA","AAA","AAA"};
//        String[] d111220 = {"AVV","AAV","VAV","AAV","VAV","AVA","AVV","AAA","VVV","AAV","VAV","VVV"};
//
//        List<String[]> dados = new ArrayList<>();
//        dados.add(d011220);
//        dados.add(d021220);
//        dados.add(d031220);
//        dados.add(d041220);
//        dados.add(d071220);
//        dados.add(d081220);
//        dados.add(d091220);
//        dados.add(d101220);
//        dados.add(d111220);
//        
//        return dados;
//    }
    
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
