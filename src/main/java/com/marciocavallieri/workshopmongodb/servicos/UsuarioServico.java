package com.marciocavallieri.workshopmongodb.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.repositorios.UsuarioRepositorio;

import dto.UsuarioDto;

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
	
	public Usuario inserir(Usuario obj) {
		return repositorio.insert(obj);
	}
	
	public void deletar(String id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Usuario obj) {
		Optional<Usuario> novo = repositorio.findById(obj.getId());
		
		AtualizarDados(obj, novo);
		
		return repositorio.save(novo.get());
	}
	
	private void AtualizarDados(Usuario obj, Optional<Usuario> novo) {
		novo.get().setNome(obj.getNome());
		novo.get().setEmail(obj.getEmail());
	}

	public Usuario fromDTO(UsuarioDto obj) {
		return new Usuario(obj.getId(), obj.getNome(), obj.getEmail());
	}
	
}
