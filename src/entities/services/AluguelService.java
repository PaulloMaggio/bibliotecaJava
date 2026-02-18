package entities.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.Cliente;
import entities.Estoque;
import entities.Funcionario;
import entities.Livros;
import entities.Status;

public class AluguelService {

	public static Livros livroAlugado;
	public static Date dataRetirada;
	public static Funcionario funcionarioAluguel;
	public static Cliente clienteAluguel;

	List<Aluguel> listaAlugueis = new ArrayList<>();
	Estoque estoque;
	CadastroFuncionario cadastroFunc;
	CadastroCliente cadastroCliente;

	public AluguelService(Estoque estoque, CadastroFuncionario cadastroFunc, CadastroCliente cadastroCliente) {
		this.estoque = estoque;
		this.cadastroFunc = cadastroFunc;
		this.cadastroCliente = cadastroCliente;
	}
	
	public int gerarIdAluguel() {
	        return listaAlugueis.stream()
	                .mapToInt(Aluguel::getIdAluguel)
	                .max()
	                .orElse(0) + 1;
	    }

	public Livros validaLivro(int idLivro) {
		try {
			for (Livros livro : estoque.livrosDisponiveis()) {
				if (livro.getIdLivro() == idLivro) {
					livro.setStatus(Status.ALUGADO);
					return livro;
				}
			}
		} catch (RuntimeException e) {
			System.out.println("ID não encontrado!");
		}
		return null;
	}

	public Funcionario validaFuncionario(int idFunc) {
		for (Funcionario funcionario : cadastroFunc.getListaFuncionarios()) {
			if (funcionario.getIdFuncionario() == idFunc) {
				return funcionario;
			}
		}
		System.out.println("Funcionário com ID " + idFunc + " não encontrado.");
		return null;
	}

	public Cliente validaCliente(int idCliente) {
		try {
			for (Cliente cliente : cadastroCliente.getListaClientes()) {
				if (cliente.getIdCliente() == idCliente) {
					return cliente;
				}
			}
		} catch (RuntimeException e) {
			System.out.println("ID não encontrado!");
		}
		return null;
	}
}