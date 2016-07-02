package br.com.controle_de_micros.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.controle_de_micros.control.ComputerControl;
import br.com.controle_de_micros.model.Address;
import br.com.controle_de_micros.model.Computer;
import br.com.controle_de_micros.model.Phone;
import br.com.controle_de_micros.model.Secretariat;

public class RegComputer extends JFrame {

	private static final long serialVersionUID = -4590146163039564882L;
	private JPanel contentPane;
	private JTextField campoHost;

	public RegComputer() {
		initComponent();
	}
	

	public void initComponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCtis = new JLabel("CTIS");
		lblCtis.setBounds(22, 94, 46, 14);
		contentPane.add(lblCtis);
		
		final JFormattedTextField ctis = new JFormattedTextField();
		ctis.setBounds(22, 108, 173, 20);
		contentPane.add(ctis);
		
		
		JLabel Secretaria = new JLabel("Secretaria");
		Secretaria.setBounds(22, 134, 73, 14);
		contentPane.add(Secretaria);
		
		final JFormattedTextField secretaria = new  JFormattedTextField();
		secretaria.setBounds(22, 150, 173, 20);
		contentPane.add(secretaria);
		
		
		
		JLabel Hostname = new JLabel("HostName");
		Hostname.setBounds(22, 175, 73, 14);
		contentPane.add(Hostname);
		
		final JFormattedTextField hostname = new JFormattedTextField();
		hostname.setBounds(22, 189, 173, 20);
		contentPane.add(hostname);
		
		JLabel Ip = new JLabel("ip");
		Ip.setBounds(22, 216, 46, 14);
		contentPane.add(Ip);
		
		final JFormattedTextField ips = new JFormattedTextField();
		ips.setBounds(22, 230, 173, 20);
		contentPane.add(ips);
		
		JLabel Modelo = new JLabel("Modelo");
		Modelo.setBounds(22, 265, 46, 14);
		contentPane.add(Modelo);
		
		final JFormattedTextField	CampoModelo = new JFormattedTextField();
		CampoModelo.setColumns(10);
		CampoModelo.setBounds(22, 279, 173, 20);
		contentPane.add(CampoModelo);
		
		JButton Cadastro = new JButton("Cadastrar");
		Cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = ctis.getText();
				
				
				
    			Phone phone = new Phone(2, "3882-3301");
    			Address address = new Address(4, "testes", "teste", 512);
    			Secretariat sec = new Secretariat(2, "saude", address, phone);
    			
    			Computer pc = new Computer(25, sec, "pc-12-50", "192.168.12.50", "teste", "teste", "desktop", true);
    			
    			ComputerControl cc = new ComputerControl();
    			
    			if (cc.inserComputer(pc))
    				JOptionPane.showMessageDialog(null, "Micro cadastrado com sucesso!");
    			else
    				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar, tente novamente mais tarde ou entre em contato com o administrador");
    			
    			
			}
		});
		//btnNewButton.setBounds(66, 341, 112, 23);
		//contentPane.add(btnNewButton);
		Cadastro.setBounds(24, 325, 171, 23);
		contentPane.add(Cadastro);
		
		JLabel TituloCadastro = new JLabel("Cadastro");
		TituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloCadastro.setBounds(34, 22, 130, 27);
		contentPane.add(TituloCadastro);
		
		

	}
}
