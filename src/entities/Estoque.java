package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estoque extends Livros {

	public List<Livros> estoque = new ArrayList<>();

	public Estoque() {
	};

	public Estoque(int idLivro, String titulo, String autor, String genero, Date ano, Status status,
			List<Livros> estoque) {
		super(idLivro, titulo, autor, genero, ano, status);
		this.estoque = estoque;
	}

	public int gerarId() {
	    if (estoque != null && !estoque.isEmpty()) {
	        int ultimoId = estoque.get(estoque.size() - 1).getIdLivro();
	        this.idLivro = ultimoId + 1;
	    } else {
	        this.idLivro = 1;
	    }
	    return idLivro;
	}

	public void addLivro(int idLivro, String titulo, String autor, String genero, Date ano, String status) {
		Livros livro = new Livros();

		livro.setIdLivro(idLivro);
		livro.titulo = titulo;
		livro.autor = autor;
		livro.genero = genero;
		livro.ano = ano;

		if (status.equals("DISPONIVEL")) {
			livro.status = Status.DISPONIVEL;
		} else if (status.equals("ALUGADO")) {
			livro.status = Status.ALUGADO;
		} else if (status.equals("ESGOTADO")) {
			livro.status = Status.ESGOTADO;
		}else {System.out.println("Entre com um Status Valido: Disponivel, Alugado, Sem estoque!");
		}
		estoque.add(livro);
		System.out.println(" ");
		System.out.println("Livro adicionado com sucesso!");
	}

	public void listaLivros() {
		if (estoque != null && !estoque.isEmpty()) {
			for (Livros livro : estoque) {
				System.out.println(livro);
			}
		}
		else{
			System.out.println("Nenhum livro cadastrado!");
		}
	}
	
	public List<Livros> editarLivro(int idLivro, String titulo, String autor, String genero, Date ano, String status) {
	    boolean encontrado = false;

	    if (estoque != null && !estoque.isEmpty()) {
	        for (Livros livro : estoque) {
	            if (livro.getIdLivro() == idLivro) {
	               
	                livro.setTitulo(titulo); 
	                livro.setAutor(autor);
	                livro.setGenero(genero);
	                livro.setAno(ano);

	               
	                try {
	                    livro.setStatus(Status.valueOf(status.toUpperCase()));
	                } catch (IllegalArgumentException e) {
	                    System.out.println("Status inválido! Use: DISPONIVEL, ALUGADO ou ESGOTADO.");
	                }

	                System.out.println("\nLivro editado com sucesso!");
	                encontrado = true;
	                break; 
	            }
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Livro com ID " + idLivro + " não encontrado.");
	    }

	    return estoque;
	}
}
