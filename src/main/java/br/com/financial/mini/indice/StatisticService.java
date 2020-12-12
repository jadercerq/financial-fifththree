/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financial.mini.indice;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author jader
 */
public class StatisticService {

    private final StatisticDAO statisticDAO = new StatisticDAO();
    
    public Long probabilidade(String padrao) throws IOException {
        float qtdPadraoEncontrado = 0;
        float qtdCompra = 0;
        float qtdVenda = 0;
        float qtdIndefinicao = 0;

        List<String[]> dados = statisticDAO.obterDadosDiarioArquivo();

        for (String[] dado : dados) {
            for (int i = 0; i < dado.length - 1; i++) {
                String conjunto = dado[i];
                if (conjunto.equals(padrao.toUpperCase())) {
                    qtdPadraoEncontrado++;
                    if (dado[i + 1].startsWith("A")) {
                        qtdCompra++;
                    } else if (dado[i + 1].startsWith("I")) {
                        qtdIndefinicao++;
                    } else {
                        qtdVenda++;
                    }
                }
            }
        }

        System.out.println(" ");
        System.out.println("############################################");
        System.out.println("#                   ".concat(padrao.toUpperCase()).concat("                   #"));
        System.out.println("############################################");
        System.out.println("Quantidade de vezes que ocorreu o padrao ..: " + qtdPadraoEncontrado);
        System.out.println("Probabilidade de acerto na compra .........: " + ((qtdCompra / qtdPadraoEncontrado) * 100) + "%");
        System.out.println("Probabilidade de acerto na venda ..........: " + ((qtdVenda / qtdPadraoEncontrado) * 100) + "%");
        System.out.println("Quantidade de indefinicoes .................: " + qtdIndefinicao);

        return 0l;
    }
}
