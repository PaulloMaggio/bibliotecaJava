package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Livros {

	public int idLivro;
	public String titulo;
	public String autor;
	public String genero;
	public Date ano;
	
	Status status;
	
	public Livros() {}

	

	public Livros(int idLivro, String titulo, String autor, String genero, Date ano, Status status) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.ano = ano;
		this.status = status;
	}



	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	};
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}
	
	

	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		return Objects.hash(getIdLivro());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return getIdLivro() == other.getIdLivro();
	}



	@Override
	public String toString() {
		return "ID: " + idLivro + " Titulo: " + titulo + " Autor: " + autor + " Genero: " + genero
				+ " Ano: " + ano + " Status: " + status;
	}

}
