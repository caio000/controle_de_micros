package br.com.controle_de_micros.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.com.controle_de_micros.control.UserControl;
import br.com.controle_de_micros.model.User;

public class RegisterFrame extends JFrame {

	private static final long serialVersionUID = -6414200982232169807L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	
	public RegisterFrame() {
		initComponent();
	}
	
	
	public void initComponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 282, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Matricula = new JLabel("Matricula");
		Matricula.setBounds(34, 72, 66, 14);
		contentPane.add(Matricula);
		
		final JFormattedTextField registrationField = new JFormattedTextField();
		registrationField.setBounds(34, 85, 171, 27);
		contentPane.add(registrationField);
		
		JLabel Nome = new JLabel("Nome");
		Nome.setBounds(34, 123, 66, 14);
		contentPane.add(Nome);
		
		final JFormattedTextField nameField = new JFormattedTextField();
		nameField.setBounds(34, 136, 171, 27);
		contentPane.add(nameField);
		
		JLabel Senha = new JLabel("Senha");
		Senha.setBounds(34, 174, 46, 14);
		contentPane.add(Senha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(34, 188, 171, 27);
		contentPane.add(passwordField);
		
		final JCheckBox isAdmin = new JCheckBox("Permiss\u00E3o de Administrador");
		isAdmin.setBounds(31, 233, 198, 23);
		contentPane.add(isAdmin);
		
		JButton Cadastro = new JButton("Cadastrar");
		Cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String registration = registrationField.getText();
				String name = nameField.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				boolean asAdmin = isAdmin.isSelected();
				
				try {
					
					// verifica se todos os campos de dados
					
					if (registration.isEmpty())
						throw new Exception("O Campo matricula é obrigatório");
					else if (name.isEmpty())
						throw new Exception("O Campo nome é obrigatório");
					else if (pass.isEmpty())
						throw new Exception("O Campo senha é obrigatório");
					
					
					// algoritmo de criptografia
					MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
    				byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));
    			
    				StringBuilder hexString = new StringBuilder();
    				for (byte b : messageDigest)
    					hexString.append(String.format("%02X", 0xFF & b));
    			
    				String cripPass = hexString.toString(); // hash da senha
    				
    				
    				UserControl uc = new UserControl();
    				User user = new User(Long.parseLong(registration), name, cripPass, asAdmin, true);
    				if (uc.insertUser(user)){
    					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    					dispose();
    				}
    				else
    					JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o usuário. Tente novamente mais tarde ou entre em contato com o administrador.");
    				
    			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
    			
    			
				
			}
		});
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
