package br.com.controle_de_micros.control;

import br.com.controle_de_micros.dao.PhoneDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.Phone;

public class PhoneControl {

	private PhoneDAO dao;
	
	
	public PhoneControl() {
		Database db = new MariaDatabase("root", "", "control");
		this.dao = new PhoneDAO(db);
	}
	
	
	/**
	 * Essa função insere um novo telefone na base de dados.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/27
	 * 
	 * @param phone: Objeto de tipo Phone que possui os dados que será cadastrado.
	 * @return idPhone: ID do telefone cadastrado.
	 */
	public long insertPhone(Phone phone) {
		long idPhone = 0;
		
		dao.insert(phone); 						// cadastra o telefone
		idPhone = dao.getGeneratedId(phone);	// pega o ID do telefone cadastrado.
		
		return idPhone;
	}
	
	
}
