package com.marciocavallieri.workshopmongodb.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.marciocavallieri.workshopmongodb.dominio.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> obterTodos(){
		Usuario u1 = new Usuario("1","aaa","aaa");
		Usuario u2 = new Usuario("2","bbb","bbb");		
		List<Usuario> lista = new ArrayList<Usuario>();
		lista.addAll(Arrays.asList(u1, u2));
		
		return ResponseEntity.ok(lista);
	}
}
