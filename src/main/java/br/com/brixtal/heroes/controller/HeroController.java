package br.com.brixtal.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brixtal.heroes.jpa.Power;
import br.com.brixtal.heroes.repository.PowerRepository;

@RestController
@RequestMapping("/heroes-api/hero")
public class HeroController {

	@Autowired
	private PowerRepository powerRepository;

	@GetMapping("/power")
	public List<Power> getAllEmployees() {
		return powerRepository.findAll();
	}
}
