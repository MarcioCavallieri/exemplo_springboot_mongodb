package com.marciocavallieri.workshopmongodb.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.marciocavallieri.workshopmongodb.dominio.Post;
import com.marciocavallieri.workshopmongodb.servicos.PostServico;

@RestController
@RequestMapping(value = "/posts")
public class PostRecurso {
	@Autowired
	private PostServico servico;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> obterPorId(@PathVariable String id){			
		Post p = servico.obterPorId(id);
		
		return ResponseEntity.ok().body(p);
	}
}
