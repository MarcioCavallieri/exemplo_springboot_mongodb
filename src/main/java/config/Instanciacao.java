package config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marciocavallieri.workshopmongodb.dominio.Post;
import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.repositorios.PostRepositorio;
import com.marciocavallieri.workshopmongodb.repositorios.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	PostRepositorio postRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("ss/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		postRepositorio.deleteAll();

		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
	
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viaja para SP, abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hj", maria);
	
		postRepositorio.saveAll(Arrays.asList(post1, post2));
	}
}
