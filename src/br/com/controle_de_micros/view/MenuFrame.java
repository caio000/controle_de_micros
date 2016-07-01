package br.com.controle_de_micros.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        setBounds(100, 100, 450, 321);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        setLocationRelativeTo(null);
        
        //JLabel computer = new JLabel("");
        JButton computer = new JButton("");
        computer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		JFrame user = new ComputerFrame();
        		user.setVisible(isBackgroundSet());
        	}
        });
        computer.setBounds(66, 23, 100, 100);
        contentPane.add(computer);
         
        ImageIcon comp = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/computer.png"));
        Image comput = comp.getImage().getScaledInstance(computer.getWidth(), computer.getHeight(), Image.SCALE_SMOOTH);
        computer.setIcon(new ImageIcon(comput));
         
        //contentPane.add(computer);
         
         
         
        JLabel secretary = new JLabel("");
        secretary.setBounds(66, 162, 100, 100);
         
        ImageIcon secret = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/secretaria.png"));
        Image secre = secret.getImage().getScaledInstance(secretary.getWidth(), secretary.getHeight(), Image.SCALE_SMOOTH);
        secretary.setIcon(new ImageIcon(secre));
         
        contentPane.add(secretary);
         
        JButton btnLogout = new JButton("");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		dispose();
        		JFrame login = new LoginFrame();
        		login.setVisible(true);
        		
        	}
        });
        btnLogout.setBounds(255, 162, 100, 100);
         
        ImageIcon logout = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/logout.png"));
        Image log = logout.getImage().getScaledInstance(btnLogout.getWidth(), btnLogout.getHeight(), Image.SCALE_SMOOTH); 
        btnLogout.setIcon(new ImageIcon(log));
        contentPane.add(btnLogout);
         
        JButton btnUser = new JButton("");
        btnUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFrame user = new UsersFrame();
        		user.setVisible(isBackgroundSet());
        	}
        });
        btnUser.setBounds(255, 23, 100, 100);
        
         
        ImageIcon User = new ImageIcon(MenuFrame.class.getResource("/br/com/controle_de_micros/img/user.png"));
        Image Use = User.getImage().getScaledInstance(btnUser.getWidth(), btnUser.getHeight(), Image.SCALE_SMOOTH);   
        btnUser.setIcon(new ImageIcon(Use));
         
         
        contentPane.add(btnUser);
         
        JLabel lblComputadores = new JLabel("Computadores");
        lblComputadores.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblComputadores.setBounds(66, 9, 115, 14);
        contentPane.add(lblComputadores);
         
        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLogout.setBounds(255, 143, 100, 14);
        contentPane.add(lblLogout);
         
        JLabel lblUsuarios = new JLabel("Usuarios");
        lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsuarios.setBounds(255, 9, 100, 14);
        contentPane.add(lblUsuarios);
         
        JLabel lblSecretarias = new JLabel("Secretarias");
        lblSecretarias.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSecretarias.setBounds(66, 143, 100, 14);
        contentPane.add(lblSecretarias);
        
      
	}
}
