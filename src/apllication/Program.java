package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Estoque;
import entities.Livros;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Estoque estoque = new Estoque();

		boolean rodando = true;
		while (rodando == true) {
			System.out.println(" ");
			System.out.println("======================");
			System.out.println("Bem-vindo a Biblioteca");
			System.out.println("======================");

			System.out.print(" ");
			System.out.println("1 - Adicionar Livro: ");
			System.out.println("2 - Alugar livro");
			System.out.println("3 - Listar Livros");
			System.out.println("4 - Editar livro");
			System.out.println("5 - Excluir livro ");
			System.out.println("6 - Sair");

			System.out.println(" ");
			System.out.print("Escolha uma opção: ");
			String op = sc.next().toUpperCase();

			switch (op) {
			case "1":
				System.out.println("Digite o Titulo do livro: ");
				String titulo = sc.next();

				System.out.println("Digite o Autor do livro: ");
				String autor = sc.next();

				System.out.println("Digite o Genero do livro: ");
				String genero = sc.next();

				System.out.println("Digite a data de lançamento do livro: ");
				sc.nextLine();
				Date ano = sdf.parse(sc.nextLine());

				System.out.println("Qual o Status do livro: ");
				String status = sc.next().toUpperCase();

				estoque.addLivro(estoque.gerarId(), titulo, autor, genero, ano, status);
				break;
			case "2":
				break;

			case "3":
				System.out.println(" ");
				System.out.println("Livros no estoque: ");
				System.out.println(" ");
				estoque.listaLivros();
				break;

			case "4":
				System.out.println(" ");
				if (estoque.estoque.isEmpty()) { 
				    System.out.println("O estoque está vazio! Cadastre um livro primeiro.");
				} else {
					try {
						System.out.println("\nDigite o ID do livro a ser editado: ");
						int id = sc.nextInt();
						sc.nextLine(); 

						System.out.println("Digite o Titulo do livro: ");
						String novoTitulo = sc.nextLine();

						System.out.println("Digite o Autor do livro: ");
						String novoAutor = sc.nextLine();

						System.out.println("Digite o Genero do livro: ");
						String novoGenero = sc.nextLine();

						System.out.println("Digite a data (dd/MM/yyyy): ");
						Date novoAno = sdf.parse(sc.nextLine());

						System.out.println("Qual o Status do livro: ");
						String novoStatus = sc.nextLine().toUpperCase();

						
						estoque.editarLivro(id, novoTitulo, novoAutor, novoGenero, novoAno, novoStatus);

					} catch (ParseException e) {
						System.out.println("Erro: Data inválida!");
					}
				} 
				break; 
			}
		}
	}
}
