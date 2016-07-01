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
	 * Essa fun��o recebe os dados de um computador e cadastra na base de dados.
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
	/**
	 * Atualiza os dados do computador informado no banco de dados.
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/29
	 * @param computer objeto com os dados do computador que será atualizado.
	 * @return retorna um boolean TRUE caso os dados foram atualizados com sucesso.
	 */
	public boolean updateComputer(Computer computer){
		return dao.update(computer);
	}
	/**
	 * Lista todos os computadores cadastrados na base de dados.
	 * @author Caio de Freitas Adriano.
	 * @since 2016/07/01
	 * @return Retorna uma lista de todos os computadores.
	 */
	public List<Computer> listComputer () {
		return dao.listAll();
	}
	/**
	 * Essa função deleta o computador informado.
	 * @author Caio de Freitas Adriano.
	 * @since 2016/07/01
	 * @param computer objeto com os dados do computador.
	 * @return Retorna um boolean TRUE caso o computador seja deletado com sucesso.
	 */
	public boolean deleteComputer(Computer computer) {
		return dao.delete(computer);
	}
	
}
