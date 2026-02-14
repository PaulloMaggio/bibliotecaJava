package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estoque {

    private List<Livros> livros = new ArrayList<>();

    public Estoque() {
    }

    public int gerarIdLivro() {
        return livros.stream()
                .mapToInt(Livros::getIdLivro)
                .max()
                .orElse(0) + 1;
    }

    public void addLivro(String titulo, String autor, String genero, Date ano, String statusStr) {
        Livros livro = new Livros();
        
        livro.setIdLivro(gerarIdLivro());
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setAno(ano);

        try {
            livro.setStatus(Status.valueOf(statusStr.toUpperCase()));
            livros.add(livro);
            System.out.println("\nLivro adicionado com sucesso! ID: " + livro.getIdLivro());
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: Status inválido.");
        }
    }

    public void listaLivros() {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado!");
        } else {
            System.out.println("\n--- Lista de Livros ---");
            livros.forEach(System.out::println);
        }
    }

    public void editarLivro(int idLivro, String titulo, String autor, String genero, Date ano, String statusStr) {
        boolean encontrado = false;

        for (Livros livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setGenero(genero);
                livro.setAno(ano);

                try {
                    livro.setStatus(Status.valueOf(statusStr.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    System.out.println("\nStatus inválido!");
                }
                
                encontrado = true;
                System.out.println("\nLivro editado com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nID " + idLivro + " não encontrado.");
        }
    }

    public void deleteLivro(int id) {
        boolean removido = livros.removeIf(l -> l.getIdLivro() == id);

        if (removido) {
            System.out.println("\nLivro removido com sucesso!");
        } else {
            System.out.println("\nID não encontrado.");
        }
    }

    public List<Livros> getLivros() {
        return livros;
    }
    
    public List<Livros> livrosDisponiveis() {
    	List<Livros> livrosDisponiveis = new ArrayList<>();
    	for (Livros livro : livros) {
    		if (livro.status == Status.DISPONIVEL) {
    			livrosDisponiveis.add(livro);
    		}
    	}
    	return livrosDisponiveis;
    }
}