package br.com.controle_de_micros;

import java.util.Scanner;

import br.com.controle_de_micros.control.ComputerControl;
import br.com.controle_de_micros.model.Computer;

public class MainTest {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		ComputerControl cc = new ComputerControl();
		
		Computer computer = new Computer();
		computer.setCtis(19846);
		computer.setHostname("PC-11-40");
		computer.setIp("192.168.11.40");
		
		cc.updateComputer(computer);
		
		read.close();
	}

}
