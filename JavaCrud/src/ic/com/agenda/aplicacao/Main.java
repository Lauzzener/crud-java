package ic.com.agenda.aplicacao;

import java.sql.SQLException;
import java.util.Date;

import ic.com.agenda.dao.ContatoDAO;
import ic.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Karla Thaysa");
		contato.setIdade(19);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);
	}

}


