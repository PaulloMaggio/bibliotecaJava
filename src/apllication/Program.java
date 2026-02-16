package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import entities.Enums.statusDevolucao;
import entities.Estoque;
import entities.Livros;
import entities.services.Aluguel;
import entities.services.CadastroCliente;
import entities.services.CadastroFuncionario;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static LocalDateTime dataAluguel = LocalDateTime.now();
    static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static Estoque estoque = new Estoque();
    static CadastroCliente cliente = new CadastroCliente();
    static CadastroFuncionario funcionario = new CadastroFuncionario();
    static Aluguel aluguel = new Aluguel(estoque, cliente, funcionario);

    public static void main(String[] args) throws ParseException {
        boolean rodandoSistema = true;

        while (rodandoSistema) {
            menuPrincipal(); 
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome: ");
                    String nomefunc = sc.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpffunc = sc.nextLine();
                    System.out.print("Digite o telefone: ");
                    String fonefunc = sc.nextLine();
                    funcionario.cadastrarFuncionario(nomefunc, cpffunc, fonefunc);
                    break;
                case "2":
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Digite o telefone: ");
                    String fone = sc.nextLine();
                    cliente.cadastrarCliente(nome, cpf, fone);
                    break;
                case "3" :
                    funcionario.listarFuncionarios();
                    break;
                case "4" :
                    cliente.listarClientes();
                    break;
                case "5" :
                	System.out.println("Digite o ID do cliente: ");
                	int idCliente = sc.nextInt();
                	sc.nextLine();
                	cliente.procurarCliente(idCliente, aluguel.getListaAluguel());
                	break;
                case "6" :
                    aluguel.listarAlugueis();
                    break;
                case "7":
                    menuDeLivros(); 
                    break;
                case "8":
                    rodandoSistema = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }

    public static void menuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1 - Adicionar Funcionario");
        System.out.println("2 - Adicionar Cliente");
        System.out.println("3 - Listar Funcionarios");
        System.out.println("4 - Listar Clientes");
        System.out.println("5 - Procurar Cliente");
        System.out.println("6 - Listar alugueis");
        System.out.println("7 - Menu de Livros");
        System.out.println("8 - Sair");
    }

    public static void menuDeLivros() {
        boolean rodandoMenuLivros = true;
        while (rodandoMenuLivros) {
            System.out.println("\n--- MENU DE LIVROS ---");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Alugar Livro");
            System.out.println("4 - Listar Todos");
            System.out.println("5 - Livros Disponíveis");
            System.out.println("8 - Voltar");
            System.out.print("Escolha: ");
            
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    try {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Gênero: ");
                        String genero = sc.nextLine();
                        System.out.print("Data (dd/MM/yyyy): ");
                        String dataTexto = sc.nextLine();
                        Date ano = sdf.parse(dataTexto);
                        System.out.print("Status: ");
                        String statusStr = sc.nextLine();
                        estoque.addLivro(titulo, autor, genero, ano, statusStr);
                    } catch (ParseException e) {
                        System.out.println("Erro: Formato de data inválido! Use dd/MM/yyyy.");
                    }
                    break;
                case "2" :
                    System.out.print("ID Livro: ");
                    int idL = sc.nextInt();
                    System.out.print("ID Cliente: ");
                    int idC = sc.nextInt();
                    System.out.print("ID Func: ");
                    int idF = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer
                    aluguel.retirarLivro(idL, idC, LocalDateTime.now().format(formatador), statusDevolucao.PENDENTE, idF);
                    break;
                case "4":
                    estoque.listaLivros();
                    break;
                case "5":
                    System.out.println("Livros disponíveis:");
                    for (Livros l : estoque.livrosDisponiveis()) {
                        System.out.println(l);
                    }
                    break;
                case "8":
                    rodandoMenuLivros = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}