package com.tamyres.ControleDeAnime.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.Avaliacao;
import com.tamyres.ControleDeAnime.domain.Midia;
import com.tamyres.ControleDeAnime.domain.Usuario;
import com.tamyres.ControleDeAnime.dto.UsuarioDTO;
import com.tamyres.ControleDeAnime.dto.UsuarioNewDTO;
import com.tamyres.ControleDeAnime.repositories.MidiaRepository;
import com.tamyres.ControleDeAnime.repositories.UsuarioRepository;
import com.tamyres.ControleDeAnime.services.exception.DataIntegrityException;
import com.tamyres.ControleDeAnime.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private MidiaRepository midiaRepository;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		midiaRepository.saveAll(obj.getMidias());
		return obj;
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getLogin(), objDto.getSenha(), null, null, null, null);
	}

	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario usu = new Usuario(null, objDto.getLogin(), objDto.getSenha(), objDto.getEmail(), null, null, null);
		Avaliacao aval = new Avaliacao(objDto.getAvaliacaoId(), null, null);
		
		Midia mid = new Midia(null, objDto.getNomeMidia(), objDto.getLegenda(), objDto.getDirecao(), objDto.getElenco(),
				objDto.getLegenda(), objDto.getDataLancamento(), usu, aval);

		usu.getMidias().add(mid);

		return usu;
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());

	}
}
