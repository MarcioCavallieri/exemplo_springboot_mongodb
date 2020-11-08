package com.marciocavallieri.workshopmongodb.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> obterTodos() {
		return repositorio.findAll();
	}
	
	public Usuario obterPorId(String id) {
		Optional<Usuario> u = repositorio.findById(id);
		
		if (! u.isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado...");
		}
		
		return u.get();
	}
}
