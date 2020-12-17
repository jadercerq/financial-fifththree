package br.com.financial.mini.indice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IndiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StatisticLetter statisticLetter = new StatisticLetter();

        if (args[0].equals("all")) {
            Integer candleChoice = args.length > 1 ? Integer.parseInt(args[1]) : 0;
            TreeMap treeMap = this.candles();
            Iterator it = treeMap.keySet().iterator();
            while (it.hasNext()) {
                String candle = (String) it.next();
                if (candleChoice > 0) {
                    statisticLetter.verificarProbabilidades(candle, candleChoice);
                } else {
                    for (int posicao = 1; posicao <= 3; posicao++) {
                        statisticLetter.verificarProbabilidades(candle, posicao);
                    }
                }
            }
        } else {
            statisticLetter.verificarProbabilidades(args[0], Integer.parseInt(args[1]));
        }
    }

    private TreeMap<String, String> candles() {

        TreeMap map = new TreeMap();
        map.put("AAA", "AAA");
        map.put("AAV", "AAV");
        map.put("AVA", "AVA");
        map.put("AVV", "AVV");
        map.put("VAA", "VAA");
        map.put("VAV", "VAV");
        map.put("VVA", "VVA");
        map.put("VVV", "VVV");

        return map;
    }
}
