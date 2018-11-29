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
import javax.swing.JComboBox;

public class AddTipoIngresso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPreo;
	private JLabel lblDescrio;
	private JTextArea textArea;
	private JButton btnSalvar;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTipoIngresso frame = new AddTipoIngresso();
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
	public AddTipoIngresso() {
		setTitle("Adicionar Ingresso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(97, 8, 327, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 42, 46, 14);
		contentPane.add(lblPreo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 39, 327, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 98, 63, 14);
		contentPane.add(lblDescrio);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 115, 414, 101);
		contentPane.add(textArea);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu tela = new TelaMenu();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setBounds(10, 73, 46, 14);
		contentPane.add(lblEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 70, 130, 20);
		contentPane.add(comboBox);
		
		
	}
}
