package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Evento;
import models.Local;
import models.TipoIngresso;
import utils.DadosLogado;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListarLocais extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVoltar;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLocais frame = new ListarLocais();
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
	public ListarLocais() {
		setTitle("Listar Locais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 291, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 414, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		final ArrayList<Local> locais = DadosLogado.clientDAO.getAllLocais();

		final JList list = new JList(new String[]{"oi","tchau","mae"});
		list.setVisibleRowCount(12);
		DefaultListModel model;
		model = new DefaultListModel();
		for(Local tp : locais){
			model.addElement(tp.getNome());
		}
		list.setModel(model);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				System.out.println(locais.get(list.getSelectedIndex()).getCodigo());
				DadosLogado.codLocal=locais.get(list.getSelectedIndex()).getCodigo();
				AddLocal addI = new AddLocal();
				addI.setVisible(true);
				dispose();
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel.setLayout(new BorderLayout());

		panel.add(list);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaM = new TelaMenu();
				telaM.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				ArrayList<Local> locais = DadosLogado.clientDAO.buscarLocal(textField.getText());
				
				DefaultListModel dlm = new DefaultListModel();
				for(Local p : locais ){
				     dlm.addElement(p.getNome());
				}
				list.setModel(dlm);
				
			}
		});
		btnPesquisar.setBounds(311, 10, 113, 23);
		contentPane.add(btnPesquisar);
	}
}
