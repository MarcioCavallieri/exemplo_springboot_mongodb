package com.marciocavallieri.workshopmongodb.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.marciocavallieri.workshopmongodb.dominio.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {

}
