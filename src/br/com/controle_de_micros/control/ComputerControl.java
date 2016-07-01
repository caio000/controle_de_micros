package br.com.controle_de_micros.control;

import java.util.List;

import br.com.controle_de_micros.dao.ComputerDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.Computer;

public class ComputerControl {

	private ComputerDAO dao;
	
	public ComputerControl() {
		Database db = new MariaDatabase("root", "", "control");
		dao = new ComputerDAO(db);
	}
	
	/**
	 * Essa função recebe os dados de um computador e cadastra na base de dados.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/29
	 * 
	 * @param computer: objeto do tipo computer que contem os dado do computador.
	 * @return Retorna um boolean TRUE caso os dados foram cadastrados com sucesso.
	 */
	public boolean inserComputer(Computer computer){
		return dao.insert(computer);
	}
	
	public List<Computer> listComputer () {
		return dao.listAll();
	}
}
