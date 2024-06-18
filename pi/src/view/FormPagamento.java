package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dao.ItemPedidoDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Funcionario; // Make sure to import Funcionario
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

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
	Funcionario funcionario; // Add Funcionario
	DefaultTableModel meus_produtos;

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

	public FormPagamento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 55);
		panel.setBackground(new Color(3, 52, 124));
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
		lblNewLabel.setBounds(106, 103, 94, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CARTÃO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(106, 155, 73, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CHEQUE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(106, 204, 73, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("TOTAL:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(106, 305, 73, 23);
		contentPane.add(lblNewLabel_3);

		txtDinheiro = new JTextField();
		txtDinheiro.setBounds(201, 108, 98, 29);
		txtDinheiro.setText("0");
		contentPane.add(txtDinheiro);
		txtDinheiro.setColumns(10);

		txtCartao = new JTextField();
		txtCartao.setColumns(10);
		txtCartao.setBounds(201, 153, 98, 30);
		txtCartao.setText("0");
		contentPane.add(txtCartao);

		txtCheque = new JTextField();
		txtCheque.setColumns(10);
		txtCheque.setBounds(201, 202, 98, 31);
		txtCheque.setText("0");
		contentPane.add(txtCheque);

		txtTotalVenda = new JTextField();
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(201, 303, 98, 30);
		contentPane.add(txtTotalVenda);

		JLabel lblNewLabel_2_1 = new JLabel("TROCO:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(106, 250, 73, 23);
		contentPane.add(lblNewLabel_2_1);

		txtTroco = new JTextField();
		txtTroco.setColumns(10);
		txtTroco.setBounds(201, 249, 98, 29);
		contentPane.add(txtTroco);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(new Color(101, 146, 201));
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double dinheiro = Double.parseDouble(txtDinheiro.getText());
					double cartao = Double.parseDouble(txtCartao.getText());
					double cheque = Double.parseDouble(txtCheque.getText());
					double totalVenda = Double.parseDouble(getTxtTotalVenda().getText());
					double totalPago = dinheiro + cartao + cheque;
					double troco = totalPago - totalVenda;
					txtTroco.setText(String.format("%.2f", troco));

					if (totalPago >= totalVenda) {
						Pedido p = new Pedido();
						p.setCliente(clientes);
						Date agora = new Date();
						SimpleDateFormat dataEUA = new SimpleDateFormat("yyyy-MM-dd");
						String dataSqlServer = dataEUA.format(agora);
						p.setData(dataSqlServer);
						p.setTotal(totalVenda);
						PedidoDAO daop = new PedidoDAO();
						daop.salvar(p);
						p.setId(daop.retornaUltimoIdVenda());
						JOptionPane.showMessageDialog(null, "Id da Ultima Venda: " + p.getId());

						for (int i = 0; i < meus_produtos.getRowCount(); i++) {
							int qtd_estoque, qtd_comprada, qtd_atualizada;
							Produto produto = new Produto();
							ProdutoDAO daoprod = new ProdutoDAO();
							ItemPedido item = new ItemPedido();
							item.setPedido(p);
							produto.setId(Integer.parseInt(meus_produtos.getValueAt(i, 0).toString()));
							item.setProduto(produto);
							item.setQtd(Integer.parseInt(meus_produtos.getValueAt(i, 2).toString()));
							item.setSubtotal(Double.parseDouble(meus_produtos.getValueAt(i, 4).toString()));
							qtd_estoque = daoprod.retornaQtdAtual(produto.getId());
							qtd_comprada = Integer.parseInt(meus_produtos.getValueAt(i, 2).toString());
							qtd_atualizada = qtd_estoque - qtd_comprada;
							daoprod.baixaEstoque(produto.getId(), qtd_atualizada);
							ItemPedidoDAO ipdao = new ItemPedidoDAO();
							ipdao.salvar(item);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível realizar a Venda! O valor pago é menor que o valor da Venda");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.");
				}
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPagar.setBounds(397, 190, 138, 55);
		contentPane.add(btnPagar);
	}

	public JTextField getTxtTotalVenda() {
		return txtTotalVenda;
	}

	public void setTxtTotalVenda(JTextField txtTotalVenda) {
		this.txtTotalVenda = txtTotalVenda;
	}
}
