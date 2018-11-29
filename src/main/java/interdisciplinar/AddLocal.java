package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Local;
import utils.DadosLogado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEnd;
	private JTextArea textObs;

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
		
		textNome = new JTextField();
		textNome.setBounds(80, 8, 344, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 42, 63, 14);
		contentPane.add(lblEndereo);
		
		textEnd = new JTextField();
		textEnd.setBounds(80, 39, 344, 20);
		contentPane.add(textEnd);
		textEnd.setColumns(10);
		
		JLabel lblObservo = new JLabel("Observ\u00E7\u00E3o:");
		lblObservo.setBounds(10, 67, 63, 14);
		contentPane.add(lblObservo);
		
		textObs = new JTextArea();
		textObs.setBounds(10, 92, 414, 122);
		contentPane.add(textObs);
		
		final JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(236, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Local lcl; 
				if(DadosLogado.codLocal != -1) {
					lcl = new Local(DadosLogado.codLocal,textNome.getText(), textEnd.getText(), textObs.getText());
				}else {
					lcl = new Local(textNome.getText(), textEnd.getText(), textObs.getText());
				}
				DadosLogado.clientDAO.salvarLocal(lcl);
				DadosLogado.codLocal = -1;
			}
		});
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
		
		
	
		if(DadosLogado.codLocal != -1) {
			Local local = DadosLogado.clientDAO.getLocalEvento(DadosLogado.codEvent);
			textNome.setText(local.getNome());
			textEnd.setText(local.getEndereco());
			textObs.setText(local.getObservacoes());
			btnExcluir.setEnabled(true);
		}
	}
	
	
}
