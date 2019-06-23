package br.com.brixtal.heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brixtal.heroes.repository.UniverseRepository;

@SpringBootApplication
public class HeroesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(HeroesApplication.class, args);
	}

}
