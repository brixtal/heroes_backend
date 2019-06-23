package br.com.brixtal.heroes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.brixtal.heroes.jpa.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
	
	
	@Query("SELECT h FROM Hero h WHERE h.active = true")
	public List<Hero> findAllActiveHeroes(Sort sort);
	
	
}
