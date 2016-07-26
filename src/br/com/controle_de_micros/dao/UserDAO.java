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
		String sql = "INSERT INTO user (registration, name, password) VALUES (?, \'?\', \'?\');";
		
		sql = sql.replaceFirst("\\?", Long.toString(user.getRegistration()));
		sql = sql.replaceFirst("\\?", user.getName().toUpperCase());
		sql = sql.replaceFirst("\\?", user.getPassword());
		
		return database.insert(sql);
	}

	@Override
	public boolean update(User user) {
		// TODO Atualizar os dados do usuario.
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Mudar o status do usuário.
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
	/**
	 * Essa função recebe o ID do usuário e retorna um objeto com todos os seus dados.
	 * @author Caio de Freitas Adriano
	 * @since 2016/07/25
	 * @param idUser ID do usuário
	 * @return Retorna um objeto User que contem todos os dados do usuário na base de dados.
	 */
	public User getUser (long registration) {
		
		User user = null;
		String sql = "SELECT * FROM User WHERE registration = ?;";
		
		sql = sql.replaceFirst("\\?", Long.toString(registration));
		
		ResultSet resultDb = database.query(sql);
		
		try {
			
			if (resultDb.next()) {
				String name = resultDb.getString("name");
				boolean isAdmin = resultDb.getBoolean("isAdmin");
				boolean isActive = resultDb.getBoolean("isActive");
				
				user = new User(registration, name, null, isAdmin, isActive);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
