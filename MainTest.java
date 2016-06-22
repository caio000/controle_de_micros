package br.com.controle_de_micros;

import java.util.List;

import br.com.controle_de_micros.control.SecretariatControl;
import br.com.controle_de_micros.model.Secretariat;

public class MainTest {

	public static void main(String[] args) {
		
		
		SecretariatControl secretariat = new SecretariatControl();
		
		List<Secretariat> sec = secretariat.listSecretariat();
		
		if (sec.isEmpty())
			System.err.println("há secretarias cadastradas");	
		else {
			for (int i = 0; i < sec.size(); i++) {
				System.out.println(sec.get(i).getName());
				System.out.println("==================================================");
			}
		}
		
		
		
	}

}
