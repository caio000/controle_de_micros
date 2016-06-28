package br.com.controle_de_micros;

import java.security.MessageDigest;
import java.util.Scanner;

import br.com.controle_de_micros.control.UserControl;
import br.com.controle_de_micros.model.User;

public class MainTest {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		
		try {
			
			System.out.println("Matricula..:");
			long registration = Long.parseLong(read.nextLine());
			
			System.out.println("Nome..:");
			String name = read.nextLine();
			
			System.out.println("Senha..:");
			String cleanPassword = read.nextLine();
			
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(cleanPassword.getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest)
				hexString.append(String.format("%02x", 0xFF & b));
			
			String cripPassword = hexString.toString();
			
			UserControl uc = new UserControl();
			User user = new User(registration, name, cripPassword);
			
			if (uc.insertUser(user))
				System.out.println("Usuário cadastrado com sucesso");
			else
				System.out.println("Fatal Error!!!!");
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		read.close();
	}

}
