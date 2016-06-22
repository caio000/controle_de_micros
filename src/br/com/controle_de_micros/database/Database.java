package br.com.controle_de_micros.database;

import java.sql.ResultSet;

public interface Database {

	public boolean connect();
	
	/**
	 * Essa função executa a query informada na base de dados o retorna o seu resultado.
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 22/06/2016
	 * 
	 * @param sql Query que será executada na base de dados.
	 * @return ResultSet resultado da query.
	 */
	public ResultSet query(String sql);
	
	public boolean insert(String sql);
	
	public boolean update(String sql);
	
	public boolean delete(String sql);
	
	public boolean disconnect();
	
}
