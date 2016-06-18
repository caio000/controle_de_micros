package br.com.controle_de_micros.database;

import java.sql.ResultSet;

public interface Database {

	public boolean connect();
	
	public ResultSet query(String sql);
	
	public boolean insert(String sql);
	
	public boolean update(String sql);
	
	public boolean delete(String sql);
	
	public boolean disconnect();
	
}
