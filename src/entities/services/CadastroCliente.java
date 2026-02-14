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
}