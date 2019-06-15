package com.tamyres.ControleDeAnime.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.Download;
import com.tamyres.ControleDeAnime.repositories.DownloadRepository;
import com.tamyres.ControleDeAnime.services.exception.ObjectNotFoundException;

@Service
public class DownloadService {

	
	@Autowired
	private DownloadRepository repo;
	
	public Download find(Integer id) {
		Optional<Download> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Download.class.getName()));
		}
}
