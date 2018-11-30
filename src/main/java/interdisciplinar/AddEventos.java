package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TexturePaint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;

import models.Evento;
import models.Local;
import socket.ClienteDao;
import utils.DadosLogado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textField_2;
	private JTextArea textArea;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JTextField textImg1;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textImg2;
	private JLabel lblLocal;
	private JTextField textField;
	private JTextField textcpf;
	private JTextField textCapac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEventos frame = new AddEventos();
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
	public AddEventos() {
		setTitle("Adicioar Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textName = new JTextField();
		textName.setBounds(76, 8, 348, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(10, 149, 46, 14);
		contentPane.add(lblInicio);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setBounds(10, 186, 46, 14);
		contentPane.add(lblFim);
		
		
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 248, 142, 14);
		contentPane.add(lblDescrio);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 273, 414, 68);
		contentPane.add(textArea);
		
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 352, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telM = new TelaMenu();
				telM.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JLabel lblImagem = new JLabel("Imagem1:");
		lblImagem.setBounds(10, 36, 67, 14);
		contentPane.add(lblImagem);
		
		textImg1 = new JTextField();
		textImg1.setBounds(76, 33, 348, 20);
		contentPane.add(textImg1);
		textImg1.setColumns(10);
		
		
		
		
		
		
		
		textField_1 = new JTextField();
		
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		
		contentPane.add(textField_4);
		textField_4.setColumns(10);
        
        final DatePicker datePicker = new DatePicker();
        datePicker.setBounds(66, 144, 187, 25);
        contentPane.add(datePicker);
		
		
		
		
		// Create a date picker, and add it to the form.
        final DatePicker datePicker1 = new DatePicker();
        datePicker1.setBounds(66, 181, 187, 25);
        contentPane.add(datePicker1);
        
        JLabel lblImagem_1 = new JLabel("Imagem2:");
        lblImagem_1.setBounds(10, 67, 67, 14);
        contentPane.add(lblImagem_1);
        
        textImg2 = new JTextField();
        textImg2.setBounds(76, 64, 348, 20);
        contentPane.add(textImg2);
        textImg2.setColumns(10);
        
        lblLocal = new JLabel("Local:");
		lblLocal.setBounds(10, 99, 67, 14);
		contentPane.add(lblLocal);
		
		final JComboBox<Local> comboBox = new JComboBox<Local>();
		ArrayList<Local> locais = DadosLogado.clientDAO.getAllLocais();
		comboBox.setModel(new DefaultComboBoxModel<Local>( locais.toArray(new Local[0])));
		
		comboBox.setBounds(76, 96, 142, 20);
		contentPane.add(comboBox);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setBounds(10, 124, 97, 14);
		contentPane.add(lblCapacidade);
		
		textCapac = new JTextField();
		textCapac.setBounds(117, 121, 86, 20);
		contentPane.add(textCapac);
		textCapac.setColumns(10);
		
        
       
        
        
        //DateTimePicker dateTimePicker1 = new DateTimePicker();
        // To display this picker, uncomment this line.
        // add(dateTimePicker1);
        
        //DateTimePicker dateTimePicker = new DateTimePicker();

        // Create a date picker with some custom settings. 
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
        DatePicker datePicker2 = new DatePicker(dateSettings);
        // To display this picker, uncomment this line.
        // add(datePicker2);
        
      
        
       
        
        

        // Create a time picker with some custom settings.
        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
        timeSettings.initialTime = LocalTime.now();
        TimePicker timePicker2 = new TimePicker(timeSettings);
        // To display this picker, uncomment this line.
        // add(timePicker2);
        
        btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int comb = ((Local)comboBox.getSelectedItem()).getCodigo();
				Evento evnt;
				
				if(DadosLogado.codEvent != -1) {
					evnt = new Evento( DadosLogado.codEvent,textArea.getText(), datePicker1.getDate().toString(), 
							datePicker.getDate().toString(), textName.getText(), (int) Integer.valueOf(textCapac.getText()), 
							comb , DadosLogado.cpfCnpj,textImg1.getText(), textImg2.getText());
				}else {
					evnt = new Evento(textArea.getText(), datePicker1.getDate().toString(), 
							datePicker.getDate().toString(), textName.getText(), (int) Integer.valueOf(textCapac.getText()), 
							comb , DadosLogado.cpfCnpj,textImg1.getText(), textImg2.getText());
				}
				
				DadosLogado.clientDAO.salvarEvento(evnt);
				TelaMenu tela = new TelaMenu();
				tela.setVisible(true);
				dispose();
				
				
			}
		});
		btnSalvar.setBounds(335, 352, 89, 23);
		contentPane.add(btnSalvar);
		
		 JButton btnExcluir = new JButton("Excluir");
	     btnExcluir.setEnabled(false);
	     btnExcluir.setBounds(236, 352, 89, 23);
	     contentPane.add(btnExcluir);
	     
	   /*  JLabel lblCpfcnpjOrganizador = new JLabel("CPF/CNPJ Organizador:");
	     lblCpfcnpjOrganizador.setBounds(10, 223, 163, 14);
	     contentPane.add(lblCpfcnpjOrganizador);
	     
	     textcpf = new JTextField();
	     textcpf.setBounds(155, 217, 269, 20);
	     contentPane.add(textcpf);
	     textcpf.setColumns(10);
		*/
		
        btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DadosLogado.clientDAO.deletarEvento(DadosLogado.clientDAO.getEventosById(DadosLogado.codEvent));
				DadosLogado.codEvent = -1;
				TelaMenu tela = new TelaMenu();
				tela.setVisible(true);
				dispose();
			}
		});
		
		if(DadosLogado.codEvent != -1) {
			Evento evento=DadosLogado.clientDAO.getEventosById(DadosLogado.codEvent);
			Local local = DadosLogado.clientDAO.getLocalEvento(DadosLogado.codEvent);
			textName.setText(evento.getNome());
			textImg1.setText(evento.getImg_link1());

			textImg2.setText(evento.getImg_link2());
			textCapac.setText(evento.getCapacidade()+"");

			textArea.setText(evento.getDescricao());

			datePicker.setDate(LocalDate.parse(evento.getInicio()));
			datePicker1.setDate(LocalDate.parse(evento.getFim()));
			comboBox.setSelectedIndex(locais.indexOf(local));
			btnExcluir.setEnabled(true);

		
		}
	
	}
}
