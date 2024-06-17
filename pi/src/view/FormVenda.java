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
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import utilitarios.Util;

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
	private JTable tabelaProduto;
	private JTextField textPesquisaProduto;
	private JTable tableCarrinho;
	private JTextField txtTotal;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField txtPreco;
	private JTextField txtEstoque;
	private JTextField txtQtd;
	private JFormattedTextField txtData;
	private Cliente cliente;
	
	Cliente obj = new Cliente();
	double preco, subtotal, total;
	Double qtd;
	DefaultTableModel meus_produtos;
	
	public void listarProdutos() throws SQLException {
        Connection conn = Conn.pegarConexao();
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
        dados.setNumRows(0);
        for (Produto p : lista) {
            dados.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getQtd(),
                p.getFornecedores()
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
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
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

	                cliente = dao.PesquisarCPF(cpf);

	                if (cliente != null && cliente.getCpf() != null) {
	                    txtNome.setText(cliente.getNome());
	                } else {
	                    JOptionPane.showMessageDialog(null, "CPF Inválido");
	                }
	                /*
	                 * if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                if (txtCodigo.getText() != null && !txtCodigo.getText().isEmpty()) {
	                    int codigo = Integer.parseInt(txtCodigo.getText());
	                    Produto obj = new Produto();
	                    ProdutoDAO dao = new ProdutoDAO();

	                    obj = dao.PesquisarCod(codigo);
	                    if (obj != null) {
	                        txtCodigo.setText(String.valueOf(obj.getId()));
	                        txtProduto.setText(String.valueOf(obj.getNome()));
	                        txtPreco.setText(String.valueOf(obj.getPreco()));
	                        txtEstoque.setText(String.valueOf(obj.getQtd()));
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Codigo Invalido");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Campo de Código está vazio");
	                }
	            }*/
	            }
	        }
	    });
	    txtCpf.setText("");
	    txtCpf.setBounds(63, 18, 95, 20);
	    panel_3.add(txtCpf);

	    JLabel lblNewLabel_1_2_2 = new JLabel("Nome:");
	    lblNewLabel_1_2_2.setBounds(10, 46, 46, 14);
	    panel_3.add(lblNewLabel_1_2_2);

	    txtNome = new JTextField();
	    txtNome.setColumns(10);
	    txtNome.setBounds(63, 43, 217, 20);
	    panel_3.add(txtNome);

	    JLabel lblNewLabel_1_3_1 = new JLabel("Data:");
	    lblNewLabel_1_3_1.setBounds(312, 21, 33, 14);
	    panel_3.add(lblNewLabel_1_3_1);

	    txtData = new JFormattedTextField();
	    txtData.setEnabled(false);
	    txtData.setEditable(false);
	    txtData.setBounds(345, 18, 112, 20);
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
	    btnPesquisar.setBounds(168, 17, 112, 23);
	    panel_3.add(btnPesquisar);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 104, 463, 105);
	    panel_3.add(scrollPane);

	    tabelaProduto = new JTable();
	    tabelaProduto.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            int selectedRow = tabelaProduto.getSelectedRow();
	            if (selectedRow != -1) {
	                Object codigo = tabelaProduto.getValueAt(selectedRow, 0);
	                Object produto = tabelaProduto.getValueAt(selectedRow, 1);
	                Object preco = tabelaProduto.getValueAt(selectedRow, 2);
	                Object estoque = tabelaProduto.getValueAt(selectedRow, 3);
	                Object fornecedor = tabelaProduto.getValueAt(selectedRow, 4);
	                txtCodigo.setEnabled(false);

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
	    tabelaProduto.setModel(new DefaultTableModel(
	        new Object[][] {
	        },
	        new String[] {
	            "Codigo", "Nome", "Preco", "QTD Estoque", "Fornecedor"
	        }
	    ));
	    scrollPane.setViewportView(tabelaProduto);

	    JLabel lblNewLabel_1_2_2_1 = new JLabel("Pesquise o Produto aqui:");
	    lblNewLabel_1_2_2_1.setBounds(20, 79, 155, 14);
	    panel_3.add(lblNewLabel_1_2_2_1);

	    textPesquisaProduto = new JTextField();
	    textPesquisaProduto.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String nome = "%"+textPesquisaProduto.getText()+"%";
				ProdutoDAO dao = new ProdutoDAO();
				List<Produto> lista = dao.Filtrar(nome);
				DefaultTableModel modelo = (DefaultTableModel) tabelaProduto.getModel();
				modelo.setRowCount(0); 
				for (Produto produto : lista) {
					modelo.addRow(new Object[]{
							produto.getId(),
							produto.getNome(),
							produto.getPreco(),
							produto.getQtd(),
							produto.getFornecedores()
					});
					txtCodigo.setEnabled(false);
				}
	    	}
	    });
	    textPesquisaProduto.setColumns(10);
	    textPesquisaProduto.setBounds(173, 76, 197, 20);
	    panel_3.add(textPesquisaProduto);

	    JPanel painel_dadosproduto = new JPanel();
	    painel_dadosproduto.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    painel_dadosproduto.setBounds(10, 220, 463, 223);
	    panel_3.add(painel_dadosproduto);
	    painel_dadosproduto.setLayout(null);

	    JLabel lblNewLabel_1 = new JLabel("Código:");
	    lblNewLabel_1.setBounds(10, 32, 52, 14);
	    painel_dadosproduto.add(lblNewLabel_1);

	    txtCodigo = new JTextField();
	    txtCodigo.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                if (txtCodigo.getText() != null && !txtCodigo.getText().isEmpty()) {
	                    int codigo = Integer.parseInt(txtCodigo.getText());
	                    Produto obj = new Produto();
	                    ProdutoDAO dao = new ProdutoDAO();

	                    obj = dao.PesquisarCod(codigo);
	                    if (obj != null) {
	                        txtCodigo.setText(String.valueOf(obj.getId()));
	                        txtProduto.setText(String.valueOf(obj.getNome()));
	                        txtPreco.setText(String.valueOf(obj.getPreco()));
	                        txtEstoque.setText(String.valueOf(obj.getQtd()));
	                        txtCodigo.setEnabled(false);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Codigo Invalido");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Campo de Código está vazio");
	                }
	            }
	        }
	    });
	    txtCodigo.setColumns(10);
	    txtCodigo.setBounds(61, 29, 46, 20);
	    painel_dadosproduto.add(txtCodigo);

	    JLabel lblNewLabel_1_1 = new JLabel("Produto:");
	    lblNewLabel_1_1.setBounds(10, 76, 52, 14);
	    painel_dadosproduto.add(lblNewLabel_1_1);

	    txtProduto = new JTextField();
	    txtProduto.setEnabled(false);
	    txtProduto.setEditable(false);
	    txtProduto.setColumns(10);
	    txtProduto.setBounds(61, 73, 215, 20);
	    painel_dadosproduto.add(txtProduto);

	    JLabel lblNewLabel_1_2 = new JLabel("Preço:");
	    lblNewLabel_1_2.setBounds(10, 121, 52, 14);
	    painel_dadosproduto.add(lblNewLabel_1_2);

	    txtPreco = new JTextField();
	    txtPreco.setEnabled(false);
	    txtPreco.setEditable(false);
	    txtPreco.setColumns(10);
	    txtPreco.setBounds(61, 118, 80, 20);
	    painel_dadosproduto.add(txtPreco);

	    JLabel lblNewLabel_1_4 = new JLabel("Estoque:");
	    lblNewLabel_1_4.setBounds(10, 167, 52, 14);
	    painel_dadosproduto.add(lblNewLabel_1_4);

	    txtEstoque = new JTextField();
	    txtEstoque.setEnabled(false);
	    txtEstoque.setEditable(false);
	    txtEstoque.setColumns(10);
	    txtEstoque.setBounds(61, 164, 80, 20);
	    painel_dadosproduto.add(txtEstoque);

	    JButton btnAdicionar = new JButton("Adicionar Item");
	    btnAdicionar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                String nome = txtProduto.getText();
	                ProdutoDAO daop = new ProdutoDAO();
	                Produto obj = daop.Pesquisar(nome);

	                if (obj != null && obj.getNome() != null) {
	                    double estoque = Double.valueOf(txtEstoque.getText());
	                    double quantidade = Integer.valueOf(txtQtd.getText());
	                    preco = Double.valueOf(txtPreco.getText());
	                    qtd = Double.valueOf(txtQtd.getText());
	                    subtotal = preco * qtd;
	                    total += subtotal;

	                    if (estoque >= quantidade) {
	                        txtTotal.setText(String.valueOf(total));
	                        meus_produtos = (DefaultTableModel) tableCarrinho.getModel();
	                        meus_produtos.addRow(new Object[]{
	                            txtCodigo.getText(),
	                            txtProduto.getText(),
	                            txtQtd.getText(),
	                            txtPreco.getText(),
	                            subtotal
	                        });
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Quantidade desejada é maior do que a do Estoque");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Produto não encontrado ou faltam informações");
	                }
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos para quantidade e preço");
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o item ao carrinho");
	            }
	        }
	    });
	    btnAdicionar.setBounds(195, 189, 119, 23);
	    painel_dadosproduto.add(btnAdicionar);

	    JLabel lblNewLabel_1_5 = new JLabel("QTD:");
	    lblNewLabel_1_5.setBounds(169, 121, 37, 14);
	    painel_dadosproduto.add(lblNewLabel_1_5);

	    txtQtd = new JTextField();
	    txtQtd.setText("1");
	    txtQtd.setColumns(10);
	    txtQtd.setBounds(216, 118, 60, 20);
	    painel_dadosproduto.add(txtQtd);

	    JButton btnProcurar = new JButton("Pesquisar");
	    btnProcurar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (txtCodigo.getText() != null && !txtCodigo.getText().isEmpty()) {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    Produto obj = new Produto();
                    ProdutoDAO dao = new ProdutoDAO();

                    obj = dao.PesquisarCod(codigo);
                    if (obj != null) {
                        txtCodigo.setText(String.valueOf(obj.getId()));
                        txtProduto.setText(String.valueOf(obj.getNome()));
                        txtPreco.setText(String.valueOf(obj.getPreco()));
                        txtEstoque.setText(String.valueOf(obj.getQtd()));
                        
                        txtCodigo.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo Invalido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo de Código está vazio");
                }
	    	}
	    });
	    btnProcurar.setBounds(117, 28, 89, 23);
	    painel_dadosproduto.add(btnProcurar);

	    JComboBox comboBoxDesconto = new JComboBox();
	    comboBoxDesconto.setBounds(353, 28, 46, 22);
	    painel_dadosproduto.add(comboBoxDesconto);

	    JLabel lblNewLabel_1_4_1 = new JLabel("Desconto:");
	    lblNewLabel_1_4_1.setBounds(291, 32, 60, 14);
	    painel_dadosproduto.add(lblNewLabel_1_4_1);
	    
	    JButton btnLimpar = new JButton("Limpar");
	    btnLimpar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Util util = new Util();
	    		util.LimpaTela(painel_dadosproduto);
	    		txtCodigo.setEnabled(true);
	    		txtCodigo.requestFocus();
	    	}
	    });
	    btnLimpar.setBounds(322, 189, 119, 23);
	    painel_dadosproduto.add(btnLimpar);

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
	            "Codigo", "Produto", "QTD", "Preco", "Subtotal"
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

	    txtTotal = new JTextField();
	    txtTotal.setColumns(10);
	    txtTotal.setBounds(89, 47, 146, 34);
	    panel_4.add(txtTotal);

	    JButton btnPagamento = new JButton("PAGAMENTO");
	    btnPagamento.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            String nome = txtNome.getText();
	            String cpf = txtCpf.getText();
	            Cliente obj = new Cliente();
	            ClienteDAO daoc = new ClienteDAO();
	            obj = daoc.Pesquisar(nome);
	            obj = daoc.PesquisarCPF(cpf);
	            if (obj.getNome() != null && obj.getCpf() != null) {
	                FormPagamento telaPag = new FormPagamento();
	                telaPag.clientes = obj;
	                telaPag.meus_produtos = meus_produtos;
	                telaPag.txtTotalVenda.setText(String.valueOf(total));
	                telaPag.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
	            }
	        }
	    });
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