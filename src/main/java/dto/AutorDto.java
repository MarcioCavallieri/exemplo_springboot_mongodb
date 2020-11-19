package dto;

import java.io.Serializable;
import com.marciocavallieri.workshopmongodb.dominio.Usuario;

public class AutorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	
	public AutorDto () {
		
	}
	
	public AutorDto(Usuario u) {
		id = u.getId();
		nome = u.getNome();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
