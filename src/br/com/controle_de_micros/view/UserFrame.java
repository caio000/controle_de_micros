package br.com.controle_de_micros.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 3149773584871383170L;
	private JPanel contentPane;
	private JTable table;

	
	
	public UserFrame() {
		initComponents();
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        table = new JTable();
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setBounds(10, 138, 414, 113);
        contentPane.add(table);
        
        JButton btnInsertUser = new JButton("Cadastrar");
        btnInsertUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		JFrame insertUser = new RegisterFrame();
        		insertUser.setVisible(true);
        		dispose();
        		
        	}
        });
        btnInsertUser.setBounds(332, 34, 92, 46);
        contentPane.add(btnInsertUser);
	}
}
