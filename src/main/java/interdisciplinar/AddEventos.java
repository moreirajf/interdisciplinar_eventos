package interdisciplinar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class AddEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextArea textArea;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 358, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(10, 67, 46, 14);
		contentPane.add(lblInicio);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setBounds(10, 104, 46, 14);
		contentPane.add(lblFim);
		
		
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 129, 142, 14);
		contentPane.add(lblDescrio);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 154, 414, 62);
		contentPane.add(textArea);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telM = new TelaMenu();
				telM.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setBounds(10, 36, 58, 14);
		contentPane.add(lblImagem);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 33, 358, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		
		
		
		
		textField_1 = new JTextField();
		
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		
		contentPane.add(textField_4);
		textField_4.setColumns(10);
        
        DatePicker datePicker = new DatePicker();
        datePicker.setBounds(66, 65, 187, 25);
        contentPane.add(datePicker);
		
		
		
		
		// Create a date picker, and add it to the form.
        DatePicker datePicker1 = new DatePicker();
        datePicker1.setBounds(66, 104, 187, 25);
        contentPane.add(datePicker1);
        
        
        DateTimePicker dateTimePicker1 = new DateTimePicker();
        // To display this picker, uncomment this line.
        // add(dateTimePicker1);
        
        DateTimePicker dateTimePicker = new DateTimePicker();

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
		
        
		
		
	
	}
}
