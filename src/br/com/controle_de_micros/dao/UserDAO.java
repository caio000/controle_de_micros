package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<User> list = new ArrayList<>();
		
		String query = "SELECT registration, name, isActive FROM user;";
		
		ResultSet result = database.query(query);
		
		try {
			while (result.next()){
				User user = new User();
				user.setRegistration(result.getLong("registration"));
				user.setName(result.getString("name"));
				user.setActive(result.getBoolean("isActive"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Essa função verifica se o usuário informado existe na base de dados.
	 * @author Caio de Freitas Adriano.
	 * @since 2016/06/29
	 * @param user: objeto com os dados do usuário.
	 * @return Retorna um boolena TRUE caso o usuário foi encontrado no banco de dados.
	 */
	public boolean checkUser(User user) {
		
		boolean result = false;
		
		String sql = "SELECT COUNT(*) AS qtd FROM user WHERE registration = ? AND password = \'?\';";
		
		sql = sql.replaceFirst("\\?", Long.toString(user.getRegistration()));
		sql = sql.replaceFirst("\\?", user.getPassword());
		
		ResultSet resultDb = database.query(sql);
		
		try {
			if (resultDb.next())
				result = (resultDb.getInt("qtd") == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
