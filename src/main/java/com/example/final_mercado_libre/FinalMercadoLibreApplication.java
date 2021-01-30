package com.example.final_mercado_libre;

import com.example.final_mercado_libre.entities.Mutante;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalMercadoLibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalMercadoLibreApplication.class, args);

		//String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		//Mutante h1 = Mutante.builder().nombre("Logan").apellido("Howlett").dni(123456).dna(adn).build();
		//boolean mutante;
		//h1.isMutant(adn);
	}
}

// ATGCGA
// CAGTGC
// TTATGT
// AGAAGG
// CCCCTA
// TCACTG