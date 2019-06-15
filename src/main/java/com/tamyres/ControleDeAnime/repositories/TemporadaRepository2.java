package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Temporada;

@Repository
public interface TemporadaRepository2 extends JpaRepository<Temporada, Integer> {

	
}
