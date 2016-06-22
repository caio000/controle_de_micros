package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Secretariat;

public class SecretariatDAO extends DAO<Secretariat> {

	
	// Construtor
	
	public SecretariatDAO(Database database) {
		super(database);
		database.connect();
	}
	
	
	
	// Métodos

	@Override
	public boolean insert(Secretariat objeto) {
		// TODO Inserir uma nova secretaria na base de dados.
		
		
		return false;
	}

	@Override
	public boolean update(Secretariat objeto) {
		// TODO Atualizar os dados da secretaria
		return false;
	}

	@Override
	public boolean delete(Secretariat objeto) {
		// TODO Deletar a secretaria da base de dados.
		return false;
	}

	@Override
	public List<Secretariat> listAll() {
		// TODO Listar todas as secretarias cadastradas na bade de dados.
		
		List<Secretariat> list = new ArrayList<Secretariat>();
		
		String query = "SELECT idSecretariat, name, a.neighborhood, a.publicPlace, a.number, p.number AS phone FROM secretariat AS sec "
				+ "INNER JOIN address AS a "
				+ "ON a.idAddress = sec.idAddress "
				+ "INNER JOIN phone AS p "
				+ "ON p.idPhone = sec.idPhone;";
		
		ResultSet result = database.query(query);
		
		try {
			
			while (result.next()) {
				
				Secretariat sec = new Secretariat();
				
				sec.setName(result.getString("name"));
				
				list.add(sec);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
