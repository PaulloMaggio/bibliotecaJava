package entities.services;

import entities.Enums.statusDevolucao;
import java.util.ArrayList;
import java.util.List;
import entities.Cliente;
import entities.Funcionario;
import entities.Livros;
import entities.Status;
import entities.Estoque;

public class Aluguel {
    public int idAluguel;
    public Livros livro;
    public Cliente cliente;
    public String dataRetirada;
    public String dataDevolucao;
    public Funcionario func;
    public statusDevolucao statusDevolucao;
    
    public AluguelService aluguelService;
    private List<Aluguel> listaAluguel = new ArrayList<>();
    public Estoque estoque;
    
    public Aluguel() {}

    public Aluguel(Estoque estoque, CadastroCliente cadastroC, CadastroFuncionario cadastroF) {
        this.estoque = estoque;
        this.aluguelService = new AluguelService(estoque, cadastroF, cadastroC);
    }
    
    public Aluguel(int id, Livros livro, Cliente cliente, Funcionario func, String dataRetirada, String dataDevolucao, statusDevolucao status) {
        this.idAluguel = id;
        this.livro = livro;
        this.cliente = cliente;
        this.func = func;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.statusDevolucao = status;
    }

    public String getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(String dataRetirada) { this.dataRetirada = dataRetirada; }
    public String getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public statusDevolucao getStatusDevolucao() { return statusDevolucao; }
    public void setStatusDevolucao(statusDevolucao statusDevolucao) { this.statusDevolucao = statusDevolucao; }
    public int getIdAluguel() { return idAluguel; }
    public void setIdAluguel(int idAluguel) { this.idAluguel = idAluguel; }

    @Override
    public String toString() {
        return "Aluguel [ID=" + idAluguel + " | Livro=" + (livro != null ? livro.getTitulo() : "N/A") 
                + " | Cliente=" + (cliente != null ? cliente.getNome() : "N/A") 
                + " | Retirada=" + dataRetirada
                + " | Devolução=" + dataDevolucao
                + " | Status=" + statusDevolucao + "]";
    }

    public Aluguel retirarLivro(int idLivro, int idCliente, String dataRetirada, statusDevolucao status, int idFunc) {
        Livros livroValido = aluguelService.validaLivro(idLivro);    
        Cliente clienteValido = aluguelService.validaCliente(idCliente);
        Funcionario funcValido = aluguelService.validaFuncionario(idFunc);

        if (livroValido != null && clienteValido != null && funcValido != null) {
            int novoId = aluguelService.gerarIdAluguel();
            Aluguel novoRegistro = new Aluguel(novoId, livroValido, clienteValido, funcValido, dataRetirada, "Pendente", status);
            
            livroValido.setStatus(Status.ALUGADO);
            listaAluguel.add(novoRegistro);
            
            System.out.println("\nAluguel efetuado com sucesso!");
            return novoRegistro;
        }
        return null;
    }
    
    public void devolverLivro(int idAluguel, int idLivro, String dataDevolucao) {
        Aluguel aluguelEncontrado = null;

        for (Aluguel a : listaAluguel) {
            if (a.getIdAluguel() == idAluguel) {
                aluguelEncontrado = a;
                break; 
            }
        }

        if (aluguelEncontrado != null) {
            aluguelEncontrado.livro.setStatus(Status.DISPONIVEL);
            aluguelEncontrado.setDataDevolucao(dataDevolucao);
            aluguelEncontrado.setStatusDevolucao(entities.Enums.statusDevolucao.DEVOLVIDO);
            System.out.println("Devolução efetuada com sucesso!");
        } else {
            System.out.println("Erro: Aluguel não encontrado!");
        }
    }
    
    public void listarAlugueis() {
        if (listaAluguel.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
        } else {
            listaAluguel.forEach(System.out::println);
        }
    }
    
    public List<Aluguel> getListaAluguel() {
        return new ArrayList<>(listaAluguel);
    }
}