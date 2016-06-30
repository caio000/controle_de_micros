package br.com.controle_de_micros.control;

import br.com.controle_de_micros.dao.UserDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.User;

public class UserControl {

	private UserDAO dao;
	
	
	public UserControl() {
		Database db = new MariaDatabase("root", "", "control");
		dao = new UserDAO(db);
	}
	
	
	// Métodos
	
	public boolean insertUser(User user) {
		return dao.insert(user);
	}
	
	
	public boolean makeLogin(User user){
		return dao.checkUser(user);
	}
}
