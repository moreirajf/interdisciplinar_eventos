package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;

public class MenuPatricinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPatricinador frame = new MenuPatricinador();
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
	public MenuPatricinador() {
		setTitle("Menu Patrocidador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogoff = new JButton("LogOFF");
		btnLogoff.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Tela01 tel1 = new Tela01();
				tel1.setVisible(true);
				dispose();
			}
		});
		btnLogoff.setBounds(10, 227, 414, 23);
		contentPane.add(btnLogoff);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 414, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		list = new JList();
		list.setBounds(0, 173, 414, -172);
		panel.add(list);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 302, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoEvenPatrocin infEvenPatr = new InfoEvenPatrocin();
				infEvenPatr.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(322, 10, 102, 23);
		contentPane.add(btnBuscar);
	}
}
