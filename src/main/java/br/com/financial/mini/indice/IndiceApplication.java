package br.com.financial.mini.indice;

import java.util.HashMap;
import java.util.Iterator;
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
            HashMap hashMap = this.candles();
            Iterator it = hashMap.keySet().iterator();
            while(it.hasNext()){
                String candle = (String) it.next();
                for (int posicao = 1; posicao <= 3; posicao++) {
                    statisticLetter.verificarProbabilidades(candle, posicao);
                }
            }
        } else {
            statisticLetter.verificarProbabilidades(args[0], Integer.parseInt(args[1]));
        }
    }

    private HashMap<String, String> candles() {

        HashMap map = new HashMap();
        map.put("AAA","AAA");
        map.put("AAV","AAV");
        map.put("AVA","AVA");
        map.put("AVV","AVV");
        map.put("VAA","VAA");
        map.put("VAV","VAV");
        map.put("VVA","VVA");
        map.put("VVV","VVV");

        return map;
    }
}
