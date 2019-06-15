package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.ListaDesejo;

@Repository
public interface ListaDesejoRepository extends JpaRepository<ListaDesejo, Integer> {

	
}
