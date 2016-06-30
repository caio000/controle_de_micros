package br.com.controle_de_micros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class usersFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	String[] header  = new String[]{"Matricula","Nome","Ação"};
	String[][] valores = new String[0][3];
	DefaultTableModel model = new DefaultTableModel(valores, header);
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usersFrame frame = new usersFrame();
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
	public usersFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonNovo = new JButton("Novo");
		ButtonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] linha = new String[]{"255", "storm" , "Mudar ainda"};

				model.addRow(linha);
			}
		});
		ButtonNovo.setBounds(299, 65, 133, 23);
		contentPane.add(ButtonNovo);
		
		JLabel TituloUsuarios = new JLabel("Usuarios");
		TituloUsuarios.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloUsuarios.setBounds(21, 11, 170, 30);
		contentPane.add(TituloUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 112, 400, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
	}
}
