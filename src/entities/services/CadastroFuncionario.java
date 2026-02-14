package entities.services;

import java.util.ArrayList;
import java.util.List;
import entities.Funcionario;

public class CadastroFuncionario {
	
    private List<Funcionario> listaFuncionarios = new ArrayList<>();
	
    private int gerarIdFuncionario() {
        return listaFuncionarios.stream()
                .mapToInt(Funcionario::getIdFuncionario)
                .max()
                .orElse(0) + 1;
    }
	
    public void cadastrarFuncionario(String nome, String cpf, String fone) {
        int novoId = gerarIdFuncionario();
        Funcionario cliente = new Funcionario(novoId, nome, cpf, fone);
        listaFuncionarios.add(cliente);
    }

    public List<Funcionario> getListaFuncionarios() {
        return new ArrayList<>(listaFuncionarios);
    }

    public void listarFuncionarios() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            listaFuncionarios.forEach(System.out::println);
        }
    }
}