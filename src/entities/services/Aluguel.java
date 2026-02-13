package entities.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Cliente;
import entities.Funcionario;
import entities.Livros;

public class Aluguel {

	Funcionario funcionario;
	Cliente cliente;
	Date retirada;
	Date devolucao;
	
	List<Livros> livrosAlugados = new ArrayList<>();
	
	public Aluguel() {
	}

	public Aluguel(Funcionario funcionario, Cliente cliente, Date retirada, Date devolucao) {
		super();
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.retirada = retirada;
		this.devolucao = devolucao;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}
	
	
}
