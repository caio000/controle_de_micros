package br.com.controle_de_micros.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle_de_micros.control.SessionControl;

public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5538999735098588172L;
	private JPanel contentPane;


	public MenuFrame() {
		initComponents();
	}
	
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 382);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        setLocationRelativeTo(null);
        
        // BOTÃO COMPUTADORES
        JButton computer = new JButton("");
        computer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       			JFrame user = new ComputerFrame();
       			user.setVisible(isBackgroundSet());
        	}
        });
        computer.setBounds(66, 66, 100, 100);
        contentPane.add(computer);
         
        ImageIcon comp = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/computer.png"));
        Image comput = comp.getImage().getScaledInstance(computer.getWidth(), computer.getHeight(), Image.SCALE_SMOOTH);
        computer.setIcon(new ImageIcon(comput));
         
        
        // BOTAO LOGOUT
        JButton btnLogout = new JButton("");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		dispose();
        		JFrame login = new LoginFrame();
        		login.setVisible(true);
        		
        	}
        });
        btnLogout.setBounds(255, 214, 100, 100);
         
        ImageIcon logout = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/logout.png"));
        Image log = logout.getImage().getScaledInstance(btnLogout.getWidth(), btnLogout.getHeight(), Image.SCALE_SMOOTH); 
        btnLogout.setIcon(new ImageIcon(log));
        contentPane.add(btnLogout);
        
        // BOTÃO USUÁRIO
        JButton btnUser = new JButton("");
        btnUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if (SessionControl.getInstance().getUser().isAdmin()) {
        			JFrame user = new UsersFrame();
        			user.setVisible(isBackgroundSet());
        		} else {
        			JOptionPane.showMessageDialog(contentPane, "Você não tem permissão para acessar essa funcionalidade");
        		}
        	}
        });
        btnUser.setBounds(255, 66, 100, 100);
        
         
        ImageIcon User = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/user.png"));
        Image Use = User.getImage().getScaledInstance(btnUser.getWidth(), btnUser.getHeight(), Image.SCALE_SMOOTH);   
        btnUser.setIcon(new ImageIcon(Use));
         
         
        contentPane.add(btnUser);
         
        JLabel lblComputadores = new JLabel("Computadores");
        lblComputadores.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblComputadores.setBounds(66, 41, 115, 14);
        contentPane.add(lblComputadores);
         
        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLogout.setBounds(255, 189, 100, 14);
        contentPane.add(lblLogout);
         
        JLabel lblUsuarios = new JLabel("Usuarios");
        lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsuarios.setBounds(255, 41, 100, 14);
        contentPane.add(lblUsuarios);
         
        JLabel lblSecretarias = new JLabel("Secretarias");
        lblSecretarias.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSecretarias.setBounds(66, 189, 100, 14);
        contentPane.add(lblSecretarias);
        
        String message = "O Usuário " + SessionControl.getInstance().getUser().getName().toUpperCase() + " esta logado";
        JLabel lblTeste = new JLabel(message);
        lblTeste.setBounds(255, 16, 169, 14);
        contentPane.add(lblTeste);
        
        // BOTÃO SECRETARIA
        JButton btnSecretariat = new JButton("");
        btnSecretariat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if (SessionControl.getInstance().getUser().isAdmin()){
        			// TODO chamada para tela de secretarias
        		} else {
        			JOptionPane.showMessageDialog(contentPane, "Você não tem permissão para acessar essa funcionalidade");
        		}
        		
        	}
        });
        btnSecretariat.setBounds(66, 214, 100, 100);
        
        ImageIcon sec = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/secretaria.png"));
        Image secretariat = sec.getImage().getScaledInstance(btnSecretariat.getWidth(), btnSecretariat.getHeight(), Image.SCALE_SMOOTH);
        btnSecretariat.setIcon(new ImageIcon(secretariat));
        
        contentPane.add(btnSecretariat);
        
	}
}
