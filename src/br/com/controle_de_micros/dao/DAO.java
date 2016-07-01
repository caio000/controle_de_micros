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
	/**
	 * Atualiza os dados do objeto no banco de dados.
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/28
	 * @param objeto com os dados que serão alterados no banco de dados.
	 * @return Retorna um boolean TRUE caso a alteração foi realizada com sucesso. 
	 */
	public abstract boolean update(E objeto);
	/**
	 * Deleta o objeto informado da base de dados.
	 * @author Caio de Freitas Adriano
	 * @since 2016/07/01
	 * @param objeto que será deletado.
	 * @return Retorna um boolean TRUE caso o objeto seja deletado com sucesso.
	 */
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
