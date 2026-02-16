package entities.services;

import entities.Enums.statusDevolucao;
import java.util.ArrayList;
import java.util.List;
import entities.Cliente;
import entities.Funcionario;
import entities.Livros;
import entities.Estoque;

public class Aluguel {
    public Livros livro;
    public Cliente cliente;
    public String dataRetirada;
    public String dataDevolucao;
    public Funcionario func;
    public statusDevolucao statusDevolucao;
    
    public AluguelService aluguelService;
    public List<Aluguel> listaAluguel = new ArrayList<>();
    
    public Aluguel() {}

    public Aluguel(Estoque estoque, CadastroCliente cadastroC, CadastroFuncionario cadastroF) {
        this.aluguelService = new AluguelService(estoque, cadastroF, cadastroC);
    }
    
    public Aluguel(Livros livro, String dataRetirada, String dataDevolucao, statusDevolucao statusDevolucao) {
        this.livro = livro;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.statusDevolucao = statusDevolucao;
    }

    public String getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(String dataRetirada) { this.dataRetirada = dataRetirada; }
    public String getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public statusDevolucao getStatusDevolucao() { return statusDevolucao; }
    public void setStatusDevolucao(statusDevolucao statusDevolucao) { this.statusDevolucao = statusDevolucao; }

    @Override
    public String toString() {
        return "Aluguel [livro=" + (livro != null ? livro.getTitulo() : "N/A") 
                + ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") 
                + ", dataRetirada=" + dataRetirada
                + ", status=" + statusDevolucao + "]";
    }

    public Aluguel retirarLivro(int idLivro, int idCliente, String dataRetirada, statusDevolucao status, int idFunc) {
            this.livro = aluguelService.validaLivro(idLivro);    
            this.cliente = aluguelService.validaCliente(idCliente);
            this.func = aluguelService.validaFuncionario(idFunc);
            this.dataRetirada = dataRetirada;
            this.dataDevolucao = "00/00/0000"; 
            this.statusDevolucao = status;
            
            Aluguel novoAluguel = new Aluguel(
                    this.livro, 
                    this.dataRetirada, 
                    this.dataDevolucao, 
                    this.statusDevolucao
            );
            
            novoAluguel.cliente = this.cliente;
            novoAluguel.func = this.func;
            
            listaAluguel.add(novoAluguel);
            System.out.println(" ");
            System.out.println("Aluguel efetuado com sucesso!");
            System.out.println(novoAluguel);
            return novoAluguel;
    }
    
    public void listarAlugueis() {
        if (listaAluguel.isEmpty()) {
            System.out.println("Nenhum aluguel registrado ate o momento.");
        } else {
            listaAluguel.forEach(System.out::println);
        }
    }
    
    public List<Aluguel> getListaAluguel() {
        return new ArrayList<>(listaAluguel);
    }
}