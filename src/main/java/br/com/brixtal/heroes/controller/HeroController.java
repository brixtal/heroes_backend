package br.com.brixtal.heroes.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public List<Hero> getAllHeroes(HttpServletResponse response) {
		try {
			List<Hero> result = heroRepository.findAllActiveHeroes(new Sort(Sort.Direction.ASC, "id"));
			if (result.size() > 0) {
				return result;
			}
			// ELSE
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There is no active hero registred in our DB.",
					new Exception("No active hero found."));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An internal error occurred during your request.", e);
		}
	}
	
	@GetMapping("/{value}/{direction}")
	public List<Hero> getAllHeroesSortedByValue(HttpServletResponse response, @PathVariable String value, @PathVariable String direction) {
		Direction ord = Sort.Direction.ASC;
		if(direction.toLowerCase() == "desc") {
			ord = Sort.Direction.DESC;
		}
		try {
			List<Hero> result = heroRepository.findAllActiveHeroes(new Sort(ord, value));
			if (result.size() > 0) {
				return result;
			}
			// ELSE
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There is no active hero registred in our DB.",
					new Exception("No active hero found."));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An internal error occurred during your request.", e);
		}
	}

	@PostMapping("/")
	public Hero insertHero(@RequestBody Hero hero) {
		return heroRepository.save(hero);
	}

	@DeleteMapping("/{id}")
	public void deleteHero(@PathVariable Long id) {
		Optional<Hero> searchHeroToBeRemoved = heroRepository.findById(id);

		// If not found
		if (searchHeroToBeRemoved.orElse(null) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no active hero with ID " + id,
					new Exception("No active hero found."));
		}

		searchHeroToBeRemoved.ifPresent(heroToBeRemoved -> {
			if (heroToBeRemoved.getActive()) {
				heroToBeRemoved.setActive(false);
				heroRepository.save(heroToBeRemoved);
				return;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no active hero with ID " + id,
						new Exception("No active hero found."));
			}
		});
	}
}
