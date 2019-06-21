package br.com.brixtal.heroes.repository;

import br.com.brixtal.heroes.jpa.Power;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {

	
}
