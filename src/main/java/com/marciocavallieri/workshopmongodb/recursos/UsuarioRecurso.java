package com.marciocavallieri.workshopmongodb.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
