package br.com.controle_de_micros.dao;

import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Address;

public class AddressDAO extends DAO<Address> {
	
	// Construtor
	
	public AddressDAO(Database database) {
		super(database);
		database.connect();
	}

	
	// Métodos
	
	@Override
	public boolean insert(Address address) {
		
		String sql = "INSERT INTO Address (publicPlace, neighborhood, number) VALUES (?, ?, ?)";
		
		sql = sql.replaceFirst("\\?", address.getPublicPlace());
		sql = sql.replaceFirst("\\?", address.getNeighborhood());
		sql = sql.replaceFirst("\\?", Long.toString(address.getNumber()));
		
		System.out.println(sql);
		
		return false;
	}

	@Override
	public boolean update(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Address> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
