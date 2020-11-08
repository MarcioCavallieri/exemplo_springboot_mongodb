package dto;

import java.io.Serializable;

import com.marciocavallieri.workshopmongodb.dominio.Usuario;

public class UsuarioDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String email;
	
	public UsuarioDto() {
		
	}
	
    public UsuarioDto(Usuario u) {
		id = u.getId();
		nome = u.getNome();
		email = u.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}