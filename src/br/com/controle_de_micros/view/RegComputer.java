package br.com.controle_de_micros.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegComputer extends JFrame {

	private JPanel contentPane;
	private JTextField Ctis;
	private JTextField campoHost;
	private JTextField textField;
	private JTextField CampoModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegComputer frame = new RegComputer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegComputer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Registrocomputador = new JLabel("Cadastro");
		Registrocomputador.setFont(new Font("Tahoma", Font.BOLD, 25));
		Registrocomputador.setBounds(10, 24, 145, 28);
		contentPane.add(Registrocomputador);
		
		JLabel lblCtis = new JLabel("CTIS");
		lblCtis.setBounds(22, 94, 46, 14);
		contentPane.add(lblCtis);
		
		Ctis = new JTextField();
		Ctis.setBounds(22, 108, 173, 20);
		contentPane.add(Ctis);
		Ctis.setColumns(10);
		
		JLabel Secretaria = new JLabel("Secretaria");
		Secretaria.setBounds(22, 134, 73, 14);
		contentPane.add(Secretaria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 150, 173, 20);
		contentPane.add(comboBox);
		
		JLabel Hostname = new JLabel("HostName");
		Hostname.setBounds(22, 175, 73, 14);
		contentPane.add(Hostname);
		
		campoHost = new JTextField();
		campoHost.setColumns(10);
		campoHost.setBounds(22, 189, 173, 20);
		contentPane.add(campoHost);
		
		JLabel Ip = new JLabel("IP");
		Ip.setBounds(22, 216, 46, 14);
		contentPane.add(Ip);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(22, 230, 173, 20);
		contentPane.add(textField);
		
		JLabel Modelo = new JLabel("Modelo");
		Modelo.setBounds(22, 265, 46, 14);
		contentPane.add(Modelo);
		
		CampoModelo = new JTextField();
		CampoModelo.setColumns(10);
		CampoModelo.setBounds(22, 279, 173, 20);
		contentPane.add(CampoModelo);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(66, 341, 112, 23);
		contentPane.add(btnNewButton);
	}
}
