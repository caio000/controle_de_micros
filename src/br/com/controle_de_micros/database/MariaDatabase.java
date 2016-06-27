package br.com.controle_de_micros.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaDatabase implements Database {
	
	// Atributos
	
	private String username;
	
	private String password;
	
	private String databaseName;
	
	private String host;
	
	private int port;
	
	private Connection connection;
	
	
	// M�todo Construtor
	
	public MariaDatabase(String host, String username, String password, String databaseName, int port) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
		this.port = port;
	}
	
	public MariaDatabase(String host, String username, String password, String databaseName) {
		this(host, username, password, databaseName, 3306);
	}
	
	public MariaDatabase(String username, String password, String databaseName) {
		this("localhost", username, password, databaseName, 3306);
	}
	
	// M�todos

	@Override
	public boolean connect() {
		
		boolean result = true;
		
		try {
			// verifica se j� existe uma conex�o ativa com o banco de dados
			if (this.connection != null)
				this.connection.close(); // fecha a conexao com banco de dados
			
			String url = "jdbc:mariadb://" + this.host + ":" + this.port + "/" + this.databaseName;
			this.connection = DriverManager.getConnection(url,this.username, this.password);
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ResultSet query(String sql) {
		
		ResultSet result = null;
		
		try {
			
			if (this.connection != null && !this.connection.isClosed()) {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				result = stmt.executeQuery();
			} else {
				throw new Exception("Database is not connected.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		
		boolean result = true;
		
		PreparedStatement stmt;
		
		try {
			
			if (this.connection != null && !this.connection.isClosed()) {
				stmt = this.connection.prepareStatement(sql);
				stmt.execute();
				
				stmt.close();
				connection.close(); // fecha a conexão com a base de dados.
			} else {
				throw new Exception("Database is not connected!");
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnect() {
		
		boolean result = false;
		
		try {
			
			/* verifica se existe uma conex�o com a base de dados
			 * e se a conex�o esta aberta.
			 * Se sim, a conex�o � fechada
			 */
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
