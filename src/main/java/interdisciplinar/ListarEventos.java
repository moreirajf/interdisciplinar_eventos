package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Evento;
import models.Organizador;
import models.TipoIngresso;
import utils.DadosLogado;

import java.awt.CardLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		
		final ArrayList<Evento> eventos = DadosLogado.clientDAO.getEventosByOrganizador(DadosLogado.cpfCnpj);

		final JList list = new JList(new String[]{"oi","tchau","mae"});
		list.setVisibleRowCount(12);
		DefaultListModel model;
		model = new DefaultListModel();
		for(Evento tp : eventos){
			model.addElement(tp.getNome());
		}
		list.setModel(model);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DadosLogado.codEvent=eventos.get(list.getSelectedIndex()).getCodigo();
				AddEventos addI = new AddEventos();
				addI.setVisible(true);
				dispose();
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel.setLayout(new BorderLayout());

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
