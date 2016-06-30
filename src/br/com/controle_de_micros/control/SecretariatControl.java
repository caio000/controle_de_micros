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
	
	
	/**
	 * Essa função recebe uma secretaria e a cadastra na base de dados
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/29
	 * 
	 * @param secretariat: objeto Secretaria que contem os dados da secretaria que sera cadastrado.
	 * 
	 * @return retorna um boolean TRUE caso a secretaria sejá cadatrada com sucesso.
	 */
	public boolean insertSecretariat(Secretariat secretariat) {
		return dao.insert(secretariat);
	}
	
	public List<Secretariat> listSecretariat(){
		return dao.listAll();
	}
}
