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
import javax.swing.JOptionPane;
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
		ButtonNovo.setBounds(191, 65, 133, 23);
		contentPane.add(ButtonNovo);
		
		JLabel TituloUsuarios = new JLabel("Usuarios");
		TituloUsuarios.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloUsuarios.setBounds(21, 11, 170, 30);
		contentPane.add(TituloUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 99, 446, 176);
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
					
					String registation = table.getValueAt(line, 0).toString();
					UserControl uc = new UserControl();
					User user = uc.getUser(Long.parseLong(registation));
					
					JFrame userUp = new RegisterFrame(user);
					userUp.setTitle("Alterar dados");
					userUp.setVisible(true);
					
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		// Botão Deletar
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserControl uc = new UserControl();
				
				try {
					
					int selectedRow = table.getSelectedRow(); // pega a linha que foi selecionada na tabela.
					// caso a linha selecionada sejá igual a -1 (não selecionou nenhuma linha)
					// Exibe uma mensagem de erro. 
					if (selectedRow == -1)
						throw new Exception("Selecione um usuário para remove-lo");
					
					// pega a matricula do usuário
					String registration = table.getValueAt(selectedRow, 0).toString();
					User user = uc.getUser(Long.parseLong(registration)); // objeto do tipo usuario com todos os seus dados.
					// tenta deletar o usuário
					if (uc.deleteUser(user))
						JOptionPane.showMessageDialog(contentPane, "Usuário deletado com sucesso");
					else
						throw new Exception("Não foi possivel deletar o usuário, tente novamente mais tarde <br> ou entre em contado com o administrador");
					
					dispose();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				
			}
		});
		btnDelete.setBounds(334, 65, 133, 23);
		contentPane.add(btnDelete);
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
