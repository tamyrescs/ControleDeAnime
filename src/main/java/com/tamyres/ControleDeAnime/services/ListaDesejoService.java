package com.tamyres.ControleDeAnime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.ListaDesejo;
import com.tamyres.ControleDeAnime.dto.ListaDesejoDTO;
import com.tamyres.ControleDeAnime.repositories.ListaDesejoRepository;
import com.tamyres.ControleDeAnime.services.exception.DataIntegrityException;
import com.tamyres.ControleDeAnime.services.exception.ObjectNotFoundException;

@Service
public class ListaDesejoService {

	@Autowired
	private ListaDesejoRepository repo;

	public ListaDesejo find(Integer id) {
		Optional<ListaDesejo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ListaDesejo.class.getName()));
	}

	public ListaDesejo insert(ListaDesejo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public ListaDesejo update(ListaDesejo obj) {
		ListaDesejo newObj = find(obj.getId());
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

	public List<ListaDesejo> findAll() {
		return repo.findAll();
	}
	
	public Page<ListaDesejo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public ListaDesejo fromDTO(ListaDesejoDTO objDto) {
		return new ListaDesejo (objDto.getId()); 
	}
	
	private void updateData(ListaDesejo newObj, ListaDesejo obj) {
		newObj.setId(obj.getId());
	}
	
}
