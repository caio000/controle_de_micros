package br.com.controle_de_micros.database;

import java.sql.ResultSet;

public interface Database {

	/**
	 * Essa função realiza a conexão com o banco de dados.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 22/06/2016
	 * 
	 * @return boolean: retorna TRUE caso a conexão sejá efetuada com sucesso.
	 */
	public boolean connect();
	
	/**
	 * Essa função executa a query informada na base de dados e retorna o seu resultado.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 22/06/2016
	 * 
	 * @param sql Query que será executada na base de dados.
	 * @return ResultSet resultado da query.
	 */
	public ResultSet query(String sql);
	
	/**
	 * Essa função recebe uma query de inserção de dados
	 * e insere esses dados na base de dados.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 22/06/2016
	 * 
	 * @param sql: sql 
	 * @return boolean: retorna TRUE caso a inserção sejá realizada com sucesso.
	 */
	public boolean insert(String sql);
	
	public boolean update(String sql);
	
	public boolean delete(String sql);
	
	public boolean disconnect();
	
}
