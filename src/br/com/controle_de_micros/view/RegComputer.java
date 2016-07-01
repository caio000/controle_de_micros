package br.com.controle_de_micros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.controle_de_micros.control.ComputerControl;
import br.com.controle_de_micros.model.Computer;

public class RegComputer extends JFrame {

	private JPanel contentPane;
	private JTextField Ctis;
	private JTextField campoHost;
	private JTextField textField;
	private JTextField CampoModelo;

	public RegComputer() {
		initComponent();
	}
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
	public void initComponent() {
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
		
		final JFormattedTextField ctis = new JFormattedTextField();
		ctis.setBounds(22, 108, 173, 20);
		contentPane.add(ctis);
		
		
		JLabel Secretaria = new JLabel("Secretaria");
		Secretaria.setBounds(22, 134, 73, 14);
		contentPane.add(Secretaria);
		
		JComboBox secretaria = new JComboBox();
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
				
				String registration = ctis.getText();
				String hostname = campoHost.getText();
				String ip = ips.getText();
				String model = CampoModelo.getText();
				//@SuppressWarnings("deprecation")
				//String pass = passwordField.getText();
				//boolean asAdmin = isAdmin.isSelected();
				
				try {
					
					// verifica se todos os campos de dados
					
					if (registration.isEmpty())
						throw new Exception("O Campo matricula é obrigatório");
					else if (hostname.isEmpty())
						throw new Exception("O campo hostname é obrigatório");
					else if (ip.isEmpty())
						throw new Exception("O Campo ip é obrigatório");
					else if (model.isEmpty())
						throw new Exception("O Campo modelo é obrigatório");
					
					
					
    				
    				
    				ComputerControl uc = new ComputerControl();
    				Computer comp = new Computer(Long.parseLong(registration), secretaria, hostname, ip, model, true);
    				if (uc.inserComputer(comp)){
    					JOptionPane.showMessageDialog(null, "UsuÃ¡rio cadastrado com sucesso!");
    					dispose();
    				}
    				else
    					JOptionPane.showMessageDialog(null, "NÃ£o foi possivel cadastrar o usuÃ¡rio. Tente novamente mais tarde ou entre em contato com o administrador.");
    				
    			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
    			
			}
		});
		//btnNewButton.setBounds(66, 341, 112, 23);
		//contentPane.add(btnNewButton);
		Cadastro.setBounds(34, 263, 171, 23);
		contentPane.add(Cadastro);
		
		JLabel TituloCadastro = new JLabel("Cadastro");
		TituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloCadastro.setBounds(34, 22, 130, 27);
		contentPane.add(TituloCadastro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(34, 72, 46, 14);
		contentPane.add(lblNewLabel);
	}
	
}
