package com.marciocavallieri.workshopmongodb.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.servicos.UsuarioServico;

import dto.UsuarioDto;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	@Autowired
	private UsuarioServico servico;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDto>> obterTodos(){			
		List<Usuario> lista = servico.obterTodos();
		List<UsuarioDto> listaDto = lista.stream().map(u -> new UsuarioDto(u)).collect(Collectors.toList());
		return ResponseEntity.ok(listaDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> obterPorId(@PathVariable String id){			
		Usuario u = servico.obterPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDto(u));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDto obj){			
		Usuario u = servico.fromDTO(obj);
		u = servico.inserir(u);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
