package br.com.controle_de_micros;

import java.util.Scanner;

import br.com.controle_de_micros.control.AddressControl;
import br.com.controle_de_micros.control.PhoneControl;
import br.com.controle_de_micros.control.SecretariatControl;
import br.com.controle_de_micros.model.Address;
import br.com.controle_de_micros.model.Phone;
import br.com.controle_de_micros.model.Secretariat;

public class MainTest {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		boolean correct = true;
		do {
			
			try {

				correct = true;

				System.out.println("\tNova Secretaria");
				
				System.out.println("Nome da secretaria..:");
				String name = read.nextLine();
				if (name.isEmpty()) {
					correct = false;
					throw new Exception("Informe o nome do local");
				}
				
				System.out.println("Endereço (apenas o nome da rua)..:");
				String publicPlace = read.nextLine();
				if (publicPlace.isEmpty()) {
					correct = false;
					throw new Exception("Informe o endereço");
				}
				
				System.out.println("Bairro..:");
				String neighborhood = read.nextLine();
				if (neighborhood.isEmpty()) {
					correct = false;
					throw new Exception("Informe o bairro");
				}
				
				System.out.println("Número..:");
				String txtNumber = read.nextLine();
				if (neighborhood.isEmpty()) {
					correct = false;
					throw new Exception("Informe o bairro");
				}
				long number = Integer.parseInt(txtNumber);
				
				System.out.println("Telefone..:");
				String phoneNumber = read.nextLine();
				if (phoneNumber.isEmpty()) {
					correct = false;
					throw new Exception("Informe o telefone");
				}
				
				// Cadastra um novo endereço
				Address address = new Address(publicPlace, neighborhood, number);
				AddressControl ac = new AddressControl();
				address.setIdAddress(ac.insertAddress(address));
				
				// Cadastra um novo telefone.
				Phone phone = new Phone(phoneNumber);
				PhoneControl pc = new PhoneControl();
				phone.setIdPhone(pc.insertPhone(phone));
				
				// cadastra uma nova secretaria
				Secretariat secretariat = new Secretariat(name, address, phone);
				SecretariatControl sc = new SecretariatControl();
				if (sc.insertSecretariat(secretariat))
					System.out.println("Secretaria cadastrada com sucesso!");
				else
					System.out.println("Falha ao cadastrar, tente novamente!");

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} while (correct == false);

		
		read.close();
	}

}
