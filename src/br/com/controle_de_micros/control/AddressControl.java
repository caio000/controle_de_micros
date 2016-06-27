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
	
	
	/**
	 * Essa função insere um endereço na base de dados.
	 * 
	 * @author Caio de Freitas Adriano.
	 * @since 2016/06/27
	 * 
	 * @param address: Objeto do tipo Address que possui os dados que será cadastrados.
	 * @return idAddress: ID do endereço cadastrado.
	 */
	public long insertAddress(Address address){
		
		long idAddress = 0;
		
		dao.insert(address);
		
		// busca o ID do endereço que foi cadastradp
		idAddress = dao.getGeneratedId(address);
		
		return idAddress;
	}

}
