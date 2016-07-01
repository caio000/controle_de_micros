package br.com.controle_de_micros.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.controle_de_micros.control.ComputerControl;
import br.com.controle_de_micros.control.UserControl;
import br.com.controle_de_micros.model.Computer;
import br.com.controle_de_micros.model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ComputerFrame extends JFrame {

	private static final long serialVersionUID = 764469292580682824L;
	private JPanel contentPane;
	private JTable table;
	
	private String[] header  = new String[]{"CTIS","Secretaria","HostName","IP","Modelo"};
	private String[][] valores;
	private DefaultTableModel model = new DefaultTableModel(valores, header);
	
	public ComputerFrame() {
		showComputer();
		initComponents();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputerFrame frame = new ComputerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Computadores = new JLabel("Computadores");
		Computadores.setFont(new Font("Tahoma", Font.BOLD, 25));
		Computadores.setBounds(10, 25, 188, 30);
		contentPane.add(Computadores);
		
		JButton buttonNovoMicro = new JButton("Novo Micro");
		buttonNovoMicro.setBounds(446, 72, 119, 23);
		contentPane.add(buttonNovoMicro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 555, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
	}
	
	private void showComputer () {
		ComputerControl uc = new ComputerControl();
		List<Computer> Computers = uc.listComputer();
		
		for (Computer u : Computers){
			String[] linha = new String[]{
				Long.toString(u.getCtis()),
				u.getHostname(),
				(u.isActive()) ? "Ativo" : "Desativado"
			};
			
			model.addRow(linha);
		}
		
	}
}
