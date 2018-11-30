package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Evento;
import utils.DadosLogado;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoEvenPatrocin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoEvenPatrocin frame = new InfoEvenPatrocin();
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
	public InfoEvenPatrocin() {
		setTitle("Informa\u00E7\u00F5es do evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 64, 14);
		contentPane.add(lblNome);
		
		JLabel lblEvento = new JLabel("Evento 1");
		lblEvento.setBounds(84, 11, 340, 14);
		contentPane.add(lblEvento);
		
		JLabel lblData = new JLabel("Inicio:");
		lblData.setBounds(10, 36, 64, 14);
		contentPane.add(lblData);
		
		JLabel lblInicio = new JLabel("DD/MM/AAAA");
		lblInicio.setBounds(84, 36, 124, 14);
		contentPane.add(lblInicio);
		
		JLabel lblHorario = new JLabel("Fim:");
		lblHorario.setBounds(218, 36, 89, 14);
		contentPane.add(lblHorario);
		
		JLabel lblFim = new JLabel("HH:MM");
		lblFim.setBounds(320, 36, 104, 14);
		contentPane.add(lblFim);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 61, 104, 14);
		contentPane.add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(10, 86, 414, 95);
		contentPane.add(textArea);
		
		JButton btnPatrocinarEsteEvento = new JButton("Patrocinar este evento");
		btnPatrocinarEsteEvento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DadosLogado.clientDAO.adicionarPatrocinio(DadosLogado.codEvent, DadosLogado.cpfCnpj);
				MenuPatricinador menuPatricinador=new MenuPatricinador();
				menuPatricinador.setVisible(true);
				dispose();
				
			}
		});
		btnPatrocinarEsteEvento.setBounds(10, 192, 198, 23);
		contentPane.add(btnPatrocinarEsteEvento);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPatricinador menP = new MenuPatricinador();
				menP.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnDespatrocinar = new JButton("Remover Patrocinio");
		btnDespatrocinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DadosLogado.clientDAO.removerPatrocinio(DadosLogado.codEvent, DadosLogado.cpfCnpj);
				MenuPatricinador menuPatricinador=new MenuPatricinador();
				menuPatricinador.setVisible(true);
				dispose();
				
			}
		});
		btnDespatrocinar.setBounds(218, 192, 206, 23);
		contentPane.add(btnDespatrocinar);
		
		if(DadosLogado.codEvent != -1) {
			Evento evento = DadosLogado.clientDAO.getEventosById(DadosLogado.codEvent);
			System.out.println(DadosLogado.cpfCnpj);
			if (DadosLogado.clientDAO.isPatrocinado(DadosLogado.codEvent, DadosLogado.cpfCnpj)){
				btnPatrocinarEsteEvento.setEnabled(false);
				btnDespatrocinar.setEnabled(true);
			}else {
				btnPatrocinarEsteEvento.setEnabled(true);
				btnDespatrocinar.setEnabled(false);
			}
			
			lblInicio.setText(evento.getInicio());
			lblFim.setText(evento.getFim());
			lblEvento.setText(evento.getNome());
			textArea.setText(evento.getDescricao());
		}
	
	}
}
