package com.marciocavallieri.workshopmongodb.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	@Autowired
	private UsuarioServico servico;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> obterTodos(){			
		List<Usuario> lista = servico.obterTodos();
				
		return ResponseEntity.ok(lista);
	}
}
