package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.marciocavallieri.workshopmongodb.dominio.Usuario;
import com.marciocavallieri.workshopmongodb.repositorios.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.save(maria);
		usuarioRepositorio.save(alex);
		usuarioRepositorio.save(bob);
		//usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
	}
}
