package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setResizable(false);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 68, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(88, 8, 336, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 42, 68, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 39, 336, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 73, 76, 14);
		contentPane.add(lblUsuario);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 70, 336, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 107, 68, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 101, 336, 20);
		contentPane.add(passwordField);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela01 tela1 = new Tela01();
				tela1.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Organizador");
		comboBox.addItem("Patrocinador");
		comboBox.setBounds(88, 194, 123, 22);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 202, 46, 14);
		contentPane.add(lblTipo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 163, 336, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		lblCpfcnpj.setBounds(10, 166, 68, 14);
		contentPane.add(lblCpfcnpj);
		
		JLabel lblConfirmao = new JLabel("Confirmação:");
		lblConfirmao.setBounds(10, 138, 76, 14);
		contentPane.add(lblConfirmao);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(88, 132, 336, 20);
		contentPane.add(passwordField_1);
	}
}
