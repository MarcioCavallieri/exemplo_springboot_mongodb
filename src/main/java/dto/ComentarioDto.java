package dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String texto;
	private Date data;
	private AutorDto autor;
	
	public ComentarioDto () {
		
	}

	public ComentarioDto(String texto, Date data, AutorDto autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public Date getData() {
		return data;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}
}
