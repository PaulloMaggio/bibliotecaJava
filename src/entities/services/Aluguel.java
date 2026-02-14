package entities.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Cliente;
import entities.Estoque;
import entities.Funcionario;
import entities.Livros;
import entities.Status;

public class Aluguel {

	Funcionario funcionario;
	Cliente cliente;

	List<Livros> livrosAlugados = new ArrayList<>();
	Estoque estoque = new Estoque();

	public Aluguel() {
	}

	public void retirarLivro(int id, Date dataRetirada, String func, Cliente cliente) {
		try {
			for (Livros livro : estoque.livrosDisponiveis()) {
				if (livro.getIdLivro() == id) {
					livro.setStatus(Status.ALUGADO);
				}
			}
		} catch (RuntimeException e) {
			System.out.println("ID não encontrado!");
		}
	}
}
