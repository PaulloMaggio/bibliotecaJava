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
	Livros livro;
	Cliente cliente;
	Date dataRetirada;
	Date devolucao;
	Funcionario func;
	
	AluguelService aluguelService = new AluguelService();
	
	public Aluguel retirarLivro(int idLivro, int idCliente, Date data, int idFunc) {
			int idLivroValido = aluguelService.validaLivro();	
				
	}
}
