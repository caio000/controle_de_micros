package br.com.controle_de_micros;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.controle_de_micros.database.MariaDatabase;

public class MainTest {

	public static void main(String[] args) {
		
		MariaDatabase db = new MariaDatabase("root", "", "controlemicros");
		
		db.connect();
		ResultSet result = db.query("SELECT * FROM Computador;");
		
		try {
			System.out.println("\tComputadores");
						
			while (result.next()) {
				
				System.out.println(result.getString("nome"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
