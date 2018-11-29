package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 36, 64, 14);
		contentPane.add(lblData);
		
		JLabel lblDdmmaaaa = new JLabel("DD/MM/AAAA");
		lblDdmmaaaa.setBounds(84, 36, 124, 14);
		contentPane.add(lblDdmmaaaa);
		
		JLabel lblHorario = new JLabel("Horário:");
		lblHorario.setBounds(218, 36, 89, 14);
		contentPane.add(lblHorario);
		
		JLabel lblHhmm = new JLabel("HH:MM");
		lblHhmm.setBounds(320, 36, 104, 14);
		contentPane.add(lblHhmm);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 61, 104, 14);
		contentPane.add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 86, 414, 95);
		contentPane.add(textArea);
		
		JButton btnPatrocinarEsteEvento = new JButton("Patrocinar este evento");
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
			}
		});
		btnDespatrocinar.setBounds(218, 192, 206, 23);
		contentPane.add(btnDespatrocinar);
	}
}
