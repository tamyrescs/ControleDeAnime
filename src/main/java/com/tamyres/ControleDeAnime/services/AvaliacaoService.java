package com.tamyres.ControleDeAnime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.Avaliacao;
import com.tamyres.ControleDeAnime.dto.AvaliacaoDTO;
import com.tamyres.ControleDeAnime.repositories.AvaliacaoRepository;
import com.tamyres.ControleDeAnime.services.exception.DataIntegrityException;
import com.tamyres.ControleDeAnime.services.exception.ObjectNotFoundException;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repo;

	public Avaliacao find(Integer id) {
		Optional<Avaliacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Avaliacao.class.getName()));
	}

	public Avaliacao insert(Avaliacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Avaliacao update(Avaliacao obj) {
		Avaliacao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<Avaliacao> findAll() {
		return repo.findAll();
	}
	
	public Page<Avaliacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Avaliacao fromDTO(AvaliacaoDTO objDto) {
		return new Avaliacao (objDto.getId(), objDto.getComentario(),objDto.getQtdEstrelas()); 
	}
	
	private void updateData(Avaliacao newObj, Avaliacao obj) {
		newObj.setMidia(obj.getMidia());
	}
}
