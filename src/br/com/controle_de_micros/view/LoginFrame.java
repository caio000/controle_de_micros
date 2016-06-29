package br.com.controle_de_micros.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8631973804898034171L;
	private JPanel contentPane;
	private JTextField registration;
    private JPasswordField password;
	

    
    public LoginFrame() {
    	setForeground(SystemColor.textHighlight);
    	initComponents();
	}
    
    
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
         
        registration = new JTextField();
        registration.setBounds(220, 61, 165, 20);
        contentPane.add(registration);
        registration.setColumns(10);
         
        JLabel lblRegistration = new JLabel("Matricula");
        lblRegistration.setLabelFor(registration);
        lblRegistration.setBounds(220, 36, 71, 14);
        contentPane.add(lblRegistration);
         
        JLabel lblPassword = new JLabel("Senha");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPassword.setBounds(220, 92, 46, 14);
        contentPane.add(lblPassword);
         
        JLabel foto = new JLabel("");
        foto.setBounds(10, 36, 150, 150);
         
        ImageIcon imagem = new ImageIcon(LoginFrame.class.getResource("/br/com/controle_de_micros/img/bandeira.png"));
        Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        foto.setIcon(new ImageIcon(imag));
         
        contentPane.add(foto);
         
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFrame menu = new MenuFrame();
        		menu.setVisible(true);
        	}
        });
        btnLogin.setBounds(220, 148, 165, 23);
        contentPane.add(btnLogin);
         
        password = new JPasswordField();
        lblPassword.setLabelFor(password);
        password.setBounds(220, 117, 165, 20);
        contentPane.add(password);
	}

}
