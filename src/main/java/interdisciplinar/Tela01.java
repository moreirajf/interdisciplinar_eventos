package interdisciplinar;

import models.Organizador;
import models.Patrocinador;
import socket.DaoClienteSocket;
import utils.DadosLogado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosLogado.clientDAO=new DaoClienteSocket("localhost");
					Tela01 frame = new Tela01();
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
	public Tela01() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(20, 77, 61, 23);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(91, 78, 318, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 112, 61, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 109, 318, 20);
		contentPane.add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 45, 139, 22);
		comboBox.addItem("Patrocinador");
		comboBox.addItem("Organizador");
		contentPane.add(comboBox);
		
		JButton logar = new JButton("Entrar");
		logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Organizador")) {
					Organizador org=DadosLogado.clientDAO.loginOrganizador(textField.getText(),passwordField.getText());
					if(org==null){
						JOptionPane.showConfirmDialog(null,"Seu usuário ou senha podem estar incorretos. Verifique seu tipo de usuário");
					}
					else {
						JOptionPane.showConfirmDialog(null,"Deu bom");
						DadosLogado.cpfCnpj=org.getCpf_cnpj();
						TelaMenu telM = new TelaMenu();
						telM.setVisible(true);
						dispose();
					}


				}else if(comboBox.getSelectedItem().equals("Patrocinador")){
					Patrocinador pat=DadosLogado.clientDAO.loginPatrocinador(textField.getText(),passwordField.getText());
					if(pat==null){
						JOptionPane.showConfirmDialog(null,"Seu usuário ou senha podem estar incorretos. Verifique seu tipo de usuário");
					}
					else {
						JOptionPane.showConfirmDialog(null,"Deu bom");
						DadosLogado.cpfCnpj=pat.getCpfCnpj();
						MenuPatricinador menPa = new MenuPatricinador();
						menPa.setVisible(true);
						dispose();
					}

				}
				
			}
		});
		logar.setBounds(320, 140, 89, 23);
		contentPane.add(logar);
		
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cads = new Cadastro();
				cads.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(20, 140, 108, 23);
		contentPane.add(btnCadastrar);
		
	}
}
