package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import connection.Conn;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Produto;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTable tableProduto;
	private JTextField textPesquisaProduto;
	private JTable tableCarrinho;
	private JTextField textTotal;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField txtPreco;
	private JTextField txtEstoque;
	private JTextField txtQuantidade;
	private JFormattedTextField txtData;
	private Cliente cliente;
	
	public void listarProdutos() throws SQLException {
        Connection conn = Conn.pegarConexao();
        ProdutoDAO dao = new ProdutoDAO(conn);
        List<Produto> lista = dao.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tableProduto.getModel();
        dados.setNumRows(0);
        for (Produto p : lista) {
            dados.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getQtd(),
            });
        }
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVenda frame = new FormVenda();
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
	public FormVenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					listarProdutos();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				txtData.setText(sdf.format(now));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 817, 61);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ponto de Vendas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 817, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 72, 481, 454);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("CPF:");
		lblNewLabel_1_3.setBounds(10, 21, 46, 14);
		panel_3.add(lblNewLabel_1_3);

		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField txtCpf = new JFormattedTextField(formatter);
		txtCpf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String cpf = txtCpf.getText();
					Connection conn = Conn.pegarConexao();
					ClienteDAO dao = new ClienteDAO();
					Cliente cliente = null;

					cliente = dao.Pesquisar(cpf);
					
					if (cliente != null && cliente.getCpf() != null) {
						txtNome.setText(cliente.getNome());
					} else {
						JOptionPane.showMessageDialog(null, "CPF Inválido");
					}
				}
			}
		});
		txtCpf.setText("");
		txtCpf.setBounds(63, 18, 112, 20);
		panel_3.add(txtCpf);

		JLabel lblNewLabel_1_2_2 = new JLabel("Nome:");
		lblNewLabel_1_2_2.setBounds(10, 46, 46, 14);
		panel_3.add(lblNewLabel_1_2_2);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(63, 43, 112, 20);
		panel_3.add(txtNome);

		JLabel lblNewLabel_1_3_1 = new JLabel("Data:");
		lblNewLabel_1_3_1.setBounds(281, 18, 46, 14);
		panel_3.add(lblNewLabel_1_3_1);

		txtData = new JFormattedTextField();
		txtData.setBounds(322, 15, 112, 20);
		panel_3.add(txtData);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpf.getText();
				Connection conn = Conn.pegarConexao();
				ClienteDAO dao = new ClienteDAO();
				Cliente cliente = null;
				cliente = dao.PesquisarCPF(cpf);

				if (cliente != null && cliente.getCpf() != null) {
					txtNome.setText(cliente.getNome());
				} else {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
			}
		});
		btnPesquisar.setBounds(199, 42, 89, 23);
		panel_3.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 463, 105);
		panel_3.add(scrollPane);

		tableProduto = new JTable();
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int selectedRow = tableProduto.getSelectedRow();
			    if (selectedRow != -1) { // Verifica se alguma linha está selecionada
			        Object codigo = tableProduto.getValueAt(selectedRow, 0);
			        Object produto = tableProduto.getValueAt(selectedRow, 1);
			        Object preco = tableProduto.getValueAt(selectedRow, 2);
			        Object estoque = tableProduto.getValueAt(selectedRow, 3);

			        // Verifica se os valores não são nulos antes de convertê-los para String
			        if (codigo != null) {
			            txtCodigo.setText(codigo.toString());
			        }
			        if (produto != null) {
			            txtProduto.setText(produto.toString());
			        }
			        if (preco != null) {
			            txtPreco.setText(preco.toString());
			        }
			        if (estoque != null) {
			            txtEstoque.setText(estoque.toString());
			        }
			    }
			}

		});
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Pre\u00E7o", "QTD Estoque", "Fornecedor"
			}
		));
		scrollPane.setViewportView(tableProduto);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Pesquise o Produto aqui:");
		lblNewLabel_1_2_2_1.setBounds(20, 79, 155, 14);
		panel_3.add(lblNewLabel_1_2_2_1);

		textPesquisaProduto = new JTextField();
		textPesquisaProduto.setColumns(10);
		textPesquisaProduto.setBounds(173, 76, 154, 20);
		panel_3.add(textPesquisaProduto);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 220, 463, 223);
		panel_3.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(10, 32, 52, 14);
		panel_2.add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(61, 29, 46, 20);
		panel_2.add(txtCodigo);

		JLabel lblNewLabel_1_1 = new JLabel("Produto:");
		lblNewLabel_1_1.setBounds(10, 76, 52, 14);
		panel_2.add(lblNewLabel_1_1);

		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(61, 73, 80, 20);
		panel_2.add(txtProduto);

		JLabel lblNewLabel_1_2 = new JLabel("Preço:");
		lblNewLabel_1_2.setBounds(10, 121, 52, 14);
		panel_2.add(lblNewLabel_1_2);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(61, 118, 80, 20);
		panel_2.add(txtPreco);

		JLabel lblNewLabel_1_4 = new JLabel("Estoque:");
		lblNewLabel_1_4.setBounds(10, 167, 52, 14);
		panel_2.add(lblNewLabel_1_4);

		txtEstoque = new JTextField();
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(61, 164, 80, 20);
		panel_2.add(txtEstoque);

		JButton btnAdicionar = new JButton("Adicionar Item");
		btnAdicionar.setBounds(151, 163, 119, 23);
		panel_2.add(btnAdicionar);

		JLabel lblNewLabel_1_5 = new JLabel("QTD:");
		lblNewLabel_1_5.setBounds(277, 118, 37, 14);
		panel_2.add(lblNewLabel_1_5);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(311, 115, 60, 20);
		panel_2.add(txtQuantidade);

		JButton btnProcurar = new JButton("Pesquisar");
		btnProcurar.setBounds(352, 72, 89, 23);
		panel_2.add(btnProcurar);

		JComboBox comboBoxDesconto = new JComboBox();
		comboBoxDesconto.setBounds(395, 24, 46, 22);
		panel_2.add(comboBoxDesconto);

		JLabel lblNewLabel_1_4_1 = new JLabel("Desconto:");
		lblNewLabel_1_4_1.setBounds(330, 28, 60, 14);
		panel_2.add(lblNewLabel_1_4_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Carrinho de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(493, 72, 314, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 294, 187);
		panel_1.add(scrollPane_1);

		tableCarrinho = new JTable();
		tableCarrinho.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo", "Produto", "QTD", "Pre\u00E7o", "Subtotal"
				}
				));
		tableCarrinho.getColumnModel().getColumn(2).setPreferredWidth(72);
		scrollPane_1.setViewportView(tableCarrinho);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Total da Venda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(491, 291, 316, 176);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("TOTAL:");
		lblNewLabel_1_1_1.setBounds(39, 57, 49, 14);
		panel_4.add(lblNewLabel_1_1_1);

		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(89, 47, 146, 34);
		panel_4.add(textTotal);

		JButton btnPagamento = new JButton("PAGAMENTO");
		btnPagamento.setBounds(39, 125, 112, 23);
		panel_4.add(btnPagamento);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(173, 125, 112, 23);
		panel_4.add(btnCancelar);
	}
}
