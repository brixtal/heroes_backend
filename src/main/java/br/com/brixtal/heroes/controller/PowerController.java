package br.com.brixtal.heroes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{word}")
	public List<Power> getAllPower(@PathVariable("word") String word) {
		List<Power> result = powerRepository.findAll();
		List<Power> finalResult = new ArrayList<>();
		for(int i = 0; i < result.size(); i++) {
			Boolean hasText = result.get(i).getDescription().toLowerCase().indexOf(word.toLowerCase()) >= 0;
			if(hasText)  {
				finalResult.add(result.get(i));
			}
		}
		return finalResult;
	}

	@PostMapping("/")
	public Power insertPower(@RequestBody Power power) {
		System.out.println("Novo poder: " + power.getDescription());
		return powerRepository.save(power);
	}
}
