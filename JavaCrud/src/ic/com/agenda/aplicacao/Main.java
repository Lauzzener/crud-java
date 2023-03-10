package ic.com.agenda.aplicacao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import ic.com.agenda.dao.ContatoDAO;
import ic.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		ContatoDAO contatoDao = new ContatoDAO();

		System.out.print("Digite seu nome: ");
		String nome = scanner.nextLine();

		System.out.print("Digite sua idade: ");
		String idade = scanner.nextLine();

		scanner.close();

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setIdade(Integer.parseInt(idade));
		contato.setDataCadastro(new Date());

		contatoDao.save(contato);

		// Visualização dos registros do banco de dados.
		for (Contato c : contatoDao.getContatos()) {
			System.out.print("ID: " + c.getId());
			System.out.print(" | Nome: " + c.getNome());
			System.out.print(" | Idade: " + c.getIdade());
			System.out.println(" | Data: " + c.getDataCadastro());
		}

		contatoDao.update(contato);

	}
}
