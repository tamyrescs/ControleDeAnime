package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Sequencia;

@Repository
public interface SequenciaRepository extends JpaRepository<Sequencia, Integer> {

	
}
