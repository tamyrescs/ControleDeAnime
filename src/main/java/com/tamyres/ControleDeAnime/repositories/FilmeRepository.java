package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	
}
