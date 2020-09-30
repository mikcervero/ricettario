package jdk.ricettario;


import javax.annotation.PostConstruct;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import jdk.ricettario.domain.Ricetta;
import jdk.ricettario.domain.RicettaService;



@SpringBootApplication
public class RicettarioApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(RicettarioApplication.class, args);
		 
	}
	
//	@PostConstruct
//	public void init() {
//
//		Ricetta ricetta = new Ricetta();
//		ricetta.setAutore("Mario");
//		ricetta.setNomeRicetta("Carbonara");
//		ricetta.setDurata("20 minuti");
//		ricetta.setDescrizione("fai la pasta e poi buttaci le uova");
//
//	}

}
