package br.com.controle_de_micros.dao;

import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.User;

public class UserDAO extends DAO<User>{

	public UserDAO(Database database) {
		super(database);
		database.connect();
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user (registration, name, password) VALUES (?, \'?\', \'?\');";
		
		sql = sql.replaceFirst("\\?", Long.toString(user.getRegistration()));
		sql = sql.replaceFirst("\\?", user.getName().toUpperCase());
		sql = sql.replaceFirst("\\?", user.getPassword());
		
		return database.insert(sql);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
