package br.com.brixtal.heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brixtal.heroes.jpa.Universe;

@Repository
public interface UniverseRepository extends JpaRepository<Universe, Long> {

}
