package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

	
}
