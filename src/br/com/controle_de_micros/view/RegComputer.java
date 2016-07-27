package br.com.controle_de_micros.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle_de_micros.control.ComputerControl;
import br.com.controle_de_micros.control.SecretariatControl;
import br.com.controle_de_micros.model.Computer;
import br.com.controle_de_micros.model.Secretariat;
import javax.swing.JTextField;

public class RegComputer extends JFrame {

	private static final long serialVersionUID = -4590146163039564882L;
	private JPanel contentPane;
	private JTextField serial;
	private JTextField macAddress;

	public RegComputer() {
		initComponent();
	}
	

	public void initComponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCtis = new JLabel("CTIS");
		lblCtis.setBounds(22, 65, 46, 14);
		contentPane.add(lblCtis);
		
		final JFormattedTextField ctis = new JFormattedTextField();
		ctis.setBounds(22, 90, 173, 20);
		contentPane.add(ctis);
		
		
		JLabel Secretaria = new JLabel("Secretaria");
		Secretaria.setBounds(22, 121, 73, 14);
		contentPane.add(Secretaria);
		
		
		JLabel Hostname = new JLabel("HostName");
		Hostname.setBounds(22, 177, 73, 14);
		contentPane.add(Hostname);
		
		final JFormattedTextField hostname = new JFormattedTextField();
		hostname.setBounds(22, 202, 173, 20);
		contentPane.add(hostname);
		
		JLabel Ip = new JLabel("ip");
		Ip.setBounds(22, 233, 46, 14);
		contentPane.add(Ip);
		
		final JFormattedTextField ips = new JFormattedTextField();
		ips.setBounds(22, 258, 173, 20);
		contentPane.add(ips);
		
		JLabel Modelo = new JLabel("Modelo");
		Modelo.setBounds(22, 414, 46, 14);
		contentPane.add(Modelo);
		
		final JFormattedTextField	CampoModelo = new JFormattedTextField();
		CampoModelo.setColumns(10);
		CampoModelo.setBounds(22, 439, 173, 20);
		contentPane.add(CampoModelo);
		
		JLabel TituloCadastro = new JLabel("Cadastro");
		TituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloCadastro.setBounds(34, 22, 130, 27);
		contentPane.add(TituloCadastro);
		
		final JComboBox<String> listSecretariat = new JComboBox<String>();
		listSecretariat.setBounds(22, 146, 173, 20);
		SecretariatControl sc = new SecretariatControl();
		final List<Secretariat> list = sc.listSecretariat();
		for (Secretariat l : list)
			listSecretariat.addItem(l.getName());
		contentPane.add(listSecretariat);
		
		JButton Cadastro = new JButton("Cadastrar");
		Cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Secretariat sec = null;
    			String pcCtis = ctis.getText();
    			String selectSec = listSecretariat.getSelectedItem().toString();
    			String pcHost = hostname.getText();
    			String pcModelo = CampoModelo.getText();
    			String numSerial = serial.getText();
    			String pcMac = macAddress.getText();
    			String pcIp = ips.getText();
    			
    			/*
    			 * Vou percorrendo toda a lista de secretarias
    			 * procurando a secretaria que o usuário
    			 * selecionou no comboBox
    			 */
    			for (Secretariat l : list) {
    				if (l.getName().equals(selectSec)) {
    					sec = l; // pega o objeto Secretaria
    					break;
    				}
    			}
    			
    			try {
    				Computer pc = new Computer(Long.parseLong(pcCtis), sec, pcHost, pcIp, pcMac, numSerial, pcModelo);
    				ComputerControl cc = new ComputerControl();
    				if (cc.inserComputer(pc)) {
    					JOptionPane.showMessageDialog(contentPane, "Micro cadastrado com sucesso!");
    					dispose();
    				} else
    					throw new Exception("Não foi possivel cadastrar o micro, tente novamente mais tarde.");
    			}catch (Exception e) {
    				JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				
			}
		});
		Cadastro.setBounds(22, 484, 171, 23);
		contentPane.add(Cadastro);
		
		serial = new JTextField();
		serial.setBounds(22, 383, 173, 20);
		contentPane.add(serial);
		serial.setColumns(10);
		
		JLabel lblSerial = new JLabel("Serial");
		lblSerial.setBounds(22, 358, 46, 14);
		contentPane.add(lblSerial);
		
		JLabel lblMacaddress = new JLabel("MacAddress");
		lblMacaddress.setBounds(22, 302, 173, 14);
		contentPane.add(lblMacaddress);
		
		macAddress = new JTextField();
		macAddress.setBounds(22, 327, 173, 20);
		contentPane.add(macAddress);
		macAddress.setColumns(10);
		
		
		
	}
}
