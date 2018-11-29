package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Evento;
import models.Local;
import models.TipoIngresso;
import utils.DadosLogado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddTipoIngresso extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textPreco;
	private JLabel lblPreo;
	private JLabel lblDescrio;
	private JTextArea textDescri;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JButton btnExcluir;

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
		
		textNome = new JTextField();
		textNome.setBounds(97, 8, 327, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 42, 46, 14);
		contentPane.add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(97, 39, 327, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 98, 63, 14);
		contentPane.add(lblDescrio);
		
		textDescri = new JTextArea();
		textDescri.setBounds(10, 115, 414, 101);
		contentPane.add(textDescri);
		
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
		
		final JComboBox<Evento> comboBox = new JComboBox<Evento>();
		ArrayList<Evento> eventos = DadosLogado.clientDAO.getEventosByOrganizador(DadosLogado.cpfCnpj);
		comboBox.setModel(new DefaultComboBoxModel<Evento>(eventos.toArray(new Evento[0])));
		
		comboBox.setBounds(97, 70, 130, 20);
		contentPane.add(comboBox);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(236, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int codEvent = ((Evento)comboBox.getSelectedItem()).getCodigo();
				TipoIngresso tipIngr;
				if(DadosLogado.codIngresso != -1) {
					tipIngr = new TipoIngresso(DadosLogado.codIngresso,textNome.getText(), textDescri.getText(),(Double)Double.valueOf(textPreco.getText()), codEvent);
				}else {
					tipIngr = new TipoIngresso(textNome.getText(), textDescri.getText(),(Double)Double.valueOf(textPreco.getText()), codEvent);
					
					
				}
				
				DadosLogado.clientDAO.salvarTipoIngresso(tipIngr);
				DadosLogado.codIngresso = -1;
				
				
			}
		});
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		if(DadosLogado.codIngresso != -1) {
			TipoIngresso tipoIngresso = DadosLogado.clientDAO.getTipoIngresso(DadosLogado.codIngresso);
			Evento evento = DadosLogado.clientDAO.getEventosById(tipoIngresso.getEvento_codigo());
			
			comboBox.setSelectedIndex(eventos.indexOf(evento));
			
			textDescri.setText(tipoIngresso.getDescricao());
			textNome.setText(tipoIngresso.getNome());
			textPreco.setText(String.valueOf(tipoIngresso.getPreco()));
			btnExcluir.setEnabled(true);
			
		}
		
		
	}
}
