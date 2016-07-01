package br.com.controle_de_micros.dao;

import java.util.List;
import br.com.controle_de_micros.database.Database;

public abstract class DAO<E> {
	
	protected Database database;
	
	
	public DAO(Database database) {
		this.database = database;
	}
	
	/**
	 * Cadastra os dados o objeto no banco de dados.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016-06-23
	 * @param objeto dado do objeto que será inserido no banco de dados
	 * @return boolean TRUE caso o objeto seja inserido com sucesso.
	 */
	public abstract boolean insert(E objeto);
	
	public abstract boolean update(E objeto);
	
	public abstract boolean delete(E objeto);
	/**
	 * Lista os dados de todos os objetos cadastrados no banco de dados.
	 * 
	 * @author caio
	 * @since 2016/06/30
	 *  
	 * @return Retorna uma lista com todos os dados encontrados.
	 */
	public abstract List<E> listAll();

}
