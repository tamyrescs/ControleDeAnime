package com.tamyres.ControleDeAnime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.Midia;
import com.tamyres.ControleDeAnime.dto.MidiaDTO;
import com.tamyres.ControleDeAnime.repositories.MidiaRepository;
import com.tamyres.ControleDeAnime.services.exception.DataIntegrityException;
import com.tamyres.ControleDeAnime.services.exception.ObjectNotFoundException;

@Service
public class MidiaService {
	@Autowired
	private MidiaRepository repo;

	public Midia find(Integer id) {
		Optional<Midia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Midia.class.getName()));
	}

	public Midia insert(Midia obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Midia update(Midia obj) {
		Midia newObj = find(obj.getId());
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

	public List<Midia> findAll() {
		return repo.findAll();
	}
	
	public Page<Midia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Midia fromDTO(MidiaDTO objDto) {
		return new Midia (objDto.getId(), objDto.getNomeMidia(),objDto.getLegenda(),null,null,null,null,null,null); 
	}
	
	private void updateData(Midia newObj, Midia obj) {
		newObj.setNomeMidia(obj.getNomeMidia());
	}
	
}
