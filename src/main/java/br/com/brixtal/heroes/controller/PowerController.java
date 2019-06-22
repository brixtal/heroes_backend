package br.com.brixtal.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brixtal.heroes.jpa.Hero;
import br.com.brixtal.heroes.jpa.Power;
import br.com.brixtal.heroes.repository.PowerRepository;

@RestController
@RequestMapping("/heroes-api/power")
public class PowerController {

	@Autowired
	private PowerRepository powerRepository;

	@GetMapping("/")
	public List<Power> getAllPower() {
		return powerRepository.findAll();
	}

	@PostMapping("/")
	public Power insertPower(@RequestBody Power power) {
		return powerRepository.save(power);
	}
}
