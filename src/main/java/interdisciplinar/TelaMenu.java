package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarEventos = new JButton("Adicionar Eventos");
		btnAdicionarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEventos addE = new AddEventos();
				addE.setVisible(true);
				dispose();
			}
		});
		btnAdicionarEventos.setBounds(10, 11, 414, 23);
		contentPane.add(btnAdicionarEventos);
		
		JButton btnListarEventos = new JButton("Listar Eventos");
		btnListarEventos.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				ListarEventos listE = new ListarEventos();
				listE.setVisible(true);
				dispose();
				
			}
		});
		btnListarEventos.setBounds(10, 45, 414, 23);
		contentPane.add(btnListarEventos);
		
		JButton btnAdicionarTipoDe = new JButton("Adicionar Tipo de Ingresso");
		btnAdicionarTipoDe.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddTipoIngresso addI = new AddTipoIngresso();
				addI.setVisible(true);
				dispose();
			}
		});
		btnAdicionarTipoDe.setBounds(10, 79, 414, 23);
		contentPane.add(btnAdicionarTipoDe);
		
		JButton btnListarIngressos = new JButton("Listar Ingressos");
		btnListarIngressos.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				ListarIngressos listI = new ListarIngressos();
				listI.setVisible(true);
				dispose();
				
			}
		});
		btnListarIngressos.setBounds(10, 113, 414, 23);
		contentPane.add(btnListarIngressos);
		
		JButton btnAdicionarLocal = new JButton("Adicionar Local");
		btnAdicionarLocal.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				AddLocal addL = new AddLocal();
				addL.setVisible(true);
				dispose();
				
			}
		});
		btnAdicionarLocal.setBounds(10, 147, 414, 23);
		contentPane.add(btnAdicionarLocal);
		
		JButton btnListarLocais = new JButton("Listar Locais");
		btnListarLocais.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				ListarLocais listL = new ListarLocais();
				listL.setVisible(true);
				dispose();
				
			}
		});
		btnListarLocais.setBounds(10, 181, 414, 23);
		contentPane.add(btnListarLocais);
		
		JButton btnLoggoff = new JButton("LoggOFF");
		btnLoggoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela01 tel1 = new Tela01();
				tel1.setVisible(true);
				dispose();
			}
			
		});
		btnLoggoff.setBounds(10, 227, 414, 23);
		contentPane.add(btnLoggoff);
	}

}
