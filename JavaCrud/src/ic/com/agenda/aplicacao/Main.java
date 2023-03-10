package ic.com.agenda.aplicacao;

import java.util.Date;
import java.util.Scanner;

import ic.com.agenda.dao.ContatoDAO;
import ic.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		ContatoDAO contatoDao = new ContatoDAO();

		int id;
		String nome;
		int idade;

		int valor;
		boolean bool = true;
		while (bool) {
			System.out.println("1 - Criar\n2 - Ler\n3 - Atualizar\n0 - Sair");
			System.out.print("Digite o numero correspondente a sua ação: ");

			valor = Integer.parseInt(scanner.next());

			switch (valor) {
				case 1:
					nome = lerNome(scanner);
					idade = lerIdade(scanner);
					salvar(contatoDao, nome, idade);
					break;
				case 2:
					ler(contatoDao);
					break;
				case 3:
					id = lerId(scanner);
					nome = lerNome(scanner);
					idade = lerIdade(scanner);
					atualizar(contatoDao, id, nome, idade);
					break;
				case 0:
					bool = false;
					break;
				default:
					break;
			}
		}
		scanner.close();
	}

	public static void ler(ContatoDAO contatoDao) {
		// Visualização dos registros do banco de dados.
		for (Contato c : contatoDao.getContatos()) {
			System.out.print("ID: " + c.getId());
			System.out.print(" | Nome: " + c.getNome());
			System.out.print(" | Idade: " + c.getIdade());
			System.out.println(" | Data: " + c.getDataCadastro());
		}
	}

	public static void salvar(ContatoDAO contatoDAO, String nome, int idade) throws Exception {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setIdade(idade);
		contato.setDataCadastro(new Date());

		contatoDAO.save(contato);
	}

	public static void atualizar(ContatoDAO contatoDAO, int id, String nome, int idade) {
		contatoDAO.update(id, nome, idade);
	}

	public static String lerNome(Scanner scanner) {
		System.out.print("Digite seu nome: ");
		String nome = scanner.next();

		return nome;
	}

	public static int lerIdade(Scanner scanner) {
		System.out.print("Digite sua idade: ");
		int idade = Integer.parseInt(scanner.next());

		return idade;
	}

	public static int lerId(Scanner scanner) {
		System.out.print("Digite o ID: ");
		int id = Integer.parseInt(scanner.next());

		return id;
	}
}
