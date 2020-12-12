/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financial.mini.indice;

import java.io.IOException;

/**
 *
 * @author jader
 */
public class StatisticLetter {
    
    public void verificarProbabilidades(String padrao) throws IOException {
        StatisticService service = new StatisticService();
        service.probabilidade(padrao);
    }
}
