package br.com.brixtal.heroes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.brixtal.heroes.controller.HeroController;
import br.com.brixtal.heroes.controller.PowerController;
import br.com.brixtal.heroes.controller.UniverseController;
import br.com.brixtal.heroes.jpa.Hero;
import br.com.brixtal.heroes.jpa.Power;
import br.com.brixtal.heroes.jpa.Universe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroesApplicationTests {

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void insertNewHero() {
		Hero hero = new Hero();
		PowerController pc = new PowerController();
		HeroController hc = new HeroController();
		UniverseController uc = new UniverseController();
		
		List<Power> allPowers = pc.getAllPower();
		
		List<Universe> allUniverses = uc.getAllUniverses();
		
		String name = "Heroi Teste";
		hero.setName(name);
		hero.setActive(true);
		hero.setPowerList(allPowers);
		hero.setUniverse(allUniverses.get(0));
		hero.setCreatedAt(new Date());
		
		hero = hc.insertHero(hero);
		
		assertThat(hero.getName()).isEqualTo(name);
		
	}

}
