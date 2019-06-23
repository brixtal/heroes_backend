package br.com.brixtal.heroes.repository;

import br.com.brixtal.heroes.jpa.Hero;
import br.com.brixtal.heroes.jpa.Power;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {

}
