package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormHistorico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFinal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHistorico frame = new FormHistorico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormHistorico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 697, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HISTÓRICO DE VENDAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(218, 11, 250, 55);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Consulta por Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 81, 697, 194);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Data Início:");
		lblNewLabel_1.setBounds(29, 65, 70, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Final:");
		lblNewLabel_1_1.setBounds(266, 65, 70, 14);
		panel_1.add(lblNewLabel_1_1);
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			txtDataInicio = new JFormattedTextField(mask);
			txtDataInicio.setBounds(100, 62, 86, 20);
			panel_1.add(txtDataInicio);
			txtDataInicio.setColumns(10);
			
			txtDataFinal = new JFormattedTextField(mask);
			txtDataFinal.setColumns(10);
			txtDataFinal.setBounds(337, 62, 86, 20);
			panel_1.add(txtDataFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(512, 61, 89, 23);
		panel_1.add(btnNewButton);
	}
}
