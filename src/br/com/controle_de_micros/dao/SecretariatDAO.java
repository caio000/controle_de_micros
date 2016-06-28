package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Address;
import br.com.controle_de_micros.model.Phone;
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
		
		String sql = "INSERT INTO Secretariat (name, idAddress, idPhone) VALUES (\'?\', ?, ?);";
		
		sql = sql.replaceFirst("\\?", objeto.getName().toUpperCase());
		sql = sql.replaceFirst("\\?", Long.toString(objeto.getAddress().getIdAddress()));
		sql = sql.replaceFirst("\\?", Long.toString(objeto.getPhone().getIdPhone()));
		
		return database.insert(sql);
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
		
		String query = "SELECT idSecretariat, name, a.*, p.idPhone, p.number AS phone FROM secretariat AS sec "
				+ "INNER JOIN address AS a "
				+ "ON a.idAddress = sec.idAddress "
				+ "INNER JOIN phone AS p "
				+ "ON p.idPhone = sec.idPhone;";
		
		ResultSet result = database.query(query);
		
		try {
			
			while (result.next()) {
				
				Secretariat sec = new Secretariat();
				Address address = new Address(result.getLong("idAddress"), result.getString("publicPlace"), result.getString("neighborhood"), result.getLong("number"));
				Phone phone     = new Phone(result.getLong("idPhone"), result.getString("phone"));
				
				sec.setIdSecretariat(result.getLong("idSecretariat"));
				sec.setName(result.getString("name"));
				sec.setAddress(address);
				sec.setPhone(phone);
				
				list.add(sec);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
