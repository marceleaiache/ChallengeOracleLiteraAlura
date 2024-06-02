package com.litera_alura.LiteraAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class LiteraAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraAluraApplication.class, args);
		Scanner sc = new Scanner(System.in);
		String line = "----------------------------";
		int choice = -1;

		while (choice != 0) {
			try {
				System.out.println(line);
				System.out.println("Escolha um número de sua opção:");
				System.out.println("1- Buscar livro pelo título");
				System.out.println("2- Listar livros registrados");
				System.out.println("3- Listar autores registrados");
				System.out.println("4- Listar autores vivos em um determinado ano");
				System.out.println("5- Listar livros em um determinado idioma");
				System.out.println("0- Sair");
				choice = sc.nextInt();
				sc.nextLine();

				if (choice >= 0 && choice <= 5) {
					switch (choice) {
						case 1:
							searchBookByTitle();
							break;
						case 2:
							listRegisteredBooks();
							break;
						case 3:
							listRegisteredAuthors();
							break;
						case 4:
							listLivingAuthorsInAGivenYear();
							break;
						case 5:
							listBooksInAParticularLanguage();
							break;
						case 0:
							break;

					}
				}
				else {
					System.out.println(line);
					System.out.println("\nOpção inválida. Por favor escolha um número entre 1-5");
					System.out.println("ou digite 0 para sair\n");
				}
			}
			catch (InputMismatchException e) {
				System.out.println(line);
				System.out.println("\nOpção inválida. Por favor escolha um número entre 1-5");
				System.out.println("ou digite 0 para sair\n");
				sc.nextLine();
			}
		}

		// CASE 1
		private void searchBookByTitle() {
			System.out.println("Insira o título do livro: ");
			var bookName = sc.nextLine();

		}
		// CASE 2
		private void listRegisteredBooks() {
			System.out.println(line);
			System.out.println("Livros Registrados: ");
		}
		// CASE 3
		private void listRegisteredAuthors() {
			System.out.println(line);
			System.out.println("Autores Registrados: ");
		}
		// CASE 4
		private void listLivingAuthorsInAGivenYear() {
			System.out.println("Insira o ano a ser listado: ");
			var yearLivingAuthors = sc.nextLine();
		}
		// CASE 5
		private void listBooksInAParticularLanguage() {
			System.out.println("Insira o idioma a ser listado:");
			var languagesOfBooks = sc.nextLine();


			List<Books> books = repository.findBooksByLanguages(language);
			if (!books.isEmpty()) {
				books.forEach(System.out::println);
			} else {
				System.out.printf("There are no books in the %s language %n", language);
			}
		}

		sc.close();
	}

}
