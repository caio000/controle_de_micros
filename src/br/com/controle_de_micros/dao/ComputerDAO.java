package br.com.controle_de_micros.dao;

import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Computer;

public class ComputerDAO extends DAO<Computer> {

	// Construtor

	public ComputerDAO(Database database) {
		super(database);
		database.connect();
	}

	// Métodos

	@Override
	public boolean insert(Computer computer) {

		String sql = "INSERT INTO computer (ctis, idSecretariat, hostname, ip, macAddress, serial, model) VALUES (?, ?, \'?\', \'?\', \'?\', \'?\', \'?\');";
		
		sql = sql.replaceFirst("\\?", Long.toString(computer.getCtis()));
		sql = sql.replaceFirst("\\?", Long.toString(computer.getSecretariat().getIdSecretariat()));
		sql = sql.replaceFirst("\\?", computer.getHostname().toUpperCase());
		sql = sql.replaceFirst("\\?", computer.getIp());
		sql = sql.replaceFirst("\\?", computer.getMacAddress());
		sql = sql.replaceFirst("\\?", computer.getSerial());
		sql = sql.replaceFirst("\\?", computer.getModel().toUpperCase());

		return database.insert(sql);
	}

	@Override
	public boolean update(Computer objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Computer objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Computer> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
