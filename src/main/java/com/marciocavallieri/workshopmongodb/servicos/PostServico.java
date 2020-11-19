package com.marciocavallieri.workshopmongodb.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciocavallieri.workshopmongodb.dominio.Post;
import com.marciocavallieri.workshopmongodb.repositorios.PostRepositorio;

@Service
public class PostServico {
	@Autowired
	private PostRepositorio repositorio;

	public Post obterPorId(String id) {
		Optional<Post> p = repositorio.findById(id);

		if (!p.isPresent()) {
			throw new ObjectNotFoundException("Post não encontrado...");
		}

		return p.get();
	}

	public List<Post> obterPorTituloContendo(String texto) {
		return repositorio.findByTituloContainingIgnoreCase(texto);
		// return repositorio.findByOcorrenciaNoTitulo(texto);
	}

	public List<Post> findByOcorrenciaNoTituloComIntervaloDeData(String texto, Date dataInicial, Date dataFinal) {
		dataFinal = new Date(dataInicial.getTime() - 24 * 60 * 60 * 1000); 
		
		return repositorio.findByOcorrenciaNoTituloComIntervaloDeData(texto, dataInicial, dataFinal);
	}
}
