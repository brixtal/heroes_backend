package br.com.brixtal.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brixtal.heroes.jpa.Universe;
import br.com.brixtal.heroes.repository.UniverseRepository;

@RestController
@RequestMapping("/heroes-api/universe")
public class UniverseController {
	
	@Autowired
	private UniverseRepository universeRepository;
	
	@GetMapping("/")
    public List<Universe> getAllEmployees() {
        return universeRepository.findAll();
    }
}
