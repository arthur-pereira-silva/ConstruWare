package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormDetalheVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtId;
	public JTextField txtTotalVenda;
	public JTextField txtCliente;
	public JTextField txtDataVenda;
	public JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDetalheVenda frame = new FormDetalheVenda();
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
	public FormDetalheVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 623, 71);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDetalheDaVenda = new JLabel("DETALHE DA VENDA");
		lblDetalheDaVenda.setBounds(198, 11, 250, 49);
		lblDetalheDaVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalheDaVenda.setForeground(Color.WHITE);
		lblDetalheDaVenda.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblDetalheDaVenda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 77, 623, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id da Venda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 84, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(52, 66, 52, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data da Venda:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 113, 94, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblTotalDaVenda = new JLabel("Total da Venda:");
		lblTotalDaVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalDaVenda.setBounds(366, 65, 103, 14);
		panel_1.add(lblTotalDaVenda);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(111, 11, 46, 20);
		panel_1.add(txtId);
		txtId.setColumns(10);
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTotalVenda = new JTextField();
		txtTotalVenda.setEnabled(false);
		txtTotalVenda.setEditable(false);
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(468, 62, 103, 20);
		panel_1.add(txtTotalVenda);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnImprimir.setBounds(245, 170, 133, 45);
		panel_1.add(btnImprimir);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(110, 62, 219, 20);
		panel_1.add(txtCliente);
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			txtDataVenda = new JFormattedTextField(mask);
			txtDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDataVenda.setHorizontalAlignment(SwingConstants.CENTER);
			txtDataVenda.setEnabled(false);
			txtDataVenda.setEditable(false);
			txtDataVenda.setBounds(111, 111, 86, 20);
			panel_1.add(txtDataVenda);
			txtDataVenda.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 306, 623, 163);
			contentPane.add(scrollPane);
			
			tabela = new JTable();
			
			tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"C\u00F3digo", "Produto", "QTD.", "Pre\u00E7o", "Total"
				}
			));
			scrollPane.setViewportView(tabela);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
