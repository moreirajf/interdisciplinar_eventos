package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Organizador;
import models.Patrocinador;
import utils.DadosLogado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textUsuario;
	private JPasswordField pwSenha;
	private JTextField textcpf;
	private JPasswordField pwConfirmSenha;
	private JTextField textFone;

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
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 68, 14);
		contentPane.add(lblNome);
		
		textName = new JTextField();
		textName.setBounds(88, 8, 336, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 42, 68, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(88, 39, 336, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 73, 76, 14);
		contentPane.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(88, 70, 336, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 107, 68, 14);
		contentPane.add(lblSenha);
		
		pwSenha = new JPasswordField();
		pwSenha.setBounds(88, 101, 336, 20);
		contentPane.add(pwSenha);
		
		
		
		
		
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela01 tela1 = new Tela01();
				tela1.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 258, 89, 23);
		contentPane.add(btnVoltar);
		
		final JComboBox cmbTipo = new JComboBox();
		cmbTipo.addItem("Organizador");
		cmbTipo.addItem("Patrocinador");
		cmbTipo.setBounds(88, 225, 123, 22);
		contentPane.add(cmbTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 233, 46, 14);
		contentPane.add(lblTipo);
		
		textcpf = new JTextField();
		textcpf.setBounds(88, 163, 336, 20);
		contentPane.add(textcpf);
		textcpf.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		lblCpfcnpj.setBounds(10, 166, 68, 14);
		contentPane.add(lblCpfcnpj);
		
		JLabel lblConfirmao = new JLabel("Confirmação:");
		lblConfirmao.setBounds(10, 138, 76, 14);
		contentPane.add(lblConfirmao);
		
		pwConfirmSenha = new JPasswordField();
		pwConfirmSenha.setBounds(88, 132, 336, 20);
		contentPane.add(pwConfirmSenha);
		
		if (!pwSenha.equals(pwConfirmSenha)) {
			JOptionPane jp = new JOptionPane("Senhas não conincidem", JOptionPane.OK_OPTION);
		}
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 200, 76, 14);
		contentPane.add(lblTelefone);
		
		textFone = new JTextField();
		textFone.setBounds(88, 197, 336, 20);
		contentPane.add(textFone);
		textFone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Organizador orgnz = null;
				Patrocinador patroc = null;
				if (cmbTipo.getSelectedItem().equals("Organizador")) {
					if (!pwSenha.getText().equals(pwConfirmSenha.getText())) {
						JOptionPane.showMessageDialog(null, "Senhas não conincidem", "Erro", JOptionPane.WARNING_MESSAGE);
					}else {
						orgnz =  new Organizador(textcpf.getText(), textEmail.getText(), textFone.getText(), textName.getText(),textUsuario.getText(), pwSenha.getText());
					}
					DadosLogado.clientDAO.criarOrganizador(orgnz);
					
				}else if(cmbTipo.getSelectedItem().equals("Patrocinador")) {
					if (!pwSenha.getText().equals(pwConfirmSenha.getText())) {
						JOptionPane.showMessageDialog(null, "Senhas não conincidem", "Erro", JOptionPane.WARNING_MESSAGE);
					}else {
						patroc =  new Patrocinador(textcpf.getText(), textFone.getText(), textUsuario.getText(), pwSenha.getText(), textName.getText() );
					}
					
					DadosLogado.clientDAO.criarPatrocinador(patroc);
				}
								
			}
		});
		btnSalvar.setBounds(335, 258, 89, 23);
		contentPane.add(btnSalvar);
	}
}
