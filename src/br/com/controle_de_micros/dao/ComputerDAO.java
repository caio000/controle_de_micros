package br.com.controle_de_micros.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.model.Address;
import br.com.controle_de_micros.model.Computer;
import br.com.controle_de_micros.model.Phone;
import br.com.controle_de_micros.model.Secretariat;

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
	public boolean update(Computer computer) {
		
		String sql = "UPDATE computer SET hostname = \'?\', ip = \'?\' WHERE ctis = ?;";
		
		sql = sql.replaceFirst("\\?", computer.getHostname().toUpperCase());
		sql = sql.replaceFirst("\\?", computer.getIp());
		sql = sql.replaceFirst("\\?", Long.toString(computer.getCtis()));
		
		return database.update(sql);
	}

	@Override
	public boolean delete(Computer computer) {
		
		String sql = "UPDATE computer SET isActive = false;";
		
		return database.delete(sql);
	}

	@Override
	public List<Computer> listAll() {
		List<Computer> list = new ArrayList<>();
		
		String sql = "SELECT computer.*, secretariat.*, address.*, phone.idphone, phone.number AS phone from computer " +
	" INNER JOIN secretariat " +
		" ON computer.idSecretariat = secretariat.idsecretariat " +
	" INNER JOIN address " +
		" ON secretariat.idAddress = address.idAddress " +
	" INNER JOIN phone " +
		" ON secretariat.idPhone = phone.idphone " +
" WHERE computer.isActive = true;";
		
		ResultSet result = database.query(sql);
		
		try {
			
			while (result.next()) {
				
				Phone phone = new Phone(result.getLong("idPhone"), result.getString("phone"));
				Address address = new Address(result.getLong("idAddress"), result.getString("publicPlace"), result.getString("neighborhood"), result.getInt("number"));
				Secretariat secretariat = new Secretariat(result.getString("name"), address, phone);
				
				Computer computer = new Computer();
				computer.setCtis(result.getLong("ctis"));
				computer.setSecretariat(secretariat);
				computer.setHostname(result.getString("hostname"));
				computer.setIp(result.getString("ip"));
				computer.setMacAddress(result.getString("macAddress"));
				computer.setSerial(result.getString("serial"));
				computer.setModel(result.getString("model"));
				computer.setActive(result.getBoolean("isActive"));
				
				list.add(computer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}