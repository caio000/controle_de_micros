package br.com.controle_de_micros;

import java.util.List;
import java.util.Scanner;

import br.com.controle_de_micros.control.AddressControl;
import br.com.controle_de_micros.control.SecretariatControl;
import br.com.controle_de_micros.model.Address;
import br.com.controle_de_micros.model.Secretariat;

public class MainTest {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		SecretariatControl secretariat = new SecretariatControl();

		List<Secretariat> sec = secretariat.listSecretariat();

		if (sec.isEmpty())
			System.err.println("há secretarias cadastradas");
		else {
			for (int i = 0; i < sec.size(); i++) {
				System.out.println("ID: " + sec.get(i).getIdSecretariat());
				System.out.println("Nome:\t\t" + sec.get(i).getName());
				System.out.print("Endereço:\t" + sec.get(i).getAddress().getPublicPlace() + ", "
						+ sec.get(i).getAddress().getNeighborhood() + " - " + sec.get(i).getAddress().getNumber()
						+ "\n");
				System.out.println("Telefone:\t" + sec.get(i).getPhone().getNumber());
				System.out.println("==================================================");
			}
		}

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
				
				Address address = new Address(publicPlace, neighborhood, number);
				
				AddressControl ac = new AddressControl();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} while (correct == false);

		
		read.close();
	}

}
