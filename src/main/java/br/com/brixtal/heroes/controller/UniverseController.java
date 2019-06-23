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
    public List<Universe> getAllUniverses() {		
        List<Universe> result = universeRepository.findAll();
        
        if(result.size() == 0) {
        	insertUniverses();
        	result = universeRepository.findAll();
        }
        
        return result;
    }
	
	public void insertUniverses() {
		Universe u = new Universe();
		
		u.setId(1L);
		u.setDescription("EY Comics");
		
		universeRepository.save(u);
		
		u.setId(2L);
		u.setDescription("Trainee Comics");
		
		universeRepository.save(u);
		
		u.setId(3L);
		u.setDescription("Outros");
		
		universeRepository.save(u);
	}
}
