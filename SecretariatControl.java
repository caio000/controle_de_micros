package br.com.controle_de_micros.control;

import java.util.List;

import br.com.controle_de_micros.dao.SecretariatDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.Secretariat;

public class SecretariatControl {

	private SecretariatDAO dao;
	
	
	public SecretariatControl() {
		Database database = new MariaDatabase("root", "", "control");
		dao = new SecretariatDAO(database);
	}
	
	
	
	public List<Secretariat> listSecretariat(){
		return dao.listAll();
	}
}
