package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Evento;
import models.TipoIngresso;
import utils.DadosLogado;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JList;

public class ListarIngressos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarIngressos frame = new ListarIngressos();
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
	public ListarIngressos() {
		setTitle("Listar Ingressos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 273, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 414, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ArrayList<TipoIngresso> tipoIngressos = DadosLogado.clientDAO.getTipoIngressosOrganizador(DadosLogado.cpfCnpj);
		
		DefaultListModel dlm = new DefaultListModel();
		for(TipoIngresso p : tipoIngressos ){
		     dlm.addElement(p.getNome());
		}
		final JList list = new JList(dlm);
		
		list.setBounds(0, 171, 414, -170);
		panel.add(list);
		
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
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<TipoIngresso> tipoIngressos = DadosLogado.clientDAO.buscarTipoIngresso(textField.getText(), DadosLogado.cpfCnpj);
				
				DefaultListModel dlm = new DefaultListModel();
				for(TipoIngresso p : tipoIngressos ){
				     dlm.addElement(p.getNome());
				}
				list.setModel(dlm);
			}
		});
		
		
		btnPesquisar.setBounds(293, 10, 131, 23);
		contentPane.add(btnPesquisar);
	}
}
