package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ItemPedido;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FormPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDinheiro;
	private JTextField txtCartao;
	private JTextField txtCheque;
	JTextField txtTotalVenda;
	private JTextField txtTroco;
	ItemPedido obj = new ItemPedido();
	Cliente clientes = new Cliente();
	DefaultTableModel meus_produtos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPagamento frame = new FormPagamento();
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
	public FormPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 55);
		panel.setBackground(new Color(47, 45, 98));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPagamento = new JLabel("PAGAMENTO");
		lblPagamento.setBounds(254, 11, 166, 33);
		panel.add(lblPagamento);
		lblPagamento.setForeground(Color.BLACK);
		lblPagamento.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPagamento.setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("DINHEIRO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(247, 102, 94, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CARTÃO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(247, 154, 73, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CHEQUE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(247, 203, 73, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(247, 304, 73, 23);
		contentPane.add(lblNewLabel_3);
		
		txtDinheiro = new JTextField();
		txtDinheiro.setBounds(342, 107, 98, 29);
		contentPane.add(txtDinheiro);
		txtDinheiro.setColumns(10);
		
		txtCartao = new JTextField();
		txtCartao.setColumns(10);
		txtCartao.setBounds(342, 152, 98, 30);
		contentPane.add(txtCartao);
		
		txtCheque = new JTextField();
		txtCheque.setColumns(10);
		txtCheque.setBounds(342, 201, 98, 31);
		contentPane.add(txtCheque);
		
		txtTotalVenda = new JTextField();
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(342, 302, 98, 30);
		contentPane.add(txtTotalVenda);
		
		JLabel lblNewLabel_2_1 = new JLabel("TROCO:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(247, 249, 73, 23);
		contentPane.add(lblNewLabel_2_1);
		
		txtTroco = new JTextField();
		txtTroco.setColumns(10);
		txtTroco.setBounds(342, 248, 98, 29);
		contentPane.add(txtTroco);
	}

}
