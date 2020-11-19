package com.marciocavallieri.workshopmongodb.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marciocavallieri.workshopmongodb.dominio.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {
	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }") //https://docs.mongodb.com/manual/reference/operator/query/regex/
	List<Post> findByOcorrenciaNoTitulo(String texto);
	
	@Query("{ $and: [ {data: {$gte: ?1} }, { data: { $lte: ?2} }, { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> findByOcorrenciaNoTituloComIntervaloDeData(String texto, Date dataInicial, Date dataFinal);
}
