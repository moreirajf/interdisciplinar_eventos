package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocal frame = new AddLocal();
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
	public AddLocal() {
		setTitle("Adicionar Local");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(80, 8, 344, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 42, 63, 14);
		contentPane.add(lblEndereo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 39, 344, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblObservo = new JLabel("Observ\u00E7\u00E3o:");
		lblObservo.setBounds(10, 67, 63, 14);
		contentPane.add(lblObservo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 92, 414, 122);
		contentPane.add(textArea);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMenu tela = new TelaMenu();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
