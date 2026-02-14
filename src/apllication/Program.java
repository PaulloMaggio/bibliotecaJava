package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.Estoque;
import entities.Livros;
import entities.services.Aluguel;
import entities.services.CadastroCliente;
import entities.services.CadastroFuncionario;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static LocalDateTime dataAluguel = LocalDateTime.now();
    static DateTimeFormatter  formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static Estoque estoque = new Estoque();
    static CadastroCliente cliente = new CadastroCliente();
    static CadastroFuncionario funcionario = new CadastroFuncionario();
    static Livros livro = new Livros();
    static Aluguel aluguel = new Aluguel();

    public static void main(String[] args) throws ParseException {
        boolean rodandoSistema = true;

        while (rodandoSistema) {
            menuPrincipal(); 
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Funcionalidade: Adicionar Funcionário:");
                    System.out.println("Digite o nome: ");
                    String nomefunc = sc.nextLine();
                    
                    System.out.println("Digite o CPF: ");
                    String cpffunc = sc.next();
                    
                    System.out.println("Digite o telefone: ");
                    String fonefunc = sc.next();
                    
                    funcionario.cadastrarFuncionario(nomefunc, cpffunc, fonefunc);
                    
                    
                    break;
                case "2":
                    System.out.println("Adicionar Cliente: ");
                    System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.println("Digite o CPF: ");
                    String cpf = sc.next();
                    
                    System.out.println("Digite o telefone: ");
                    String fone = sc.next();
                    
                    cliente.cadastrarCliente(nome, cpf, fone);
                    
                    break;
                case "3":
                    menuDeLivros(); 
                    break;
                case "4":
                    rodandoSistema = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }



    public static void menuPrincipal() {
        System.out.println("\n======================");
        System.out.println("Bem-vindo a Biblioteca");
        System.out.println("======================");
        System.out.println("1 - Adicionar Funcionario");
        System.out.println("2 - Adicionar Cliente");
        System.out.println("3 - Menu de Livros");
        System.out.println("4 - Sair");
    }

    public static void menuDeLivros() throws ParseException {
        boolean rodandoMenuLivros = true;

        while (rodandoMenuLivros) {
            System.out.println("\n--- MENU DE LIVROS ---");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Alugar livro (Em breve)");
            System.out.println("3 - Devolver livro");
            System.out.println("4 - Listar todos os Livros");
            System.out.println("5 - Livros Disponiveis");
            System.out.println("6 - Editar livro");
            System.out.println("7 - Excluir livro");
            System.out.println("8 - Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");

            String op = sc.nextLine();

            switch (op) {
                case "1":
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();
                    System.out.print("Data (dd/MM/yyyy): ");
                    Date ano = sdf.parse(sc.nextLine());
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    estoque.addLivro(titulo, autor, genero, ano, status);
                    break;
                    
                case "2" :
                	System.out.println("Digite o ID do livro: ");
                	int idLivroAlugado = sc.nextInt();
                	
                	String dataFormatada =dataAluguel.format(formatador);
                	
                	System.out.println("Funcionario que alugou: ");
                	int idfuncionarioAlugou = sc.nextInt();
                	
                	System.out.println("ID do Cliente: ");
                	int idClienteAlugou = sc.nextInt();
                	
                	aluguel.retirarLivro(idLivroAlugado, idClienteAlugou, dataFormatada, idfuncionarioAlugou);
                	
                	break;

                case "4":
                    estoque.listaLivros();
                    break;

                case "5" :
                	System.out.println("Livros disponiveis: ");
                	for (Livros livro : estoque.livrosDisponiveis()) {
                		System.out.println(livro);
                	}
                	break;
                case "7":
                    rodandoMenuLivros = false;
                    break;
                
                
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}