package br.com.controle_de_micros.control;

import br.com.controle_de_micros.dao.AddressDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.Address;

public class AddressControl {
	
	private AddressDAO dao;
	
	
	public AddressControl() {
		Database db = new MariaDatabase("root", "", "control");
		dao = new AddressDAO(db);
	}
	
	
	
	public long insertAddress(Address address){
		
		long idAddress = 0;
		
		if (dao.insert(address)) {
			// TODO buscar no banco de dados o ID do endereço cadastrado.
		}
		
		return idAddress;
	}

}
