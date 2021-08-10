package com.avisos.avisosAulaVital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.avisos") // Avisa ao Spring quais pacotes devem ser lidos a procura de componentes
/*
* Procura no pacote mencionado - ou nos pacotes mencionados no atributo "basePackages" -
* qualquer interface que possua uma Spring Data interface
* */
@EnableMongoRepositories("com.avisos")
public class AvisosAulaVitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvisosAulaVitalApplication.class, args);
	}

}
