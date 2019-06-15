package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

	
}
