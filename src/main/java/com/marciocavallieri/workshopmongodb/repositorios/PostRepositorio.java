package com.marciocavallieri.workshopmongodb.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marciocavallieri.workshopmongodb.dominio.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {
	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }") //https://docs.mongodb.com/manual/reference/operator/query/regex/
	List<Post> findByTitulo(String texto);
}
