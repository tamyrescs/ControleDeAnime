package com.tamyres.ControleDeAnime.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamyres.ControleDeAnime.domain.Avaliacao;
import com.tamyres.ControleDeAnime.domain.Midia;
import com.tamyres.ControleDeAnime.domain.Usuario;
import com.tamyres.ControleDeAnime.repositories.AvaliacaoRepository;
import com.tamyres.ControleDeAnime.repositories.MidiaRepository;
import com.tamyres.ControleDeAnime.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private MidiaRepository midiaRepository;
	
	@Autowired 
	private AvaliacaoRepository avaliacaoRepository;
	public void instantiateTestDatabase() throws ParseException {
	

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");
	
	Usuario usu1 = new Usuario(null, "tamyrescs","1234","Tamyres Carla","tamyrescarla@gmail.com", "83993952690",sdf.parse("11/08/1997")); 
	Usuario usu2 = new Usuario(null, "thaiscs","4321","Thaís Karla","thaiskarla@gmail.com", "83999952600",sdf.parse("01/06/1992")); 
	
	usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
	
	Avaliacao aval = new Avaliacao(null, "gosteiiiiiiii",5);
	
	avaliacaoRepository.saveAll(Arrays.asList(aval));
	
	
	Midia mid1 = new Midia(null, "Naruto", "HD","Português", null, null, sdf.parse("01/06/2019"), usu1, aval);
	
	midiaRepository.saveAll(Arrays.asList(mid1));
}
	
}
