package br.com.controle_de_micros.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.controle_de_micros.control.UserControl;
import br.com.controle_de_micros.model.User;

public class UsersFrame extends JFrame {

	private static final long serialVersionUID = 764469292580682824L;
	private JPanel contentPane;
	private JTable table;
	
	private String[] header  = new String[]{"Matricula","Nome","Status"};
	private String[][] valores;
	private DefaultTableModel model = new DefaultTableModel(valores, header);
	
	
	public UsersFrame() {
		showUsers();
		initComponents();
	}
	
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonNovo = new JButton("Novo");
		ButtonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				JFrame insertUser = new RegisterFrame();
				insertUser.setVisible(true);
			}
		});
		ButtonNovo.setBounds(299, 65, 133, 23);
		contentPane.add(ButtonNovo);
		
		JLabel TituloUsuarios = new JLabel("Usuarios");
		TituloUsuarios.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloUsuarios.setBounds(21, 11, 170, 30);
		contentPane.add(TituloUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 99, 400, 176);
		contentPane.add(scrollPane);
		
		table = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2){
					int line = table.getSelectedRow();
					
					System.out.println(table.getValueAt(line, 0));
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
	}
	
	private void showUsers () {
		UserControl uc = new UserControl();
		List<User> users = uc.listUsers();
		
		for (User u : users){
			String[] linha = new String[]{
				Long.toString(u.getRegistration()),
				u.getName(),
				(u.isActive()) ? "Ativo" : "Desativado"
			};
			
			model.addRow(linha);
		}
		
	}
}
