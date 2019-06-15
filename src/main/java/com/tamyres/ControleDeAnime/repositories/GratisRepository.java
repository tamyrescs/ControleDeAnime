package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Gratis;

@Repository
public interface GratisRepository extends JpaRepository<Gratis, Integer> {

	
}
