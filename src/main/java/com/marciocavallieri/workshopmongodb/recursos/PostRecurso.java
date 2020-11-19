package com.marciocavallieri.workshopmongodb.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marciocavallieri.workshopmongodb.dominio.Post;
import com.marciocavallieri.workshopmongodb.servicos.PostServico;

import resource.util.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostRecurso {
	@Autowired
	private PostServico servico;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> obterPorId(@PathVariable String id) {
		Post p = servico.obterPorId(id);

		return ResponseEntity.ok().body(p);
	}

	@RequestMapping(value = "/buscadetitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> obterPorTituloContendo(
			@RequestParam(value = "text", defaultValue = "") String texto) {
		texto = URL.decodificarParametros(texto);
		List<Post> lista = servico.obterPorTituloContendo(texto);

		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/buscadetitulofull", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByOcorrenciaNoTituloComIntervaloDeData(
			@RequestParam(value = "text", defaultValue = "") String texto, 
			@RequestParam(value = "text", defaultValue = "") String dataInicial,
			@RequestParam(value = "text", defaultValue = "") String dataFinal) {

		Date ini = URL.converterData(dataInicial, new Date(0L));
		Date fim = URL.converterData(dataFinal, new Date());
		
		List<Post> lista =  servico.findByOcorrenciaNoTituloComIntervaloDeData(texto, ini, fim);
		return ResponseEntity.ok().body(lista);
	}
}
