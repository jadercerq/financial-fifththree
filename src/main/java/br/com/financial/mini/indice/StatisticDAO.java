/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financial.mini.indice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jader
 */
public class StatisticDAO {

    public List<String[]> obterDadosDiarioArquivo(int candle) throws FileNotFoundException, IOException {

        List<String[]> dados = new ArrayList<>();

        InputStreamReader reader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("banco.txt"));
        BufferedReader br = new BufferedReader(reader);
        String registroDiario = br.readLine();
        while (registroDiario != null) {
            int quantidadeCandle5min = 3;
            int candleInicial = candle - 1;
            int candleFinal = candle - 1;
            int posicao = 0;
            String[] padrao = new String[12];
            for (int jump = candleInicial; jump < registroDiario.length(); jump++) {
                try {
                    padrao[posicao++] = registroDiario.substring(jump, candleFinal + quantidadeCandle5min);
                } catch (StringIndexOutOfBoundsException e) {
                    padrao[--posicao] = registroDiario.substring(jump, registroDiario.length());
                }
                jump = jump + (quantidadeCandle5min - 1);
                candleFinal += quantidadeCandle5min;
            }
            dados.add(padrao);
            registroDiario = br.readLine();
        }

        return dados;
    }
}
