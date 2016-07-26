package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Address;

public class AddressDAO extends DAO<Address> {
	
	// Construtor
	
	public AddressDAO(Database database) {
		super(database);
		database.connect();
	}

	
	// MÃ©todos
	
	@Override
	public boolean insert(Address address) {
		
		String sql = "INSERT INTO Address (publicPlace, neighborhood, number) VALUES (\'?\', \'?\', ?);";
		
		sql = sql.replaceFirst("\\?", address.getPublicPlace().toUpperCase());
		sql = sql.replaceFirst("\\?", address.getNeighborhood().toUpperCase());
		sql = sql.replaceFirst("\\?", Long.toString(address.getNumber()));
		
		return database.insert(sql);
	}

	@Override
	public boolean update(Address address) {
		// TODO Atualizar os dados de endereço
		return false;
	}

	@Override
	public boolean delete(Address address) {
		// TODO Deletar um endereço cadastrado
		return false;
	}

	@Override
	public List<Address> listAll() {
		List<Address> list = new ArrayList<>();
		
		String sql = "SELECT * FROM address;";
		
		ResultSet result = database.query(sql);
		
		try {
			while (result.next()) {
				Address address = new Address(result.getLong("idAddress"), result.getString("publicPlace"), result.getString("neighborhood"), result.getInt("number"));
				list.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public long getGeneratedId(Address address) {
		
		long id = 0;
		
		String sql = "SELECT idAddress FROM Address WHERE publicPlace = \'?\' AND neighborhood = \'?\' AND number = ?;";
		
		sql = sql.replaceFirst("\\?", address.getPublicPlace().toUpperCase());
		sql = sql.replaceFirst("\\?", address.getNeighborhood().toUpperCase());
		sql = sql.replaceFirst("\\?", Long.toString(address.getNumber()));
		
		database.connect();
		
		ResultSet result = database.query(sql);
		
		try {
			if (result.next())
				id = result.getLong("idAddress");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			database.disconnect();
		}
		
		return id;
	}

}
