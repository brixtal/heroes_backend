package br.com.brixtal.heroes.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.brixtal.heroes.jpa.Hero;
import br.com.brixtal.heroes.repository.HeroRepository;

@RestController
@RequestMapping("/heroes-api/hero")
public class HeroController {

	@Autowired
	private HeroRepository heroRepository;

	@GetMapping("/")
	public List<Hero> getAllEmployees() {
		return heroRepository.findAll();
	}

	@PostMapping("/")
	public Hero insertHero(@RequestBody Hero hero) {
		return heroRepository.save(hero);
	}

	@DeleteMapping("/{id}")
	public void deleteHero(@PathVariable Long id) {
		Optional<Hero> searchHeroToBeRemoved = heroRepository.findById(id);
		Optional<Object> heroToBeRemoved = searchHeroToBeRemoved.map(hero -> {
			hero.setActive(false);
			return heroRepository.save(hero);
		});
	}
}
