package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Estoque;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Estoque estoque = new Estoque();

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n======================");
            System.out.println("Bem-vindo a Biblioteca");
            System.out.println("======================");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Alugar livro (Em breve)");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Editar livro");
            System.out.println("5 - Excluir livro");
            System.out.println("6 - Sair");
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
                    System.out.print("Status (DISPONIVEL, ALUGADO, ESGOTADO): ");
                    String status = sc.nextLine();

                    estoque.addLivro(titulo, autor, genero, ano, status);
                    break;

                case "2":
                    System.out.println("Funcionalidade em desenvolvimento...");
                    break;

                case "3":
                    estoque.listaLivros();
                    break;

                case "4":
                    if (estoque.getLivros().isEmpty()) {
                        System.out.println("Estoque vazio!");
                    } else {
                        try {
                            System.out.print("ID do livro: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Novo Título: ");
                            String nt = sc.nextLine();
                            System.out.print("Novo Autor: ");
                            String na = sc.nextLine();
                            System.out.print("Novo Gênero: ");
                            String ng = sc.nextLine();
                            System.out.print("Nova Data (dd/MM/yyyy): ");
                            Date nAno = sdf.parse(sc.nextLine());
                            System.out.print("Novo Status: ");
                            String ns = sc.nextLine();

                            estoque.editarLivro(id, nt, na, ng, nAno, ns);
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Digite um número válido para o ID.");
                        }
                    }
                    break;

                case "5":
                    System.out.print("ID para excluir: ");
                    int idExcluir = Integer.parseInt(sc.nextLine());
                    estoque.deleteLivro(idExcluir);
                    break;

                case "6":
                    rodando = false;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }
}