package br.com.financial.mini.indice;

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
        
        statisticLetter.verificarProbabilidades(args[0]);
    }

}
