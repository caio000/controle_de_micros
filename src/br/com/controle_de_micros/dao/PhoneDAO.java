package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Phone;

public class PhoneDAO extends DAO<Phone>{

	public PhoneDAO(Database database) {
		super(database);
		database.connect();
	}

	@Override
	public boolean insert(Phone phone) {
		
		String sql = "Insert INTO Phone (number) VALUES (\'?\');";
		
		sql = sql.replaceFirst("\\?", phone.getNumber());
		
		return database.insert(sql);
	}

	@Override
	public boolean update(Phone phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Phone phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Phone> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long getGeneratedId(Phone phone){
		
		long id = 0;
		
		String sql = "SELECT idPhone FROM Phone WHERE number = \'?\';";
		
		sql = sql.replaceFirst("\\?", phone.getNumber());
		
		database.connect();
		
		ResultSet result = database.query(sql);
		
		try {
			
			if (result.next())
				id = result.getLong("idPhone");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			database.disconnect();
		}
		
		return id;
	}

}
