package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Evento;
import utils.DadosLogado;

import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ListarEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVoltar; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarEventos frame = new ListarEventos();
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
	public ListarEventos() {
		setTitle("Listar Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 281, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telM = new TelaMenu();
				telM.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 414, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ArrayList<Evento> eventos = DadosLogado.clientDAO.getAllEventos();
		
		DefaultListModel dlm = new DefaultListModel();
		for(Evento p : eventos ){
		     dlm.addElement(p.getNome());
		}
		final JList list = new JList(dlm);
		
		list.setBounds(0, 169, 414, -168);
		panel.add(list);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				ArrayList<Evento> eventos = DadosLogado.clientDAO.buscarEventos(textField.getText());
				
				DefaultListModel dlm = new DefaultListModel();
				for(Evento p : eventos ){
				     dlm.addElement(p.getNome());
				}
				
				list.setModel(dlm);
				
				
				
			}
		});
		
		btnPesquisar.setBounds(301, 10, 123, 23);
		contentPane.add(btnPesquisar);
		
	}
}
