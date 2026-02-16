package entities.services;

import java.util.ArrayList;
import java.util.List;
import entities.Cliente;

public class CadastroCliente {
	
    private List<Cliente> listaClientes = new ArrayList<>();
	
    private int gerarIdCliente() {
        return listaClientes.stream()
                .mapToInt(Cliente::getIdCliente)
                .max()
                .orElse(0) + 1;
    }
	
    public void cadastrarCliente(String nome, String cpf, String fone) {
        int novoId = gerarIdCliente();
        Cliente cliente = new Cliente(novoId, nome, cpf, fone);
        listaClientes.add(cliente);
        System.out.println("\nCliente adicionado com sucesso com ID: " + cliente.getIdCliente());
    }

    public List<Cliente> getListaClientes() {
        return new ArrayList<>(listaClientes);
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            listaClientes.forEach(System.out::println);
        }
    }
    
    public void procurarCliente(int idCliente, List<Aluguel> listaAlugueisGeral) {
        Cliente clienteAlvo = null;
        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                clienteAlvo = c;
                break;
            }
        }

        if (clienteAlvo == null) {
            System.out.println("Cliente com ID " + idCliente + " não encontrado no cadastro.");
            return;
        }

        System.out.println("\n--- Dados do Cliente ---");
        System.out.println("Nome: " + clienteAlvo.getNome());
        System.out.println("CPF: " + clienteAlvo.getCpf());
        System.out.println("------------------------");

        boolean temAluguel = false;
        if (listaAlugueisGeral != null) {
            for (Aluguel aluguel : listaAlugueisGeral) {
                if (aluguel.cliente != null && aluguel.cliente.getIdCliente() == idCliente) {
                    if (!temAluguel) {
                        System.out.println("Livros Alugados:");
                        temAluguel = true;
                    }
                    System.out.println("- " + aluguel.livro.getTitulo() + " | Status: " + aluguel.statusDevolucao);
                }
            }
        }

        if (!temAluguel) {
            System.out.println("Este cliente não possui nenhum aluguel registrado.");
        }
    }
}