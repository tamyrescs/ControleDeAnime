package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Midia;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Integer> {


/*	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Midia obj INNER JOIN obj.filmes fil WHERE obj.nome LIKE %:nome% AND fil IN :filmes")
	Page<Midia> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome,
			@Param("categorias") List<Midias> categorias, Pageable pageRequest);
*/
	
}
