package br.com.controle_de_micros.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField CampoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Matricula = new JLabel("Matricula");
		Matricula.setBounds(34, 72, 66, 14);
		contentPane.add(Matricula);
		
		JFormattedTextField CampoMatricula = new JFormattedTextField();
		CampoMatricula.setBounds(34, 85, 171, 27);
		contentPane.add(CampoMatricula);
		
		JLabel Nome = new JLabel("Nome");
		Nome.setBounds(34, 123, 66, 14);
		contentPane.add(Nome);
		
		JFormattedTextField CampoNome = new JFormattedTextField();
		CampoNome.setBounds(34, 136, 171, 27);
		contentPane.add(CampoNome);
		
		JLabel Senha = new JLabel("Senha");
		Senha.setBounds(34, 174, 46, 14);
		contentPane.add(Senha);
		
		CampoSenha = new JPasswordField();
		CampoSenha.setBounds(34, 188, 171, 27);
		contentPane.add(CampoSenha);
		
		JComboBox CampoSecretaria = new JComboBox();
		CampoSecretaria.setBounds(262, 85, 198, 27);
		contentPane.add(CampoSecretaria);
		
		JCheckBox PermADM = new JCheckBox("Permiss\u00E3o de Administrador");
		PermADM.setBounds(262, 138, 198, 23);
		contentPane.add(PermADM);
		
		JButton Cadastro = new JButton("Cadastrar");
		Cadastro.setBounds(291, 190, 130, 23);
		contentPane.add(Cadastro);
		
		JLabel TituloCadastro = new JLabel("Cadastro");
		TituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		TituloCadastro.setBounds(34, 22, 130, 27);
		contentPane.add(TituloCadastro);
	}
}
