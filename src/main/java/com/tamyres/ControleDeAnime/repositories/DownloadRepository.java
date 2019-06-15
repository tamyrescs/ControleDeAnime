package com.tamyres.ControleDeAnime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamyres.ControleDeAnime.domain.Download;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Integer> {

	
}
