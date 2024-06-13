package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.FornDAO;
import dao.ProdutoDAO;
import model.Fornecedor;
import model.Produto;
import utilitarios.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class FormProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtId;
	private JComboBox<Fornecedor> cbFornecedor; 
	private JTextField txtPesquisaNome;
	private JTable tabela;
	private JTextField txtQtdEstoque;

	private void atualizarTabela() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listarProdutos();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setRowCount(0); 
		for (Produto produto : lista) {
			modelo.addRow(new Object[]{
					produto.getId(),
					produto.getNome(),
					produto.getPreco(),
					produto.getQtd(),
					produto.getFornecedores()
			});
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.atualizarTabela();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FormProduto() throws ParseException {
		setResizable(false);
		setTitle("Formulário de Produtos");
		setBackground(new Color(127, 127, 127));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 127, 127));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(12, 12, 1, 1);
		contentPane.add(desktopPane);
		panel.setBackground(new Color(47, 45, 98));
		panel.setBounds(0, 0, 714, 40);
		contentPane.add(panel);

		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroDeProdutos.setBackground(new Color(0, 0, 0));
		lblCadastroDeProdutos.setFont(new Font("Liberation Sans", Font.BOLD, 25));
		lblCadastroDeProdutos.setForeground(new Color(0, 0, 0));
		panel.add(lblCadastroDeProdutos);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(47, 45, 98));
		tabbedPane.setBounds(-2, 46, 730, 300);
		contentPane.add(tabbedPane);

		JPanel dadosPessoais = new JPanel();
		dadosPessoais.setBorder(null);
		dadosPessoais.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Dados Pessoais", null, dadosPessoais, null);
		tabbedPane.setEnabledAt(0, true);
		dadosPessoais.setLayout(null);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					Produto obj = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					Fornecedor f = new Fornecedor();
					FornDAO daof = new FornDAO();

					obj = dao.Pesquisar(nome);
					if(obj != null && obj.getNome() != null) {
						txtId.setText(String.valueOf(obj.getId()));
						txtNome.setText(obj.getNome());
						txtPreco.setText(String.valueOf(obj.getPreco()));
						txtQtdEstoque.setText(String.valueOf(obj.getQtd()));
						
						
//						cbFornecedor.setSelectedItem(obj.getFornecedores());
						f = daof.Pesquisar(obj.getFornecedores().getNome());
						cbFornecedor.getModel().setSelectedItem(f);

					} else{
						JOptionPane.showMessageDialog(null, "produto não encontrado!");
					}
				}
			}
		});

		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNome.setText("\n");
		txtNome.setColumns(10);
		txtNome.setBounds(111, 55, 342, 19);
		dadosPessoais.add(txtNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblNome.setBounds(43, 57, 60, 15);
		dadosPessoais.add(lblNome);

		JLabel lblUf = new JLabel("Fornecedor:");
		lblUf.setForeground(new Color(0, 0, 0));
		lblUf.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblUf.setBounds(43, 154, 94, 15);
		dadosPessoais.add(lblUf);

		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setForeground(new Color(0, 0, 0));
		lblPreco.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblPreco.setBounds(43, 87, 60, 15);
		dadosPessoais.add(lblPreco);

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtPreco.setBounds(111, 85, 342, 19);
		dadosPessoais.add(txtPreco);
		txtPreco.setColumns(10);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setForeground(new Color(0, 0, 0));
		btnNovo.setBackground(new Color(47, 45, 98));
		btnNovo.setIcon(new ImageIcon(FormProduto.class.getResource("/imagens/add.png")));
		btnNovo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnNovo.setBounds(57, 215, 114, 36);
		dadosPessoais.add(btnNovo);



		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(new Color(47, 45, 98));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setIcon(new ImageIcon(FormProduto.class.getResource("/imagens/salvar.png")));
		btnSalvar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Produto obj = new Produto();
				obj.setNome(txtNome.getText());
				obj.setPreco(Double.valueOf(txtPreco.getText()));
				obj.setQtd(Double.valueOf(txtQtdEstoque.getText()));
				obj.setFornecedores((Fornecedor)cbFornecedor.getSelectedItem()); //casting



				ProdutoDAO dao = new ProdutoDAO();	
				dao.Salvar(obj);
				Util util = new Util();
				util.LimpaTela(dadosPessoais);

			}
		});
		btnSalvar.setBounds(206, 215, 124, 36);
		dadosPessoais.add(btnSalvar);

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto obj = new Produto();
				obj.setId(Integer.valueOf(txtId.getText()));
				ProdutoDAO dao = new ProdutoDAO();
				dao.Excluir(obj);
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBackground(new Color(47, 45, 98));
		btnExcluir.setIcon(new ImageIcon(FormProduto.class.getResource("/imagens/excluir.png")));
		btnExcluir.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnExcluir.setBounds(521, 215, 135, 36);
		dadosPessoais.add(btnExcluir);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto obj = new Produto();
				obj.setId(Integer.valueOf(txtId.getText()));
				obj.setNome(txtNome.getText());
				obj.setPreco(Double.valueOf(txtPreco.getText()));
				obj.setQtd(Double.valueOf(txtQtdEstoque.getText()));
//				obj.setFornecedores((Fornecedor)cbFornecedor.getSelectedItem());
				Fornecedor f = new Fornecedor();
				f = (Fornecedor) cbFornecedor.getSelectedItem();
				obj.setFornecedores(f);
				ProdutoDAO daop = new ProdutoDAO();
				daop.Editar(obj);
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnEditar.setBackground(new Color(47, 45, 98));
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setIcon(new ImageIcon(FormProduto.class.getResource("/imagens/editar.png")));
		btnEditar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnEditar.setBounds(364, 215, 122, 36);
		dadosPessoais.add(btnEditar);

		JLabel lblCodigo = new JLabel("CÓDIGO:");
		lblCodigo.setForeground(new Color(0, 0, 0));
		lblCodigo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCodigo.setBounds(28, 14, 70, 15);
		dadosPessoais.add(lblCodigo);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtId.setBounds(100, 12, 70, 19);
		dadosPessoais.add(txtId);
		txtId.setColumns(10);

		cbFornecedor = new JComboBox<>();
		cbFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FornDAO dao = new FornDAO();
				List<Fornecedor> lista = dao.Listar();
				cbFornecedor.removeAllItems();
				for(Fornecedor f: lista) {
					cbFornecedor.addItem(f);
					
				}
			}
		});
		cbFornecedor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFornecedor.setModel(new DefaultComboBoxModel<>());
		cbFornecedor.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		cbFornecedor.setBounds(147, 154, 183, 19);
		dadosPessoais.add(cbFornecedor);

		JButton btnPesquisar_1 = new JButton("PESQUISAR");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				Produto obj = new Produto();
				ProdutoDAO dao = new ProdutoDAO();
				Fornecedor f = new Fornecedor();
				FornDAO daof = new FornDAO();

				obj = dao.Pesquisar(nome);
				if(obj != null && obj.getNome() != null) {
					txtId.setText(String.valueOf(obj.getId()));
					txtNome.setText(obj.getNome());
					txtPreco.setText(String.valueOf(obj.getPreco()));
					txtQtdEstoque.setText(String.valueOf(obj.getQtd()));
					
					
//					cbFornecedor.setSelectedItem(obj.getFornecedores());
					f = daof.Pesquisar(obj.getFornecedores().getNome());
					cbFornecedor.getModel().setSelectedItem(f);

				} else{
					JOptionPane.showMessageDialog(null, "produto não encontrado!");
				}
			}
		});
		btnPesquisar_1.setIcon(new ImageIcon(FormProduto.class.getResource("/imagens/pesquisar.png")));
		btnPesquisar_1.setForeground(Color.BLACK);
		btnPesquisar_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnPesquisar_1.setBackground(new Color(47, 45, 98));
		btnPesquisar_1.setBounds(523, 69, 156, 29);
		dadosPessoais.add(btnPesquisar_1);
		
		txtQtdEstoque = new JTextField();
		txtQtdEstoque.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtQtdEstoque.setColumns(10);
		txtQtdEstoque.setBounds(206, 115, 244, 19);
		dadosPessoais.add(txtQtdEstoque);
		
		JLabel lblQtdEstoque = new JLabel("Quantidade Estoque:");
		lblQtdEstoque.setForeground(Color.BLACK);
		lblQtdEstoque.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQtdEstoque.setBounds(43, 115, 156, 15);
		dadosPessoais.add(lblQtdEstoque);

		JPanel consultaProdutos = new JPanel();
		consultaProdutos.setBorder(null);
		consultaProdutos.setForeground(new Color(0, 0, 0));
		consultaProdutos.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Consulta de Produtos", null, consultaProdutos, null);
		consultaProdutos.setLayout(null);

		JLabel lblCpf_1_1_2 = new JLabel("NOME: ");
		lblCpf_1_1_2.setForeground(new Color(0, 0, 0));
		lblCpf_1_1_2.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1_2.setBounds(138, 14, 60, 15);
		consultaProdutos.add(lblCpf_1_1_2);

		txtPesquisaNome = new JTextField();
		txtPesquisaNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = "%"+txtPesquisaNome.getText()+"%";
				ProdutoDAO dao = new ProdutoDAO();
				List<Produto> lista = dao.Filtrar(nome);
				DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
				modelo.setRowCount(0); 
				for (Produto produto : lista) {
					modelo.addRow(new Object[]{
							produto.getId(),
							produto.getNome(),
							produto.getPreco(),
							produto.getQtd(),
							produto.getFornecedores()
					});
				}

			}
		});
		txtPesquisaNome.setText("\n");
		txtPesquisaNome.setColumns(10);
		txtPesquisaNome.setBounds(195, 12, 373, 19);
		consultaProdutos.add(txtPesquisaNome);

		JScrollPane painelDados = new JScrollPane();
		painelDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tabela.getSelectedRow();
				txtId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
				txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
				txtPreco.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
				txtQtdEstoque.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
				
				//cbFornecedor.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());

				Fornecedor f = new Fornecedor();
				FornDAO daof = new FornDAO();
				f = daof.Pesquisar(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
				cbFornecedor.removeAllItems();
				cbFornecedor.getModel().setSelectedItem(f);

				tabbedPane.setSelectedIndex(1);
			}
		});		
		tabela.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		tabela.setBorder(null);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdProduto", "Nome", "Preco", "QuantidadeEstoque", "Fornecedor"
			}
		));
		tabela.getColumnModel().getColumn(3).setPreferredWidth(111);
		painelDados.setViewportView(tabela);
		painelDados.setBounds(0, 40, 715, 219);
		consultaProdutos.add(painelDados);
	}
}
